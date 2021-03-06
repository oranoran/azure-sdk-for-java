/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.search;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes an API key for a given Azure Search service that has permissions
 * for query operations only.
 */
public class QueryKey {
    /**
     * The name of the query API key; may be empty.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String name;

    /**
     * The value of the query API key.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String key;

    /**
     * Get the name value.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the key value.
     *
     * @return the key value
     */
    public String key() {
        return this.key;
    }

}
