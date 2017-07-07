/**
 * CheckFeeSms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class CheckFeeSms implements java.io.Serializable {
    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString cSystemChecker;

    public CheckFeeSms() {
    }

    public CheckFeeSms(
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString cSystemChecker) {
        this.cSystemChecker = cSystemChecker;
    }


    /**
     * Gets the cSystemChecker value for this CheckFeeSms.
     * 
     * @return cSystemChecker
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getCSystemChecker() {
        return cSystemChecker;
    }


    /**
     * Sets the cSystemChecker value for this CheckFeeSms.
     * 
     * @param cSystemChecker
     */
    public void setCSystemChecker(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString cSystemChecker) {
        this.cSystemChecker = cSystemChecker;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckFeeSms)) return false;
        CheckFeeSms other = (CheckFeeSms) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cSystemChecker == null && other.getCSystemChecker() == null) ||
                        (this.cSystemChecker != null &&
                                this.cSystemChecker.equals(other.getCSystemChecker())));
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
        if (getCSystemChecker() != null) {
            _hashCode += getCSystemChecker().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(CheckFeeSms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CheckFeeSms"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CSystemChecker");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cSystemChecker"));
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
