/**
 * ChangeReceiveNoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ChangeReceiveNoResponse implements java.io.Serializable {
    private java.lang.String changeReceiveNoResult;

    public ChangeReceiveNoResponse() {
    }

    public ChangeReceiveNoResponse(
            java.lang.String changeReceiveNoResult) {
        this.changeReceiveNoResult = changeReceiveNoResult;
    }


    /**
     * Gets the changeReceiveNoResult value for this ChangeReceiveNoResponse.
     * 
     * @return changeReceiveNoResult
     */
    public java.lang.String getChangeReceiveNoResult() {
        return changeReceiveNoResult;
    }


    /**
     * Sets the changeReceiveNoResult value for this ChangeReceiveNoResponse.
     * 
     * @param changeReceiveNoResult
     */
    public void setChangeReceiveNoResult(java.lang.String changeReceiveNoResult) {
        this.changeReceiveNoResult = changeReceiveNoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangeReceiveNoResponse)) return false;
        ChangeReceiveNoResponse other = (ChangeReceiveNoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.changeReceiveNoResult == null && other.getChangeReceiveNoResult() == null) ||
                        (this.changeReceiveNoResult != null &&
                                this.changeReceiveNoResult.equals(other.getChangeReceiveNoResult())));
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
        if (getChangeReceiveNoResult() != null) {
            _hashCode += getChangeReceiveNoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ChangeReceiveNoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ChangeReceiveNoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("changeReceiveNoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ChangeReceiveNoResult"));
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
