/**
 * GetSmsResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class GetSmsResponse implements java.io.Serializable {
    private java.lang.String getSmsResult;

    public GetSmsResponse() {
    }

    public GetSmsResponse(
            java.lang.String getSmsResult) {
        this.getSmsResult = getSmsResult;
    }


    /**
     * Gets the getSmsResult value for this GetSmsResponse.
     * 
     * @return getSmsResult
     */
    public java.lang.String getGetSmsResult() {
        return getSmsResult;
    }


    /**
     * Sets the getSmsResult value for this GetSmsResponse.
     * 
     * @param getSmsResult
     */
    public void setGetSmsResult(java.lang.String getSmsResult) {
        this.getSmsResult = getSmsResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetSmsResponse)) return false;
        GetSmsResponse other = (GetSmsResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.getSmsResult == null && other.getGetSmsResult() == null) ||
                        (this.getSmsResult != null &&
                                this.getSmsResult.equals(other.getGetSmsResult())));
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
        if (getGetSmsResult() != null) {
            _hashCode += getGetSmsResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(GetSmsResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetSmsResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getSmsResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetSmsResult"));
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
