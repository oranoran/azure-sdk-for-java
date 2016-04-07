/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.management.resources.models.implementation.api;


/**
 * Resource group filter.
 */
public class ResourceGroupFilterInner {
    /**
     * Gets or sets the tag name.
     */
    private String tagName;

    /**
     * Gets or sets the tag value.
     */
    private String tagValue;

    /**
     * Get the tagName value.
     *
     * @return the tagName value
     */
    public String tagName() {
        return this.tagName;
    }

    /**
     * Set the tagName value.
     *
     * @param tagName the tagName value to set
     * @return the ResourceGroupFilterInner object itself.
     */
    public ResourceGroupFilterInner setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    /**
     * Get the tagValue value.
     *
     * @return the tagValue value
     */
    public String tagValue() {
        return this.tagValue;
    }

    /**
     * Set the tagValue value.
     *
     * @param tagValue the tagValue value to set
     * @return the ResourceGroupFilterInner object itself.
     */
    public ResourceGroupFilterInner setTagValue(String tagValue) {
        this.tagValue = tagValue;
        return this;
    }

}
