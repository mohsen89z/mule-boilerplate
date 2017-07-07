/**
 * CheckDeliverFromServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class CheckDeliverFromServer implements java.io.Serializable {
    private int nAccountUsesid;

    private int ntypeSms;

    public CheckDeliverFromServer() {
    }

    public CheckDeliverFromServer(
            int nAccountUsesid,
            int ntypeSms) {
        this.nAccountUsesid = nAccountUsesid;
        this.ntypeSms = ntypeSms;
    }


    /**
     * Gets the nAccountUsesid value for this CheckDeliverFromServer.
     * 
     * @return nAccountUsesid
     */
    public int getNAccountUsesid() {
        return nAccountUsesid;
    }


    /**
     * Sets the nAccountUsesid value for this CheckDeliverFromServer.
     * 
     * @param nAccountUsesid
     */
    public void setNAccountUsesid(int nAccountUsesid) {
        this.nAccountUsesid = nAccountUsesid;
    }


    /**
     * Gets the ntypeSms value for this CheckDeliverFromServer.
     * 
     * @return ntypeSms
     */
    public int getNtypeSms() {
        return ntypeSms;
    }


    /**
     * Sets the ntypeSms value for this CheckDeliverFromServer.
     * 
     * @param ntypeSms
     */
    public void setNtypeSms(int ntypeSms) {
        this.ntypeSms = ntypeSms;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CheckDeliverFromServer)) return false;
        CheckDeliverFromServer other = (CheckDeliverFromServer) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.nAccountUsesid == other.getNAccountUsesid() &&
                this.ntypeSms == other.getNtypeSms();
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
        _hashCode += getNAccountUsesid();
        _hashCode += getNtypeSms();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(CheckDeliverFromServer.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">CheckDeliverFromServer"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NAccountUsesid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nAccountUsesid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ntypeSms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ntypeSms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
