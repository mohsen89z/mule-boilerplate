/**
 * SmsSentToServer1To1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SmsSentToServer1To1Response implements java.io.Serializable {
    private java.lang.String smsSentToServer1To1Result;

    public SmsSentToServer1To1Response() {
    }

    public SmsSentToServer1To1Response(
            java.lang.String smsSentToServer1To1Result) {
        this.smsSentToServer1To1Result = smsSentToServer1To1Result;
    }


    /**
     * Gets the smsSentToServer1To1Result value for this SmsSentToServer1To1Response.
     * 
     * @return smsSentToServer1To1Result
     */
    public java.lang.String getSmsSentToServer1To1Result() {
        return smsSentToServer1To1Result;
    }


    /**
     * Sets the smsSentToServer1To1Result value for this SmsSentToServer1To1Response.
     * 
     * @param smsSentToServer1To1Result
     */
    public void setSmsSentToServer1To1Result(java.lang.String smsSentToServer1To1Result) {
        this.smsSentToServer1To1Result = smsSentToServer1To1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SmsSentToServer1To1Response)) return false;
        SmsSentToServer1To1Response other = (SmsSentToServer1To1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.smsSentToServer1To1Result == null && other.getSmsSentToServer1To1Result() == null) ||
                        (this.smsSentToServer1To1Result != null &&
                                this.smsSentToServer1To1Result.equals(other.getSmsSentToServer1To1Result())));
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
        if (getSmsSentToServer1To1Result() != null) {
            _hashCode += getSmsSentToServer1To1Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SmsSentToServer1To1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SmsSentToServer1To1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsSentToServer1To1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SmsSentToServer1To1Result"));
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
