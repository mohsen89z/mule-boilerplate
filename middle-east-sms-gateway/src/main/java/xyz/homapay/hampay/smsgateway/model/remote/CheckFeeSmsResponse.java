/**
 * CheckFeeSmsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class CheckFeeSmsResponse implements java.io.Serializable {
    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString checkFeeSmsResult;

    public CheckFeeSmsResponse() {
    }

    public CheckFeeSmsResponse(
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString checkFeeSmsResult) {
        this.checkFeeSmsResult = checkFeeSmsResult;
    }


    /**
     * Gets the checkFeeSmsResult value for this CheckFeeSmsResponse.
     * 
     * @return checkFeeSmsResult
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getCheckFeeSmsResult() {
        return checkFeeSmsResult;
    }


    /**
     * Sets the checkFeeSmsResult value for this CheckFeeSmsResponse.
     * 
     * @param checkFeeSmsResult
     */
    public void setCheckFeeSmsResult(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString checkFeeSmsResult) {
        this.checkFeeSmsResult = checkFeeSmsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckFeeSmsResponse)) return false;
        CheckFeeSmsResponse other = (CheckFeeSmsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.checkFeeSmsResult == null && other.getCheckFeeSmsResult() == null) ||
                        (this.checkFeeSmsResult != null &&
                                this.checkFeeSmsResult.equals(other.getCheckFeeSmsResult())));
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
        if (getCheckFeeSmsResult() != null) {
            _hashCode += getCheckFeeSmsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(CheckFeeSmsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CheckFeeSmsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkFeeSmsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CheckFeeSmsResult"));
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
