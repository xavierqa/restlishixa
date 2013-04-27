
package com.shixa.formats;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;


/**
 * Create a user for shixa
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /home/xavier/workspace/RestShiXa/api/src/main/pegasus/com/shixa/formats/User.pdsc.", date = "Fri Apr 26 15:46:13 PDT 2013")
public class User
    extends RecordTemplate
{

    private final static User.Fields _fields = new User.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"User\",\"namespace\":\"com.shixa.formats\",\"doc\":\"Create a user for shixa\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"username\",\"type\":\"string\"},{\"name\":\"password\",\"type\":\"string\"},{\"name\":\"email\",\"type\":\"string\"}]}"));
    private final static RecordDataSchema.Field FIELD_Id = SCHEMA.getField("id");
    private final static RecordDataSchema.Field FIELD_Username = SCHEMA.getField("username");
    private final static RecordDataSchema.Field FIELD_Password = SCHEMA.getField("password");
    private final static RecordDataSchema.Field FIELD_Email = SCHEMA.getField("email");

    public User() {
        super(new DataMap(), SCHEMA);
    }

    public User(DataMap data) {
        super(data, SCHEMA);
    }

    public static User.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for id
     * 
     * @see Fields#id
     */
    public boolean hasId() {
        return contains(FIELD_Id);
    }

    /**
     * Remover for id
     * 
     * @see Fields#id
     */
    public void removeId() {
        remove(FIELD_Id);
    }

    /**
     * Getter for id
     * 
     * @see Fields#id
     */
    public Long getId(GetMode mode) {
        return obtainDirect(FIELD_Id, Long.class, mode);
    }

    /**
     * Getter for id
     * 
     * @see Fields#id
     */
    public Long getId() {
        return getId(GetMode.STRICT);
    }

    /**
     * Setter for id
     * 
     * @see Fields#id
     */
    public User setId(Long value, SetMode mode) {
        putDirect(FIELD_Id, Long.class, Long.class, value, mode);
        return this;
    }

    /**
     * Setter for id
     * 
     * @see Fields#id
     */
    public User setId(Long value) {
        putDirect(FIELD_Id, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for id
     * 
     * @see Fields#id
     */
    public User setId(long value) {
        putDirect(FIELD_Id, Long.class, Long.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for username
     * 
     * @see Fields#username
     */
    public boolean hasUsername() {
        return contains(FIELD_Username);
    }

    /**
     * Remover for username
     * 
     * @see Fields#username
     */
    public void removeUsername() {
        remove(FIELD_Username);
    }

    /**
     * Getter for username
     * 
     * @see Fields#username
     */
    public String getUsername(GetMode mode) {
        return obtainDirect(FIELD_Username, String.class, mode);
    }

    /**
     * Getter for username
     * 
     * @see Fields#username
     */
    public String getUsername() {
        return getUsername(GetMode.STRICT);
    }

    /**
     * Setter for username
     * 
     * @see Fields#username
     */
    public User setUsername(String value, SetMode mode) {
        putDirect(FIELD_Username, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for username
     * 
     * @see Fields#username
     */
    public User setUsername(String value) {
        putDirect(FIELD_Username, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for password
     * 
     * @see Fields#password
     */
    public boolean hasPassword() {
        return contains(FIELD_Password);
    }

    /**
     * Remover for password
     * 
     * @see Fields#password
     */
    public void removePassword() {
        remove(FIELD_Password);
    }

    /**
     * Getter for password
     * 
     * @see Fields#password
     */
    public String getPassword(GetMode mode) {
        return obtainDirect(FIELD_Password, String.class, mode);
    }

    /**
     * Getter for password
     * 
     * @see Fields#password
     */
    public String getPassword() {
        return getPassword(GetMode.STRICT);
    }

    /**
     * Setter for password
     * 
     * @see Fields#password
     */
    public User setPassword(String value, SetMode mode) {
        putDirect(FIELD_Password, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for password
     * 
     * @see Fields#password
     */
    public User setPassword(String value) {
        putDirect(FIELD_Password, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for email
     * 
     * @see Fields#email
     */
    public boolean hasEmail() {
        return contains(FIELD_Email);
    }

    /**
     * Remover for email
     * 
     * @see Fields#email
     */
    public void removeEmail() {
        remove(FIELD_Email);
    }

    /**
     * Getter for email
     * 
     * @see Fields#email
     */
    public String getEmail(GetMode mode) {
        return obtainDirect(FIELD_Email, String.class, mode);
    }

    /**
     * Getter for email
     * 
     * @see Fields#email
     */
    public String getEmail() {
        return getEmail(GetMode.STRICT);
    }

    /**
     * Setter for email
     * 
     * @see Fields#email
     */
    public User setEmail(String value, SetMode mode) {
        putDirect(FIELD_Email, String.class, String.class, value, mode);
        return this;
    }

    /**
     * Setter for email
     * 
     * @see Fields#email
     */
    public User setEmail(String value) {
        putDirect(FIELD_Email, String.class, String.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    public static class Fields
        extends PathSpec
    {


        public Fields(List<String> path, String name) {
            super(path, name);
        }

        public Fields() {
            super();
        }

        public PathSpec id() {
            return new PathSpec(getPathComponents(), "id");
        }

        public PathSpec username() {
            return new PathSpec(getPathComponents(), "username");
        }

        public PathSpec password() {
            return new PathSpec(getPathComponents(), "password");
        }

        public PathSpec email() {
            return new PathSpec(getPathComponents(), "email");
        }

    }

}
