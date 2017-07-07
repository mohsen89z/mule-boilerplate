/**
 * GetDelivery.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class GetDelivery implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aSid;

    public GetDelivery() {
    }

    public GetDelivery(
            java.lang.String cUserName,
            java.lang.String cPassword,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aSid) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.aSid = aSid;
    }


    /**
     * Gets the cUserName value for this GetDelivery.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this GetDelivery.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this GetDelivery.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this GetDelivery.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the aSid value for this GetDelivery.
     * 
     * @return aSid
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getASid() {
        return aSid;
    }


    /**
     * Sets the aSid value for this GetDelivery.
     * 
     * @param aSid
     */
    public void setASid(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aSid) {
        this.aSid = aSid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDelivery)) return false;
        GetDelivery other = (GetDelivery) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cUserName == null && other.getCUserName() == null) ||
                        (this.cUserName != null &&
                                this.cUserName.equals(other.getCUserName()))) &&
                ((this.cPassword == null && other.getCPassword() == null) ||
                        (this.cPassword != null &&
                                this.cPassword.equals(other.getCPassword()))) &&
                ((this.aSid == null && other.getASid() == null) ||
                        (this.aSid != null &&
                                this.aSid.equals(other.getASid())));
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
        if (getCUserName() != null) {
            _hashCode += getCUserName().hashCode();
        }
        if (getCPassword() != null) {
            _hashCode += getCPassword().hashCode();
        }
        if (getASid() != null) {
            _hashCode += getASid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(GetDelivery.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetDelivery"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ASid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aSid"));
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
