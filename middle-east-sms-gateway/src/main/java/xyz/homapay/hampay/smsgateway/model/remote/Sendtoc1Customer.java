/**
 * Sendtoc1Customer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Sendtoc1Customer implements java.io.Serializable {
    private java.lang.String cAccountid;

    public Sendtoc1Customer() {
    }

    public Sendtoc1Customer(
            java.lang.String cAccountid) {
        this.cAccountid = cAccountid;
    }


    /**
     * Gets the cAccountid value for this Sendtoc1Customer.
     * 
     * @return cAccountid
     */
    public java.lang.String getCAccountid() {
        return cAccountid;
    }


    /**
     * Sets the cAccountid value for this Sendtoc1Customer.
     * 
     * @param cAccountid
     */
    public void setCAccountid(java.lang.String cAccountid) {
        this.cAccountid = cAccountid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sendtoc1Customer)) return false;
        Sendtoc1Customer other = (Sendtoc1Customer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cAccountid == null && other.getCAccountid() == null) ||
                        (this.cAccountid != null &&
                                this.cAccountid.equals(other.getCAccountid())));
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
        if (getCAccountid() != null) {
            _hashCode += getCAccountid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Sendtoc1Customer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Sendtoc1Customer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAccountid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cAccountid"));
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
