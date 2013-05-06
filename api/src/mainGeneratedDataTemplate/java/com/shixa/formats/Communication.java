
package com.shixa.formats;

import java.util.List;
import javax.annotation.Generated;
import com.linkedin.data.DataMap;
import com.linkedin.data.schema.DataSchema;
import com.linkedin.data.schema.PathSpec;
import com.linkedin.data.schema.RecordDataSchema;
import com.linkedin.data.schema.UnionDataSchema;
import com.linkedin.data.template.DataTemplateUtil;
import com.linkedin.data.template.GetMode;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.data.template.SetMode;
import com.linkedin.data.template.UnionTemplate;


/**
 * create a profile for a user
 * 
 */
@Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/xavierquintuna/rest.li/apps/restlishixa/api/src/main/pegasus/com/shixa/formats/Communication.pdsc.", date = "Sun May 05 08:57:28 PDT 2013")
public class Communication
    extends RecordTemplate
{

    private final static Communication.Fields _fields = new Communication.Fields();
    private final static RecordDataSchema SCHEMA = ((RecordDataSchema) DataTemplateUtil.parseSchema("{\"type\":\"record\",\"name\":\"Communication\",\"namespace\":\"com.shixa.formats\",\"doc\":\"create a profile for a user\",\"fields\":[{\"name\":\"use_email\",\"type\":\"boolean\",\"optional\":true},{\"name\":\"use_twitter\",\"type\":[\"boolean\",\"string\"],\"optional\":true},{\"name\":\"contactme\",\"type\":\"boolean\"},{\"name\":\"voice\",\"type\":\"boolean\",\"optional\":true},{\"name\":\"sms\",\"type\":\"boolean\",\"optional\":true}]}"));
    private final static RecordDataSchema.Field FIELD_Use_email = SCHEMA.getField("use_email");
    private final static RecordDataSchema.Field FIELD_Use_twitter = SCHEMA.getField("use_twitter");
    private final static RecordDataSchema.Field FIELD_Contactme = SCHEMA.getField("contactme");
    private final static RecordDataSchema.Field FIELD_Voice = SCHEMA.getField("voice");
    private final static RecordDataSchema.Field FIELD_Sms = SCHEMA.getField("sms");

    public Communication() {
        super(new DataMap(), SCHEMA);
    }

    public Communication(DataMap data) {
        super(data, SCHEMA);
    }

    public static Communication.Fields fields() {
        return _fields;
    }

    /**
     * Existence checker for use_email
     * 
     * @see Fields#use_email
     */
    public boolean hasUse_email() {
        return contains(FIELD_Use_email);
    }

    /**
     * Remover for use_email
     * 
     * @see Fields#use_email
     */
    public void removeUse_email() {
        remove(FIELD_Use_email);
    }

    /**
     * Getter for use_email
     * 
     * @see Fields#use_email
     */
    public java.lang.Boolean isUse_email(GetMode mode) {
        return obtainDirect(FIELD_Use_email, java.lang.Boolean.class, mode);
    }

    /**
     * Getter for use_email
     * 
     * @see Fields#use_email
     */
    public java.lang.Boolean isUse_email() {
        return isUse_email(GetMode.STRICT);
    }

    /**
     * Setter for use_email
     * 
     * @see Fields#use_email
     */
    public Communication setUse_email(java.lang.Boolean value, SetMode mode) {
        putDirect(FIELD_Use_email, java.lang.Boolean.class, java.lang.Boolean.class, value, mode);
        return this;
    }

    /**
     * Setter for use_email
     * 
     * @see Fields#use_email
     */
    public Communication setUse_email(java.lang.Boolean value) {
        putDirect(FIELD_Use_email, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for use_email
     * 
     * @see Fields#use_email
     */
    public Communication setUse_email(boolean value) {
        putDirect(FIELD_Use_email, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for use_twitter
     * 
     * @see Fields#use_twitter
     */
    public boolean hasUse_twitter() {
        return contains(FIELD_Use_twitter);
    }

    /**
     * Remover for use_twitter
     * 
     * @see Fields#use_twitter
     */
    public void removeUse_twitter() {
        remove(FIELD_Use_twitter);
    }

    /**
     * Getter for use_twitter
     * 
     * @see Fields#use_twitter
     */
    public Communication.Use_twitter getUse_twitter(GetMode mode) {
        return obtainWrapped(FIELD_Use_twitter, Communication.Use_twitter.class, mode);
    }

    /**
     * Getter for use_twitter
     * 
     * @see Fields#use_twitter
     */
    public Communication.Use_twitter getUse_twitter() {
        return getUse_twitter(GetMode.STRICT);
    }

    /**
     * Setter for use_twitter
     * 
     * @see Fields#use_twitter
     */
    public Communication setUse_twitter(Communication.Use_twitter value, SetMode mode) {
        putWrapped(FIELD_Use_twitter, Communication.Use_twitter.class, value, mode);
        return this;
    }

    /**
     * Setter for use_twitter
     * 
     * @see Fields#use_twitter
     */
    public Communication setUse_twitter(Communication.Use_twitter value) {
        putWrapped(FIELD_Use_twitter, Communication.Use_twitter.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for contactme
     * 
     * @see Fields#contactme
     */
    public boolean hasContactme() {
        return contains(FIELD_Contactme);
    }

    /**
     * Remover for contactme
     * 
     * @see Fields#contactme
     */
    public void removeContactme() {
        remove(FIELD_Contactme);
    }

    /**
     * Getter for contactme
     * 
     * @see Fields#contactme
     */
    public java.lang.Boolean isContactme(GetMode mode) {
        return obtainDirect(FIELD_Contactme, java.lang.Boolean.class, mode);
    }

    /**
     * Getter for contactme
     * 
     * @see Fields#contactme
     */
    public java.lang.Boolean isContactme() {
        return isContactme(GetMode.STRICT);
    }

    /**
     * Setter for contactme
     * 
     * @see Fields#contactme
     */
    public Communication setContactme(java.lang.Boolean value, SetMode mode) {
        putDirect(FIELD_Contactme, java.lang.Boolean.class, java.lang.Boolean.class, value, mode);
        return this;
    }

    /**
     * Setter for contactme
     * 
     * @see Fields#contactme
     */
    public Communication setContactme(java.lang.Boolean value) {
        putDirect(FIELD_Contactme, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for contactme
     * 
     * @see Fields#contactme
     */
    public Communication setContactme(boolean value) {
        putDirect(FIELD_Contactme, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for voice
     * 
     * @see Fields#voice
     */
    public boolean hasVoice() {
        return contains(FIELD_Voice);
    }

    /**
     * Remover for voice
     * 
     * @see Fields#voice
     */
    public void removeVoice() {
        remove(FIELD_Voice);
    }

    /**
     * Getter for voice
     * 
     * @see Fields#voice
     */
    public java.lang.Boolean isVoice(GetMode mode) {
        return obtainDirect(FIELD_Voice, java.lang.Boolean.class, mode);
    }

    /**
     * Getter for voice
     * 
     * @see Fields#voice
     */
    public java.lang.Boolean isVoice() {
        return isVoice(GetMode.STRICT);
    }

    /**
     * Setter for voice
     * 
     * @see Fields#voice
     */
    public Communication setVoice(java.lang.Boolean value, SetMode mode) {
        putDirect(FIELD_Voice, java.lang.Boolean.class, java.lang.Boolean.class, value, mode);
        return this;
    }

    /**
     * Setter for voice
     * 
     * @see Fields#voice
     */
    public Communication setVoice(java.lang.Boolean value) {
        putDirect(FIELD_Voice, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for voice
     * 
     * @see Fields#voice
     */
    public Communication setVoice(boolean value) {
        putDirect(FIELD_Voice, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Existence checker for sms
     * 
     * @see Fields#sms
     */
    public boolean hasSms() {
        return contains(FIELD_Sms);
    }

    /**
     * Remover for sms
     * 
     * @see Fields#sms
     */
    public void removeSms() {
        remove(FIELD_Sms);
    }

    /**
     * Getter for sms
     * 
     * @see Fields#sms
     */
    public java.lang.Boolean isSms(GetMode mode) {
        return obtainDirect(FIELD_Sms, java.lang.Boolean.class, mode);
    }

    /**
     * Getter for sms
     * 
     * @see Fields#sms
     */
    public java.lang.Boolean isSms() {
        return isSms(GetMode.STRICT);
    }

    /**
     * Setter for sms
     * 
     * @see Fields#sms
     */
    public Communication setSms(java.lang.Boolean value, SetMode mode) {
        putDirect(FIELD_Sms, java.lang.Boolean.class, java.lang.Boolean.class, value, mode);
        return this;
    }

    /**
     * Setter for sms
     * 
     * @see Fields#sms
     */
    public Communication setSms(java.lang.Boolean value) {
        putDirect(FIELD_Sms, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    /**
     * Setter for sms
     * 
     * @see Fields#sms
     */
    public Communication setSms(boolean value) {
        putDirect(FIELD_Sms, java.lang.Boolean.class, java.lang.Boolean.class, value, SetMode.DISALLOW_NULL);
        return this;
    }

    public static class Fields
        extends PathSpec
    {


        public Fields(List<java.lang.String> path, java.lang.String name) {
            super(path, name);
        }

        public Fields() {
            super();
        }

        public PathSpec use_email() {
            return new PathSpec(getPathComponents(), "use_email");
        }

        public com.shixa.formats.Communication.Use_twitter.Fields use_twitter() {
            return new com.shixa.formats.Communication.Use_twitter.Fields(getPathComponents(), "use_twitter");
        }

        public PathSpec contactme() {
            return new PathSpec(getPathComponents(), "contactme");
        }

        public PathSpec voice() {
            return new PathSpec(getPathComponents(), "voice");
        }

        public PathSpec sms() {
            return new PathSpec(getPathComponents(), "sms");
        }

    }

    @Generated(value = "com.linkedin.pegasus.generator.PegasusDataTemplateGenerator", comments = "LinkedIn Data Template. Generated from /Users/xavierquintuna/rest.li/apps/restlishixa/api/src/main/pegasus/com/shixa/formats/Communication.pdsc.", date = "Sun May 05 08:57:28 PDT 2013")
    public final static class Use_twitter
        extends UnionTemplate
    {

        private final static UnionDataSchema SCHEMA = ((UnionDataSchema) DataTemplateUtil.parseSchema("[\"boolean\",\"string\"]"));
        private final static DataSchema MEMBER_Boolean = SCHEMA.getType("boolean");
        private final static DataSchema MEMBER_String = SCHEMA.getType("string");

        public Use_twitter() {
            super(new DataMap(), SCHEMA);
        }

        public Use_twitter(Object data) {
            super(data, SCHEMA);
        }

        public boolean isBoolean() {
            return memberIs("boolean");
        }

        public java.lang.Boolean getBoolean() {
            return obtainDirect(MEMBER_Boolean, java.lang.Boolean.class, "boolean");
        }

        public void setBoolean(java.lang.Boolean value) {
            selectDirect(MEMBER_Boolean, java.lang.Boolean.class, java.lang.Boolean.class, "boolean", value);
        }

        public boolean isString() {
            return memberIs("string");
        }

        public java.lang.String getString() {
            return obtainDirect(MEMBER_String, java.lang.String.class, "string");
        }

        public void setString(java.lang.String value) {
            selectDirect(MEMBER_String, java.lang.String.class, java.lang.String.class, "string", value);
        }

        public static class Fields
            extends PathSpec
        {


            public Fields(List<java.lang.String> path, java.lang.String name) {
                super(path, name);
            }

            public Fields() {
                super();
            }

            public PathSpec Boolean() {
                return new PathSpec(getPathComponents(), "boolean");
            }

            public PathSpec String() {
                return new PathSpec(getPathComponents(), "string");
            }

        }

    }

}
