/**
 * Deliver1Row.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Deliver1Row implements java.io.Serializable {
    private java.lang.String cEncrypt;

    private long ntag;

    private int status;

    private int nid;

    private int nreason;

    public Deliver1Row() {
    }

    public Deliver1Row(
            java.lang.String cEncrypt,
            long ntag,
            int status,
            int nid,
            int nreason) {
        this.cEncrypt = cEncrypt;
        this.ntag = ntag;
        this.status = status;
        this.nid = nid;
        this.nreason = nreason;
    }


    /**
     * Gets the cEncrypt value for this Deliver1Row.
     * 
     * @return cEncrypt
     */
    public java.lang.String getCEncrypt() {
        return cEncrypt;
    }


    /**
     * Sets the cEncrypt value for this Deliver1Row.
     * 
     * @param cEncrypt
     */
    public void setCEncrypt(java.lang.String cEncrypt) {
        this.cEncrypt = cEncrypt;
    }


    /**
     * Gets the ntag value for this Deliver1Row.
     * 
     * @return ntag
     */
    public long getNtag() {
        return ntag;
    }


    /**
     * Sets the ntag value for this Deliver1Row.
     * 
     * @param ntag
     */
    public void setNtag(long ntag) {
        this.ntag = ntag;
    }


    /**
     * Gets the status value for this Deliver1Row.
     * 
     * @return status
     */
    public int getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Deliver1Row.
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * Gets the nid value for this Deliver1Row.
     * 
     * @return nid
     */
    public int getNid() {
        return nid;
    }


    /**
     * Sets the nid value for this Deliver1Row.
     * 
     * @param nid
     */
    public void setNid(int nid) {
        this.nid = nid;
    }


    /**
     * Gets the nreason value for this Deliver1Row.
     * 
     * @return nreason
     */
    public int getNreason() {
        return nreason;
    }


    /**
     * Sets the nreason value for this Deliver1Row.
     * 
     * @param nreason
     */
    public void setNreason(int nreason) {
        this.nreason = nreason;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Deliver1Row)) return false;
        Deliver1Row other = (Deliver1Row) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cEncrypt == null && other.getCEncrypt() == null) ||
                        (this.cEncrypt != null &&
                                this.cEncrypt.equals(other.getCEncrypt()))) &&
                this.ntag == other.getNtag() &&
                this.status == other.getStatus() &&
                this.nid == other.getNid() &&
                this.nreason == other.getNreason();
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
        if (getCEncrypt() != null) {
            _hashCode += getCEncrypt().hashCode();
        }
        _hashCode += new Long(getNtag()).hashCode();
        _hashCode += getStatus();
        _hashCode += getNid();
        _hashCode += getNreason();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Deliver1Row.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Deliver1Row"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CEncrypt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cEncrypt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ntag");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "ntag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nreason");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nreason"));
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
