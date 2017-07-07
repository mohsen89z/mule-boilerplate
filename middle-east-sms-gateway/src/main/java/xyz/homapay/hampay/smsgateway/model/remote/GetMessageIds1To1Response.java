/**
 * GetMessageIds1To1Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class GetMessageIds1To1Response implements java.io.Serializable {
    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getMessageIds1To1Result;

    public GetMessageIds1To1Response() {
    }

    public GetMessageIds1To1Response(
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getMessageIds1To1Result) {
        this.getMessageIds1To1Result = getMessageIds1To1Result;
    }


    /**
     * Gets the getMessageIds1To1Result value for this GetMessageIds1To1Response.
     * 
     * @return getMessageIds1To1Result
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getGetMessageIds1To1Result() {
        return getMessageIds1To1Result;
    }


    /**
     * Sets the getMessageIds1To1Result value for this GetMessageIds1To1Response.
     * 
     * @param getMessageIds1To1Result
     */
    public void setGetMessageIds1To1Result(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getMessageIds1To1Result) {
        this.getMessageIds1To1Result = getMessageIds1To1Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMessageIds1To1Response)) return false;
        GetMessageIds1To1Response other = (GetMessageIds1To1Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.getMessageIds1To1Result == null && other.getGetMessageIds1To1Result() == null) ||
                        (this.getMessageIds1To1Result != null &&
                                this.getMessageIds1To1Result.equals(other.getGetMessageIds1To1Result())));
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
        if (getGetMessageIds1To1Result() != null) {
            _hashCode += getGetMessageIds1To1Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(GetMessageIds1To1Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getMessageIds1to1Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getMessageIds1To1Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "getMessageIds1to1Result"));
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
