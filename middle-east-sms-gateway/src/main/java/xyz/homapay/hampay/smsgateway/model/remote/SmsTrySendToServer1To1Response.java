/**
 * SmsTrySendToServer1To1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SmsTrySendToServer1To1Response implements java.io.Serializable {
    private java.lang.String smsTrySendToServer1To1Result;

    public SmsTrySendToServer1To1Response() {
    }

    public SmsTrySendToServer1To1Response(
            java.lang.String smsTrySendToServer1To1Result) {
        this.smsTrySendToServer1To1Result = smsTrySendToServer1To1Result;
    }


    /**
     * Gets the smsTrySendToServer1To1Result value for this SmsTrySendToServer1To1Response.
     * 
     * @return smsTrySendToServer1To1Result
     */
    public java.lang.String getSmsTrySendToServer1To1Result() {
        return smsTrySendToServer1To1Result;
    }


    /**
     * Sets the smsTrySendToServer1To1Result value for this SmsTrySendToServer1To1Response.
     * 
     * @param smsTrySendToServer1To1Result
     */
    public void setSmsTrySendToServer1To1Result(java.lang.String smsTrySendToServer1To1Result) {
        this.smsTrySendToServer1To1Result = smsTrySendToServer1To1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SmsTrySendToServer1To1Response)) return false;
        SmsTrySendToServer1To1Response other = (SmsTrySendToServer1To1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.smsTrySendToServer1To1Result == null && other.getSmsTrySendToServer1To1Result() == null) ||
                        (this.smsTrySendToServer1To1Result != null &&
                                this.smsTrySendToServer1To1Result.equals(other.getSmsTrySendToServer1To1Result())));
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
        if (getSmsTrySendToServer1To1Result() != null) {
            _hashCode += getSmsTrySendToServer1To1Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SmsTrySendToServer1To1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SmsTrySendToServer1To1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("smsTrySendToServer1To1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "SmsTrySendToServer1To1Result"));
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
