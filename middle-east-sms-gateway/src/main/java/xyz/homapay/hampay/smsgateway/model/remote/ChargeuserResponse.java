/**
 * ChargeuserResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ChargeuserResponse implements java.io.Serializable {
    private java.lang.String chargeuserResult;

    public ChargeuserResponse() {
    }

    public ChargeuserResponse(
            java.lang.String chargeuserResult) {
        this.chargeuserResult = chargeuserResult;
    }


    /**
     * Gets the chargeuserResult value for this ChargeuserResponse.
     * 
     * @return chargeuserResult
     */
    public java.lang.String getChargeuserResult() {
        return chargeuserResult;
    }


    /**
     * Sets the chargeuserResult value for this ChargeuserResponse.
     * 
     * @param chargeuserResult
     */
    public void setChargeuserResult(java.lang.String chargeuserResult) {
        this.chargeuserResult = chargeuserResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChargeuserResponse)) return false;
        ChargeuserResponse other = (ChargeuserResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.chargeuserResult == null && other.getChargeuserResult() == null) ||
                        (this.chargeuserResult != null &&
                                this.chargeuserResult.equals(other.getChargeuserResult())));
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
        if (getChargeuserResult() != null) {
            _hashCode += getChargeuserResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ChargeuserResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">chargeuserResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("chargeuserResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "chargeuserResult"));
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
