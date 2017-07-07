/**
 * Arziabi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Arziabi implements java.io.Serializable {
    private long naccountusesid;

    private boolean lSms;

    public Arziabi() {
    }

    public Arziabi(
            long naccountusesid,
            boolean lSms) {
        this.naccountusesid = naccountusesid;
        this.lSms = lSms;
    }


    /**
     * Gets the naccountusesid value for this Arziabi.
     * 
     * @return naccountusesid
     */
    public long getNaccountusesid() {
        return naccountusesid;
    }


    /**
     * Sets the naccountusesid value for this Arziabi.
     * 
     * @param naccountusesid
     */
    public void setNaccountusesid(long naccountusesid) {
        this.naccountusesid = naccountusesid;
    }


    /**
     * Gets the lSms value for this Arziabi.
     * 
     * @return lSms
     */
    public boolean isLSms() {
        return lSms;
    }


    /**
     * Sets the lSms value for this Arziabi.
     * 
     * @param lSms
     */
    public void setLSms(boolean lSms) {
        this.lSms = lSms;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Arziabi)) return false;
        Arziabi other = (Arziabi) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.naccountusesid == other.getNaccountusesid() &&
                this.lSms == other.isLSms();
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
        _hashCode += new Long(getNaccountusesid()).hashCode();
        _hashCode += (isLSms() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Arziabi.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Arziabi"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("naccountusesid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "naccountusesid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LSms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "lSms"));
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
