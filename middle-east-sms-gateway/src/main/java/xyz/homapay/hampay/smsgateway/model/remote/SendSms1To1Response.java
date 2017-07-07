/**
 * SendSms1To1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SendSms1To1Response implements java.io.Serializable {
    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong sendSms1To1Result;

    public SendSms1To1Response() {
    }

    public SendSms1To1Response(
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong sendSms1To1Result) {
        this.sendSms1To1Result = sendSms1To1Result;
    }


    /**
     * Gets the sendSms1To1Result value for this SendSms1To1Response.
     * 
     * @return sendSms1To1Result
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getSendSms1To1Result() {
        return sendSms1To1Result;
    }


    /**
     * Sets the sendSms1To1Result value for this SendSms1To1Response.
     * 
     * @param sendSms1To1Result
     */
    public void setSendSms1To1Result(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong sendSms1To1Result) {
        this.sendSms1To1Result = sendSms1To1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendSms1To1Response)) return false;
        SendSms1To1Response other = (SendSms1To1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.sendSms1To1Result == null && other.getSendSms1To1Result() == null) ||
                        (this.sendSms1To1Result != null &&
                                this.sendSms1To1Result.equals(other.getSendSms1To1Result())));
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
        if (getSendSms1To1Result() != null) {
            _hashCode += getSendSms1To1Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SendSms1To1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendSms1To1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendSms1To1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SendSms1To1Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfLong"));
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
