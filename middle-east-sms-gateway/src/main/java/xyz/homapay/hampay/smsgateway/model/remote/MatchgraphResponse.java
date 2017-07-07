/**
 * MatchgraphResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class MatchgraphResponse implements java.io.Serializable {
    private java.lang.String matchgraphResult;

    public MatchgraphResponse() {
    }

    public MatchgraphResponse(
            java.lang.String matchgraphResult) {
        this.matchgraphResult = matchgraphResult;
    }


    /**
     * Gets the matchgraphResult value for this MatchgraphResponse.
     * 
     * @return matchgraphResult
     */
    public java.lang.String getMatchgraphResult() {
        return matchgraphResult;
    }


    /**
     * Sets the matchgraphResult value for this MatchgraphResponse.
     * 
     * @param matchgraphResult
     */
    public void setMatchgraphResult(java.lang.String matchgraphResult) {
        this.matchgraphResult = matchgraphResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MatchgraphResponse)) return false;
        MatchgraphResponse other = (MatchgraphResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.matchgraphResult == null && other.getMatchgraphResult() == null) ||
                        (this.matchgraphResult != null &&
                                this.matchgraphResult.equals(other.getMatchgraphResult())));
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
        if (getMatchgraphResult() != null) {
            _hashCode += getMatchgraphResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(MatchgraphResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">MatchgraphResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("matchgraphResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "MatchgraphResult"));
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
