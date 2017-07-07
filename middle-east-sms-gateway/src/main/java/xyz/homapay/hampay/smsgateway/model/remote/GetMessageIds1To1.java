/**
 * GetMessageIds1To1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class GetMessageIds1To1 implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private java.lang.String cDomainname;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong nCustomerid;

    public GetMessageIds1To1() {
    }

    public GetMessageIds1To1(
            java.lang.String cUserName,
            java.lang.String cPassword,
            java.lang.String cDomainname,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong nCustomerid) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.cDomainname = cDomainname;
        this.nCustomerid = nCustomerid;
    }


    /**
     * Gets the cUserName value for this GetMessageIds1To1.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this GetMessageIds1To1.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this GetMessageIds1To1.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this GetMessageIds1To1.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the cDomainname value for this GetMessageIds1To1.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this GetMessageIds1To1.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the nCustomerid value for this GetMessageIds1To1.
     * 
     * @return nCustomerid
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getNCustomerid() {
        return nCustomerid;
    }


    /**
     * Sets the nCustomerid value for this GetMessageIds1To1.
     * 
     * @param nCustomerid
     */
    public void setNCustomerid(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong nCustomerid) {
        this.nCustomerid = nCustomerid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetMessageIds1To1)) return false;
        GetMessageIds1To1 other = (GetMessageIds1To1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cUserName == null && other.getCUserName() == null) ||
                        (this.cUserName != null &&
                                this.cUserName.equals(other.getCUserName()))) &&
                ((this.cPassword == null && other.getCPassword() == null) ||
                        (this.cPassword != null &&
                                this.cPassword.equals(other.getCPassword()))) &&
                ((this.cDomainname == null && other.getCDomainname() == null) ||
                        (this.cDomainname != null &&
                                this.cDomainname.equals(other.getCDomainname()))) &&
                ((this.nCustomerid == null && other.getNCustomerid() == null) ||
                        (this.nCustomerid != null &&
                                this.nCustomerid.equals(other.getNCustomerid())));
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
        if (getCUserName() != null) {
            _hashCode += getCUserName().hashCode();
        }
        if (getCPassword() != null) {
            _hashCode += getCPassword().hashCode();
        }
        if (getCDomainname() != null) {
            _hashCode += getCDomainname().hashCode();
        }
        if (getNCustomerid() != null) {
            _hashCode += getNCustomerid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(GetMessageIds1To1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">getMessageIds1to1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUserName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cUserName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cPassword"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDomainname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cDomainname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NCustomerid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nCustomerid"));
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
