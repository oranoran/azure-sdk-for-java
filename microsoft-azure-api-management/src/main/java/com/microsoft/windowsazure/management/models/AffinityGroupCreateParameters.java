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

package com.microsoft.windowsazure.management.models;

/**
* Parameters supplied to the Create Affinity Group operation.
*/
public class AffinityGroupCreateParameters
{
    private String description;
    
    /**
    * Optional. A description for the affinity group. The description can be up
    * to 1024 characters in length.
    */
    public String getDescription() { return this.description; }
    
    /**
    * Optional. A description for the affinity group. The description can be up
    * to 1024 characters in length.
    */
    public void setDescription(String description) { this.description = description; }
    
    private String label;
    
    /**
    * Required. A base-64 encoded name for the affinity group. The name can be
    * up to 100 characters in length.  Its value defaults to the Name of the
    * affinity group if not provided.
    */
    public String getLabel()
    {
        if (this.label == null)
        {
            return this.getName();
        }
        else
        {
            return this.label;
        }
    }
    
    /**
    * Required. A base-64 encoded name for the affinity group. The name can be
    * up to 100 characters in length.  Its value defaults to the Name of the
    * affinity group if not provided.
    */
    public void setLabel(String label) { this.label = label; }
    
    private String location;
    
    /**
    * Required. The data center location where the affinity group will be
    * created. To list available locations, see the List Locations operation.
    */
    public String getLocation() { return this.location; }
    
    /**
    * Required. The data center location where the affinity group will be
    * created. To list available locations, see the List Locations operation.
    */
    public void setLocation(String location) { this.location = location; }
    
    private String name;
    
    /**
    * Required. A name for the affinity group that is unique to the
    * subscription.
    */
    public String getName() { return this.name; }
    
    /**
    * Required. A name for the affinity group that is unique to the
    * subscription.
    */
    public void setName(String name) { this.name = name; }
    
    /**
    * Initializes a new instance of the AffinityGroupCreateParameters class.
    *
    */
    public AffinityGroupCreateParameters()
    {
    }
}
