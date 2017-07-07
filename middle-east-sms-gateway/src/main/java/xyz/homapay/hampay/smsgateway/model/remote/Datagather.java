/**
 * Datagather.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Datagather implements java.io.Serializable {
    private int naccountusesid;

    private boolean lsms;

    public Datagather() {
    }

    public Datagather(
            int naccountusesid,
            boolean lsms) {
        this.naccountusesid = naccountusesid;
        this.lsms = lsms;
    }


    /**
     * Gets the naccountusesid value for this Datagather.
     * 
     * @return naccountusesid
     */
    public int getNaccountusesid() {
        return naccountusesid;
    }


    /**
     * Sets the naccountusesid value for this Datagather.
     * 
     * @param naccountusesid
     */
    public void setNaccountusesid(int naccountusesid) {
        this.naccountusesid = naccountusesid;
    }


    /**
     * Gets the lsms value for this Datagather.
     * 
     * @return lsms
     */
    public boolean isLsms() {
        return lsms;
    }


    /**
     * Sets the lsms value for this Datagather.
     * 
     * @param lsms
     */
    public void setLsms(boolean lsms) {
        this.lsms = lsms;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Datagather)) return false;
        Datagather other = (Datagather) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.naccountusesid == other.getNaccountusesid() &&
                this.lsms == other.isLsms();
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
        _hashCode += getNaccountusesid();
        _hashCode += (isLsms() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Datagather.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">datagather"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("naccountusesid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "naccountusesid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lsms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "lsms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
