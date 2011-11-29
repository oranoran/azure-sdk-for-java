package com.microsoft.windowsazure.services.core;

import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RetryPolicyFilter implements ServiceFilter {
    private static final Log log = LogFactory.getLog(RetryPolicyFilter.class);
    private final RetryPolicy retryPolicy;

    public RetryPolicyFilter(RetryPolicy retryPolicy) {
        this.retryPolicy = retryPolicy;
    }

    @Override
    public Response handle(Request request, Next next) throws Exception {
        // Only the last added retry policy should be active
        if (request.getProperties().containsKey("RetryPolicy"))
            return next.handle(request);
        request.getProperties().put("RetryPolicy", this);

        // Retry the operation as long as retry policy tells us to do so
        for (int retryCount = 0;; ++retryCount) {
            // Mark the stream before passing the request through
            if (getEntityStream(request) != null) {
                getEntityStream(request).mark(Integer.MAX_VALUE);
            }

            // Pass the request to the next handler
            Response response = null;
            Exception error = null;
            try {
                response = next.handle(request);
            }
            catch (Exception e) {
                error = e;
            }

            // Determine if we should retry according to retry policy
            boolean shouldRetry = retryPolicy.shouldRetry(retryCount, response, error);
            if (!shouldRetry) {
                if (error != null)
                    throw error;
                return response;
            }

            // Reset the stream before retrying
            if (getEntityStream(request) != null) {
                getEntityStream(request).reset();
            }

            // Backoff for some time according to retry policy
            int backoffTime = retryPolicy.calculateBackoff(retryCount, response, error);
            log.info(String.format("Request failed. Backing off for %1s milliseconds before retrying (retryCount=%2d)",
                    backoffTime, retryCount));
            backoff(backoffTime);
        }
    }

    private InputStream getEntityStream(Request request) {
        if (request.getEntity() == null)
            return null;

        if (!(request.getEntity() instanceof InputStream))
            return null;

        InputStream entityStream = (InputStream) request.getEntity();

        // If the entity is an InputStream that doesn't support "mark/reset", we can't
        // implement a retry logic, so we simply throw.
        if (!entityStream.markSupported()) {
            throw new IllegalArgumentException("The input stream for the request entity must support 'mark' and "
                    + "'reset' to be compatible with a retry policy filter.");
        }

        return entityStream;
    }

    private void backoff(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
            // Restore the interrupted status
            Thread.currentThread().interrupt();
        }
    }
}
