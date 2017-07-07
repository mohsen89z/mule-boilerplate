/**
 * SmsSentToServer1To1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SmsSentToServer1To1 implements java.io.Serializable {
    private int naccountid;

    private java.lang.String cServerName;

    public SmsSentToServer1To1() {
    }

    public SmsSentToServer1To1(
            int naccountid,
            java.lang.String cServerName) {
        this.naccountid = naccountid;
        this.cServerName = cServerName;
    }


    /**
     * Gets the naccountid value for this SmsSentToServer1To1.
     * 
     * @return naccountid
     */
    public int getNaccountid() {
        return naccountid;
    }


    /**
     * Sets the naccountid value for this SmsSentToServer1To1.
     * 
     * @param naccountid
     */
    public void setNaccountid(int naccountid) {
        this.naccountid = naccountid;
    }


    /**
     * Gets the cServerName value for this SmsSentToServer1To1.
     * 
     * @return cServerName
     */
    public java.lang.String getCServerName() {
        return cServerName;
    }


    /**
     * Sets the cServerName value for this SmsSentToServer1To1.
     * 
     * @param cServerName
     */
    public void setCServerName(java.lang.String cServerName) {
        this.cServerName = cServerName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SmsSentToServer1To1)) return false;
        SmsSentToServer1To1 other = (SmsSentToServer1To1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.naccountid == other.getNaccountid() &&
                ((this.cServerName == null && other.getCServerName() == null) ||
                        (this.cServerName != null &&
                                this.cServerName.equals(other.getCServerName())));
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
        _hashCode += getNaccountid();
        if (getCServerName() != null) {
            _hashCode += getCServerName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SmsSentToServer1To1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SmsSentToServer1To1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("naccountid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "naccountid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CServerName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cServerName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
