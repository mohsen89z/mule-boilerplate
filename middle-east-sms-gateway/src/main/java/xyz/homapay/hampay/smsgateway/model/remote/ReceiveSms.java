/**
 * ReceiveSms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ReceiveSms implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private boolean lReceiveAllmsg;

    private java.lang.String cDomainName;

    private java.lang.String cFromnumber;

    private java.lang.String cFromDate;

    private java.lang.String cToDate;

    public ReceiveSms() {
    }

    public ReceiveSms(
            java.lang.String cUserName,
            java.lang.String cPassword,
            boolean lReceiveAllmsg,
            java.lang.String cDomainName,
            java.lang.String cFromnumber,
            java.lang.String cFromDate,
            java.lang.String cToDate) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.lReceiveAllmsg = lReceiveAllmsg;
        this.cDomainName = cDomainName;
        this.cFromnumber = cFromnumber;
        this.cFromDate = cFromDate;
        this.cToDate = cToDate;
    }


    /**
     * Gets the cUserName value for this ReceiveSms.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this ReceiveSms.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this ReceiveSms.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this ReceiveSms.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the lReceiveAllmsg value for this ReceiveSms.
     * 
     * @return lReceiveAllmsg
     */
    public boolean isLReceiveAllmsg() {
        return lReceiveAllmsg;
    }


    /**
     * Sets the lReceiveAllmsg value for this ReceiveSms.
     * 
     * @param lReceiveAllmsg
     */
    public void setLReceiveAllmsg(boolean lReceiveAllmsg) {
        this.lReceiveAllmsg = lReceiveAllmsg;
    }


    /**
     * Gets the cDomainName value for this ReceiveSms.
     * 
     * @return cDomainName
     */
    public java.lang.String getCDomainName() {
        return cDomainName;
    }


    /**
     * Sets the cDomainName value for this ReceiveSms.
     * 
     * @param cDomainName
     */
    public void setCDomainName(java.lang.String cDomainName) {
        this.cDomainName = cDomainName;
    }


    /**
     * Gets the cFromnumber value for this ReceiveSms.
     * 
     * @return cFromnumber
     */
    public java.lang.String getCFromnumber() {
        return cFromnumber;
    }


    /**
     * Sets the cFromnumber value for this ReceiveSms.
     * 
     * @param cFromnumber
     */
    public void setCFromnumber(java.lang.String cFromnumber) {
        this.cFromnumber = cFromnumber;
    }


    /**
     * Gets the cFromDate value for this ReceiveSms.
     * 
     * @return cFromDate
     */
    public java.lang.String getCFromDate() {
        return cFromDate;
    }


    /**
     * Sets the cFromDate value for this ReceiveSms.
     * 
     * @param cFromDate
     */
    public void setCFromDate(java.lang.String cFromDate) {
        this.cFromDate = cFromDate;
    }


    /**
     * Gets the cToDate value for this ReceiveSms.
     * 
     * @return cToDate
     */
    public java.lang.String getCToDate() {
        return cToDate;
    }


    /**
     * Sets the cToDate value for this ReceiveSms.
     * 
     * @param cToDate
     */
    public void setCToDate(java.lang.String cToDate) {
        this.cToDate = cToDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceiveSms)) return false;
        ReceiveSms other = (ReceiveSms) obj;
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
                ((this.cFromnumber == null && other.getCFromnumber() == null) ||
                        (this.cFromnumber != null &&
                                this.cFromnumber.equals(other.getCFromnumber()))) &&
                ((this.cFromDate == null && other.getCFromDate() == null) ||
                        (this.cFromDate != null &&
                                this.cFromDate.equals(other.getCFromDate()))) &&
                ((this.cToDate == null && other.getCToDate() == null) ||
                        (this.cToDate != null &&
                                this.cToDate.equals(other.getCToDate())));
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
        if (getCFromnumber() != null) {
            _hashCode += getCFromnumber().hashCode();
        }
        if (getCFromDate() != null) {
            _hashCode += getCFromDate().hashCode();
        }
        if (getCToDate() != null) {
            _hashCode += getCToDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ReceiveSms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ReceiveSms"));
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
        elemField.setFieldName("CFromnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFromnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CFromDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFromDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CToDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cToDate"));
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
