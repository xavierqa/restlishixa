
package com.shixa.formats;

import javax.annotation.Generated;
import com.linkedin.restli.client.base.CreateRequestBuilderBase;
import com.linkedin.restli.common.ResourceSpec;

@Generated(value = "com.linkedin.restli.tools.clientgen.RestRequestBuilderGenerator", comments = "LinkedIn Request Builder", date = "Mon Apr 29 14:06:27 PDT 2013")
public class UsersCreateBuilder
    extends CreateRequestBuilderBase<Long, User, UsersCreateBuilder>
{


    public UsersCreateBuilder(String baseUriTemplate, ResourceSpec resourceSpec) {
        super(baseUriTemplate, User.class, resourceSpec);
    }

}
