/**
 * SendSms1To1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SendSms1To1 implements java.io.Serializable {
    private java.lang.String cDomainname;

    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aGetid;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt aCMessage;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aFromNumber;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt atypeUnicodemessage;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString am_SchedulDate;

    private int nTypeSent;

    private int nSpeedsms;

    private int nPeriodmin;

    public SendSms1To1() {
    }

    public SendSms1To1(
            java.lang.String cDomainname,
            java.lang.String cUserName,
            java.lang.String cPassword,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aGetid,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt aCMessage,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aFromNumber,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt atypeUnicodemessage,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString am_SchedulDate,
            int nTypeSent,
            int nSpeedsms,
            int nPeriodmin) {
        this.cDomainname = cDomainname;
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.aBody = aBody;
        this.aMobileno = aMobileno;
        this.aGetid = aGetid;
        this.aCMessage = aCMessage;
        this.aFromNumber = aFromNumber;
        this.atypeUnicodemessage = atypeUnicodemessage;
        this.am_SchedulDate = am_SchedulDate;
        this.nTypeSent = nTypeSent;
        this.nSpeedsms = nSpeedsms;
        this.nPeriodmin = nPeriodmin;
    }


    /**
     * Gets the cDomainname value for this SendSms1To1.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this SendSms1To1.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cUserName value for this SendSms1To1.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this SendSms1To1.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this SendSms1To1.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this SendSms1To1.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the aBody value for this SendSms1To1.
     * 
     * @return aBody
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getABody() {
        return aBody;
    }


    /**
     * Sets the aBody value for this SendSms1To1.
     * 
     * @param aBody
     */
    public void setABody(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody) {
        this.aBody = aBody;
    }


    /**
     * Gets the aMobileno value for this SendSms1To1.
     * 
     * @return aMobileno
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAMobileno() {
        return aMobileno;
    }


    /**
     * Sets the aMobileno value for this SendSms1To1.
     * 
     * @param aMobileno
     */
    public void setAMobileno(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno) {
        this.aMobileno = aMobileno;
    }


    /**
     * Gets the aGetid value for this SendSms1To1.
     * 
     * @return aGetid
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getAGetid() {
        return aGetid;
    }


    /**
     * Sets the aGetid value for this SendSms1To1.
     * 
     * @param aGetid
     */
    public void setAGetid(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aGetid) {
        this.aGetid = aGetid;
    }


    /**
     * Gets the aCMessage value for this SendSms1To1.
     * 
     * @return aCMessage
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt getACMessage() {
        return aCMessage;
    }


    /**
     * Sets the aCMessage value for this SendSms1To1.
     * 
     * @param aCMessage
     */
    public void setACMessage(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt aCMessage) {
        this.aCMessage = aCMessage;
    }


    /**
     * Gets the aFromNumber value for this SendSms1To1.
     * 
     * @return aFromNumber
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAFromNumber() {
        return aFromNumber;
    }


    /**
     * Sets the aFromNumber value for this SendSms1To1.
     * 
     * @param aFromNumber
     */
    public void setAFromNumber(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aFromNumber) {
        this.aFromNumber = aFromNumber;
    }


    /**
     * Gets the atypeUnicodemessage value for this SendSms1To1.
     * 
     * @return atypeUnicodemessage
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt getAtypeUnicodemessage() {
        return atypeUnicodemessage;
    }


    /**
     * Sets the atypeUnicodemessage value for this SendSms1To1.
     * 
     * @param atypeUnicodemessage
     */
    public void setAtypeUnicodemessage(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt atypeUnicodemessage) {
        this.atypeUnicodemessage = atypeUnicodemessage;
    }


    /**
     * Gets the am_SchedulDate value for this SendSms1To1.
     * 
     * @return am_SchedulDate
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAm_SchedulDate() {
        return am_SchedulDate;
    }


    /**
     * Sets the am_SchedulDate value for this SendSms1To1.
     * 
     * @param am_SchedulDate
     */
    public void setAm_SchedulDate(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString am_SchedulDate) {
        this.am_SchedulDate = am_SchedulDate;
    }


    /**
     * Gets the nTypeSent value for this SendSms1To1.
     * 
     * @return nTypeSent
     */
    public int getNTypeSent() {
        return nTypeSent;
    }


    /**
     * Sets the nTypeSent value for this SendSms1To1.
     * 
     * @param nTypeSent
     */
    public void setNTypeSent(int nTypeSent) {
        this.nTypeSent = nTypeSent;
    }


    /**
     * Gets the nSpeedsms value for this SendSms1To1.
     * 
     * @return nSpeedsms
     */
    public int getNSpeedsms() {
        return nSpeedsms;
    }


    /**
     * Sets the nSpeedsms value for this SendSms1To1.
     * 
     * @param nSpeedsms
     */
    public void setNSpeedsms(int nSpeedsms) {
        this.nSpeedsms = nSpeedsms;
    }


    /**
     * Gets the nPeriodmin value for this SendSms1To1.
     * 
     * @return nPeriodmin
     */
    public int getNPeriodmin() {
        return nPeriodmin;
    }


    /**
     * Sets the nPeriodmin value for this SendSms1To1.
     * 
     * @param nPeriodmin
     */
    public void setNPeriodmin(int nPeriodmin) {
        this.nPeriodmin = nPeriodmin;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendSms1To1)) return false;
        SendSms1To1 other = (SendSms1To1) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cDomainname == null && other.getCDomainname() == null) ||
                        (this.cDomainname != null &&
                                this.cDomainname.equals(other.getCDomainname()))) &&
                ((this.cUserName == null && other.getCUserName() == null) ||
                        (this.cUserName != null &&
                                this.cUserName.equals(other.getCUserName()))) &&
                ((this.cPassword == null && other.getCPassword() == null) ||
                        (this.cPassword != null &&
                                this.cPassword.equals(other.getCPassword()))) &&
                ((this.aBody == null && other.getABody() == null) ||
                        (this.aBody != null &&
                                this.aBody.equals(other.getABody()))) &&
                ((this.aMobileno == null && other.getAMobileno() == null) ||
                        (this.aMobileno != null &&
                                this.aMobileno.equals(other.getAMobileno()))) &&
                ((this.aGetid == null && other.getAGetid() == null) ||
                        (this.aGetid != null &&
                                this.aGetid.equals(other.getAGetid()))) &&
                ((this.aCMessage == null && other.getACMessage() == null) ||
                        (this.aCMessage != null &&
                                this.aCMessage.equals(other.getACMessage()))) &&
                ((this.aFromNumber == null && other.getAFromNumber() == null) ||
                        (this.aFromNumber != null &&
                                this.aFromNumber.equals(other.getAFromNumber()))) &&
                ((this.atypeUnicodemessage == null && other.getAtypeUnicodemessage() == null) ||
                        (this.atypeUnicodemessage != null &&
                                this.atypeUnicodemessage.equals(other.getAtypeUnicodemessage()))) &&
                ((this.am_SchedulDate == null && other.getAm_SchedulDate() == null) ||
                        (this.am_SchedulDate != null &&
                                this.am_SchedulDate.equals(other.getAm_SchedulDate()))) &&
                this.nTypeSent == other.getNTypeSent() &&
                this.nSpeedsms == other.getNSpeedsms() &&
                this.nPeriodmin == other.getNPeriodmin();
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
        if (getCDomainname() != null) {
            _hashCode += getCDomainname().hashCode();
        }
        if (getCUserName() != null) {
            _hashCode += getCUserName().hashCode();
        }
        if (getCPassword() != null) {
            _hashCode += getCPassword().hashCode();
        }
        if (getABody() != null) {
            _hashCode += getABody().hashCode();
        }
        if (getAMobileno() != null) {
            _hashCode += getAMobileno().hashCode();
        }
        if (getAGetid() != null) {
            _hashCode += getAGetid().hashCode();
        }
        if (getACMessage() != null) {
            _hashCode += getACMessage().hashCode();
        }
        if (getAFromNumber() != null) {
            _hashCode += getAFromNumber().hashCode();
        }
        if (getAtypeUnicodemessage() != null) {
            _hashCode += getAtypeUnicodemessage().hashCode();
        }
        if (getAm_SchedulDate() != null) {
            _hashCode += getAm_SchedulDate().hashCode();
        }
        _hashCode += getNTypeSent();
        _hashCode += getNSpeedsms();
        _hashCode += getNPeriodmin();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SendSms1To1.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendSms1To1"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDomainname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cDomainname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("ABody");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aBody"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMobileno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aMobileno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AGetid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aGetid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfLong"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ACMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aCMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfInt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AFromNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aFromNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("atypeUnicodemessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "atypeUnicodemessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfInt"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("am_SchedulDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "am_SchedulDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NTypeSent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nTypeSent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NSpeedsms");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nSpeedsms"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NPeriodmin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nPeriodmin"));
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
