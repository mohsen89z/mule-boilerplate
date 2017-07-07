/**
 * ChangeReceiveNo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ChangeReceiveNo implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private boolean lReceiveAllmsg;

    private java.lang.String cDomainName;

    private java.lang.String cFromNumber;

    public ChangeReceiveNo() {
    }

    public ChangeReceiveNo(
            java.lang.String cUserName,
            java.lang.String cPassword,
            boolean lReceiveAllmsg,
            java.lang.String cDomainName,
            java.lang.String cFromNumber) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.lReceiveAllmsg = lReceiveAllmsg;
        this.cDomainName = cDomainName;
        this.cFromNumber = cFromNumber;
    }


    /**
     * Gets the cUserName value for this ChangeReceiveNo.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this ChangeReceiveNo.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this ChangeReceiveNo.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this ChangeReceiveNo.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the lReceiveAllmsg value for this ChangeReceiveNo.
     * 
     * @return lReceiveAllmsg
     */
    public boolean isLReceiveAllmsg() {
        return lReceiveAllmsg;
    }


    /**
     * Sets the lReceiveAllmsg value for this ChangeReceiveNo.
     * 
     * @param lReceiveAllmsg
     */
    public void setLReceiveAllmsg(boolean lReceiveAllmsg) {
        this.lReceiveAllmsg = lReceiveAllmsg;
    }


    /**
     * Gets the cDomainName value for this ChangeReceiveNo.
     * 
     * @return cDomainName
     */
    public java.lang.String getCDomainName() {
        return cDomainName;
    }


    /**
     * Sets the cDomainName value for this ChangeReceiveNo.
     * 
     * @param cDomainName
     */
    public void setCDomainName(java.lang.String cDomainName) {
        this.cDomainName = cDomainName;
    }


    /**
     * Gets the cFromNumber value for this ChangeReceiveNo.
     * 
     * @return cFromNumber
     */
    public java.lang.String getCFromNumber() {
        return cFromNumber;
    }


    /**
     * Sets the cFromNumber value for this ChangeReceiveNo.
     * 
     * @param cFromNumber
     */
    public void setCFromNumber(java.lang.String cFromNumber) {
        this.cFromNumber = cFromNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChangeReceiveNo)) return false;
        ChangeReceiveNo other = (ChangeReceiveNo) obj;
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
                this.lReceiveAllmsg == other.isLReceiveAllmsg() &&
                ((this.cDomainName == null && other.getCDomainName() == null) ||
                        (this.cDomainName != null &&
                                this.cDomainName.equals(other.getCDomainName()))) &&
                ((this.cFromNumber == null && other.getCFromNumber() == null) ||
                        (this.cFromNumber != null &&
                                this.cFromNumber.equals(other.getCFromNumber())));
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
        _hashCode += (isLReceiveAllmsg() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getCDomainName() != null) {
            _hashCode += getCDomainName().hashCode();
        }
        if (getCFromNumber() != null) {
            _hashCode += getCFromNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ChangeReceiveNo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ChangeReceiveNo"));
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
        elemField.setFieldName("LReceiveAllmsg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "lReceiveAllmsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDomainName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cDomainName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CFromNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFromNumber"));
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
