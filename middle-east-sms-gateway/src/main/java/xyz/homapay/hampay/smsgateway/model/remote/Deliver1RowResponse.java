/**
 * Deliver1RowResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Deliver1RowResponse implements java.io.Serializable {
    private java.lang.String deliver1RowResult;

    public Deliver1RowResponse() {
    }

    public Deliver1RowResponse(
            java.lang.String deliver1RowResult) {
        this.deliver1RowResult = deliver1RowResult;
    }


    /**
     * Gets the deliver1RowResult value for this Deliver1RowResponse.
     * 
     * @return deliver1RowResult
     */
    public java.lang.String getDeliver1RowResult() {
        return deliver1RowResult;
    }


    /**
     * Sets the deliver1RowResult value for this Deliver1RowResponse.
     * 
     * @param deliver1RowResult
     */
    public void setDeliver1RowResult(java.lang.String deliver1RowResult) {
        this.deliver1RowResult = deliver1RowResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Deliver1RowResponse)) return false;
        Deliver1RowResponse other = (Deliver1RowResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.deliver1RowResult == null && other.getDeliver1RowResult() == null) ||
                        (this.deliver1RowResult != null &&
                                this.deliver1RowResult.equals(other.getDeliver1RowResult())));
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
        if (getDeliver1RowResult() != null) {
            _hashCode += getDeliver1RowResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Deliver1RowResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Deliver1RowResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliver1RowResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Deliver1RowResult"));
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
