/**
 * MehrafrazDelivery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class MehrafrazDelivery implements java.io.Serializable {
    private java.lang.String cCommand;

    private java.lang.String cFormatSms;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong asid;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt nsmsstatus;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString adate;

    public MehrafrazDelivery() {
    }

    public MehrafrazDelivery(
            java.lang.String cCommand,
            java.lang.String cFormatSms,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong asid,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt nsmsstatus,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString adate) {
        this.cCommand = cCommand;
        this.cFormatSms = cFormatSms;
        this.asid = asid;
        this.nsmsstatus = nsmsstatus;
        this.adate = adate;
    }


    /**
     * Gets the cCommand value for this MehrafrazDelivery.
     * 
     * @return cCommand
     */
    public java.lang.String getCCommand() {
        return cCommand;
    }


    /**
     * Sets the cCommand value for this MehrafrazDelivery.
     * 
     * @param cCommand
     */
    public void setCCommand(java.lang.String cCommand) {
        this.cCommand = cCommand;
    }


    /**
     * Gets the cFormatSms value for this MehrafrazDelivery.
     * 
     * @return cFormatSms
     */
    public java.lang.String getCFormatSms() {
        return cFormatSms;
    }


    /**
     * Sets the cFormatSms value for this MehrafrazDelivery.
     * 
     * @param cFormatSms
     */
    public void setCFormatSms(java.lang.String cFormatSms) {
        this.cFormatSms = cFormatSms;
    }


    /**
     * Gets the asid value for this MehrafrazDelivery.
     * 
     * @return asid
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getAsid() {
        return asid;
    }


    /**
     * Sets the asid value for this MehrafrazDelivery.
     * 
     * @param asid
     */
    public void setAsid(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong asid) {
        this.asid = asid;
    }


    /**
     * Gets the nsmsstatus value for this MehrafrazDelivery.
     * 
     * @return nsmsstatus
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt getNsmsstatus() {
        return nsmsstatus;
    }


    /**
     * Sets the nsmsstatus value for this MehrafrazDelivery.
     * 
     * @param nsmsstatus
     */
    public void setNsmsstatus(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt nsmsstatus) {
        this.nsmsstatus = nsmsstatus;
    }


    /**
     * Gets the adate value for this MehrafrazDelivery.
     * 
     * @return adate
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAdate() {
        return adate;
    }


    /**
     * Sets the adate value for this MehrafrazDelivery.
     * 
     * @param adate
     */
    public void setAdate(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString adate) {
        this.adate = adate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MehrafrazDelivery)) return false;
        MehrafrazDelivery other = (MehrafrazDelivery) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cCommand == null && other.getCCommand() == null) ||
                        (this.cCommand != null &&
                                this.cCommand.equals(other.getCCommand()))) &&
                ((this.cFormatSms == null && other.getCFormatSms() == null) ||
                        (this.cFormatSms != null &&
                                this.cFormatSms.equals(other.getCFormatSms()))) &&
                ((this.asid == null && other.getAsid() == null) ||
                        (this.asid != null &&
                                this.asid.equals(other.getAsid()))) &&
                ((this.nsmsstatus == null && other.getNsmsstatus() == null) ||
                        (this.nsmsstatus != null &&
                                this.nsmsstatus.equals(other.getNsmsstatus()))) &&
                ((this.adate == null && other.getAdate() == null) ||
                        (this.adate != null &&
                                this.adate.equals(other.getAdate())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCCommand() != null) {
            _hashCode += getCCommand().hashCode();
        }
        if (getCFormatSms() != null) {
            _hashCode += getCFormatSms().hashCode();
        }
        if (getAsid() != null) {
            _hashCode += getAsid().hashCode();
        }
        if (getNsmsstatus() != null) {
            _hashCode += getNsmsstatus().hashCode();
        }
        if (getAdate() != null) {
            _hashCode += getAdate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(MehrafrazDelivery.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">mehrafrazDelivery"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CCommand");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cCommand"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CFormatSms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFormatSms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("asid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "asid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfLong"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nsmsstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nsmsstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfInt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("adate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "adate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanSerializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

}
