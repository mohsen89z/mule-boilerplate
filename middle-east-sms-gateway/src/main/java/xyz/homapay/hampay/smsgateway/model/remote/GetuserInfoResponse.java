/**
 * GetuserInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class GetuserInfoResponse implements java.io.Serializable {
    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getuserInfoResult;

    public GetuserInfoResponse() {
    }

    public GetuserInfoResponse(
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getuserInfoResult) {
        this.getuserInfoResult = getuserInfoResult;
    }


    /**
     * Gets the getuserInfoResult value for this GetuserInfoResponse.
     * 
     * @return getuserInfoResult
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getGetuserInfoResult() {
        return getuserInfoResult;
    }


    /**
     * Sets the getuserInfoResult value for this GetuserInfoResponse.
     * 
     * @param getuserInfoResult
     */
    public void setGetuserInfoResult(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getuserInfoResult) {
        this.getuserInfoResult = getuserInfoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetuserInfoResponse)) return false;
        GetuserInfoResponse other = (GetuserInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.getuserInfoResult == null && other.getGetuserInfoResult() == null) ||
                        (this.getuserInfoResult != null &&
                                this.getuserInfoResult.equals(other.getGetuserInfoResult())));
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
        if (getGetuserInfoResult() != null) {
            _hashCode += getGetuserInfoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(GetuserInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">GetuserInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("getuserInfoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "GetuserInfoResult"));
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
