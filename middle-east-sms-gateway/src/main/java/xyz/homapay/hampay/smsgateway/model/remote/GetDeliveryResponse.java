/**
 * GetDeliveryResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class GetDeliveryResponse implements java.io.Serializable {
    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getDeliveryResult;

    public GetDeliveryResponse() {
    }

    public GetDeliveryResponse(
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getDeliveryResult) {
        this.getDeliveryResult = getDeliveryResult;
    }


    /**
     * Gets the getDeliveryResult value for this GetDeliveryResponse.
     * 
     * @return getDeliveryResult
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getGetDeliveryResult() {
        return getDeliveryResult;
    }


    /**
     * Sets the getDeliveryResult value for this GetDeliveryResponse.
     * 
     * @param getDeliveryResult
     */
    public void setGetDeliveryResult(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getDeliveryResult) {
        this.getDeliveryResult = getDeliveryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDeliveryResponse)) return false;
        GetDeliveryResponse other = (GetDeliveryResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.getDeliveryResult == null && other.getGetDeliveryResult() == null) ||
                        (this.getDeliveryResult != null &&
                                this.getDeliveryResult.equals(other.getGetDeliveryResult())));
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
        if (getGetDeliveryResult() != null) {
            _hashCode += getGetDeliveryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(GetDeliveryResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetDeliveryResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getDeliveryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetDeliveryResult"));
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
