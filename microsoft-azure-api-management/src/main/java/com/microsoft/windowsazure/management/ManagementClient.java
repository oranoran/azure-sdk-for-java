// 
// Copyright (c) Microsoft.  All rights reserved.
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//   http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// 
// See the License for the specific language governing permissions and
// limitations under the License.
// 

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management;

import com.microsoft.windowsazure.SubscriptionCloudCredentials;
import com.microsoft.windowsazure.management.AffinityGroupOperations;
import com.microsoft.windowsazure.management.LocationOperations;
import com.microsoft.windowsazure.management.ManagementCertificateOperations;
import com.microsoft.windowsazure.management.SubscriptionOperations;
import com.microsoft.windowsazure.management.models.OperationStatusResponse;
import com.microsoft.windowsazure.services.core.ServiceException;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.Future;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
* The Service Management API provides programmatic access to much of the
* functionality available through the Management Portal. The Service
* Management API is a REST API. All API operations are performed over SSL and
* mutually authenticated using X.509 v3 certificates.  (see
* http://msdn.microsoft.com/en-us/library/windowsazure/ee460799.aspx for more
* information)
*/
public interface ManagementClient
{
    /**
    * The URI used as the base for all Service Management requests.
    */
    URI getBaseUri(); 
    
    /**
    * When you create a Windows Azure subscription, it is uniquely identified
    * by a subscription ID. The subscription ID forms part of the URI for
    * every call that you make to the Service Management API.  The Windows
    * Azure Service ManagementAPI use mutual authentication of management
    * certificates over SSL to ensure that a request made to the service is
    * secure.  No anonymous requests are allowed.
    */
    SubscriptionCloudCredentials getCredentials(); 
    
    /**
    * Operations for managing affinity groups beneath your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460798.aspx for
    * more information)
    */
    AffinityGroupOperations getAffinityGroups(); 
    
    /**
    * The Service Management API includes operations for listing the available
    * data center locations for a hosted service in your subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg441299.aspx for
    * more information)
    */
    LocationOperations getLocations(); 
    
    /**
    * You can use management certificates, which are also known as subscription
    * certificates, to authenticate clients attempting to connect to resources
    * associated with your Windows Azure subscription.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/jj154124.aspx for
    * more information)
    */
    ManagementCertificateOperations getManagementCertificates(); 
    
    /**
    * Operation for listing subscription operations and details.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/gg715315.aspx for
    * more information)
    */
    SubscriptionOperations getSubscriptions(); 
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId The request ID for the request you wish to track. The
    * request ID is returned in the x-ms-request-id response header for every
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request.  If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    OperationStatusResponse getOperationStatus(String requestId) throws IOException, ServiceException, ParserConfigurationException, SAXException;
    
    /**
    * The Get Operation Status operation returns the status of thespecified
    * operation. After calling an asynchronous operation, you can call Get
    * Operation Status to determine whether the operation has succeeded,
    * failed, or is still in progress.  (see
    * http://msdn.microsoft.com/en-us/library/windowsazure/ee460783.aspx for
    * more information)
    *
    * @param requestId The request ID for the request you wish to track. The
    * request ID is returned in the x-ms-request-id response header for every
    * request.
    * @return The response body contains the status of the specified
    * asynchronous operation, indicating whether it has succeeded, is
    * inprogress, or has failed. Note that this status is distinct from the
    * HTTP status code returned for the Get Operation Status operation itself.
    * If the asynchronous operation succeeded, the response body includes the
    * HTTP status code for the successful request.  If the asynchronous
    * operation failed, the response body includes the HTTP status code for
    * the failed request, and also includes error information regarding the
    * failure.
    */
    Future<OperationStatusResponse> getOperationStatusAsync(String requestId);
}
