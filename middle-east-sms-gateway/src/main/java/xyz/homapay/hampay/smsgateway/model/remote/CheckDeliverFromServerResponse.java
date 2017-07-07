/**
 * CheckDeliverFromServerResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class CheckDeliverFromServerResponse implements java.io.Serializable {
    private java.lang.String checkDeliverFromServerResult;

    public CheckDeliverFromServerResponse() {
    }

    public CheckDeliverFromServerResponse(
            java.lang.String checkDeliverFromServerResult) {
        this.checkDeliverFromServerResult = checkDeliverFromServerResult;
    }


    /**
     * Gets the checkDeliverFromServerResult value for this CheckDeliverFromServerResponse.
     * 
     * @return checkDeliverFromServerResult
     */
    public java.lang.String getCheckDeliverFromServerResult() {
        return checkDeliverFromServerResult;
    }


    /**
     * Sets the checkDeliverFromServerResult value for this CheckDeliverFromServerResponse.
     * 
     * @param checkDeliverFromServerResult
     */
    public void setCheckDeliverFromServerResult(java.lang.String checkDeliverFromServerResult) {
        this.checkDeliverFromServerResult = checkDeliverFromServerResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckDeliverFromServerResponse)) return false;
        CheckDeliverFromServerResponse other = (CheckDeliverFromServerResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.checkDeliverFromServerResult == null && other.getCheckDeliverFromServerResult() == null) ||
                        (this.checkDeliverFromServerResult != null &&
                                this.checkDeliverFromServerResult.equals(other.getCheckDeliverFromServerResult())));
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
        if (getCheckDeliverFromServerResult() != null) {
            _hashCode += getCheckDeliverFromServerResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(CheckDeliverFromServerResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CheckDeliverFromServerResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("checkDeliverFromServerResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "CheckDeliverFromServerResult"));
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
