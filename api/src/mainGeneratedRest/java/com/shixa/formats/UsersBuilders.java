
package com.shixa.formats;

import java.util.EnumSet;
import java.util.HashMap;
import javax.annotation.Generated;
import com.linkedin.data.template.DynamicRecordMetadata;
import com.linkedin.restli.common.ResourceMethod;
import com.linkedin.restli.common.ResourceSpec;
import com.linkedin.restli.common.ResourceSpecImpl;


/**
 * generated from: com.shixa.impl.UserResources
 * 
 */
@Generated(value = "com.linkedin.restli.tools.clientgen.RestRequestBuilderGenerator", comments = "LinkedIn Request Builder. Generated from /home/xavier/workspace/RestShiXa/api/build/tmp/generateMainGeneratedRestRestClient/clientInput/idl/com.shixa.formats.users.restspec.json.", date = "Mon Apr 29 14:06:27 PDT 2013")
public class UsersBuilders {

    private final String _baseUriTemplate;
    private final static ResourceSpec _resourceSpec;

    static {
        HashMap<String, Class<?>> keyParts = new HashMap<String, Class<?>>();
        HashMap<String, DynamicRecordMetadata> requestMetadataMap = new HashMap<String, DynamicRecordMetadata>();
        HashMap<String, DynamicRecordMetadata> responseMetadataMap = new HashMap<String, DynamicRecordMetadata>();
        _resourceSpec = new ResourceSpecImpl(EnumSet.of(ResourceMethod.CREATE), requestMetadataMap, responseMetadataMap, Long.class, null, null, User.class, keyParts);
    }

    public UsersBuilders() {
        _baseUriTemplate = "users";
    }

    public UsersBuilders(String primaryResourceName) {
        _baseUriTemplate = primaryResourceName;
    }

    public UsersCreateBuilder create() {
        return new UsersCreateBuilder(_baseUriTemplate, _resourceSpec);
    }

}
