/**
 * SmsSentToServerResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SmsSentToServerResponse implements java.io.Serializable {
    private java.lang.String smsSentToServerResult;

    public SmsSentToServerResponse() {
    }

    public SmsSentToServerResponse(
            java.lang.String smsSentToServerResult) {
        this.smsSentToServerResult = smsSentToServerResult;
    }


    /**
     * Gets the smsSentToServerResult value for this SmsSentToServerResponse.
     * 
     * @return smsSentToServerResult
     */
    public java.lang.String getSmsSentToServerResult() {
        return smsSentToServerResult;
    }


    /**
     * Sets the smsSentToServerResult value for this SmsSentToServerResponse.
     * 
     * @param smsSentToServerResult
     */
    public void setSmsSentToServerResult(java.lang.String smsSentToServerResult) {
        this.smsSentToServerResult = smsSentToServerResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SmsSentToServerResponse)) return false;
        SmsSentToServerResponse other = (SmsSentToServerResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.smsSentToServerResult == null && other.getSmsSentToServerResult() == null) ||
                        (this.smsSentToServerResult != null &&
                                this.smsSentToServerResult.equals(other.getSmsSentToServerResult())));
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
        if (getSmsSentToServerResult() != null) {
            _hashCode += getSmsSentToServerResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SmsSentToServerResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SmsSentToServerResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsSentToServerResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SmsSentToServerResult"));
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
