/**
 * SendHttpAutoAnswer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SendHttpAutoAnswer implements java.io.Serializable {
    private int nAccountusesid;

    private java.lang.String cpath;

    public SendHttpAutoAnswer() {
    }

    public SendHttpAutoAnswer(
            int nAccountusesid,
            java.lang.String cpath) {
        this.nAccountusesid = nAccountusesid;
        this.cpath = cpath;
    }


    /**
     * Gets the nAccountusesid value for this SendHttpAutoAnswer.
     * 
     * @return nAccountusesid
     */
    public int getNAccountusesid() {
        return nAccountusesid;
    }


    /**
     * Sets the nAccountusesid value for this SendHttpAutoAnswer.
     * 
     * @param nAccountusesid
     */
    public void setNAccountusesid(int nAccountusesid) {
        this.nAccountusesid = nAccountusesid;
    }


    /**
     * Gets the cpath value for this SendHttpAutoAnswer.
     * 
     * @return cpath
     */
    public java.lang.String getCpath() {
        return cpath;
    }


    /**
     * Sets the cpath value for this SendHttpAutoAnswer.
     * 
     * @param cpath
     */
    public void setCpath(java.lang.String cpath) {
        this.cpath = cpath;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendHttpAutoAnswer)) return false;
        SendHttpAutoAnswer other = (SendHttpAutoAnswer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.nAccountusesid == other.getNAccountusesid() &&
                ((this.cpath == null && other.getCpath() == null) ||
                        (this.cpath != null &&
                                this.cpath.equals(other.getCpath())));
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
        _hashCode += getNAccountusesid();
        if (getCpath() != null) {
            _hashCode += getCpath().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SendHttpAutoAnswer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendHttpAutoAnswer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAccountusesid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nAccountusesid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cpath"));
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
