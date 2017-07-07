/**
 * SendSms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SendSms implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private java.lang.String cBody;

    private java.lang.String cSmsnumber;

    private java.lang.String cGetid;

    private int nCMessage;

    private int nTypeSent;

    private java.lang.String m_SchedulDate;

    private java.lang.String cDomainname;

    private java.lang.String cFromNumber;

    private int nSpeedsms;

    private int nPeriodmin;

    private java.lang.String cstarttime;

    private java.lang.String cEndTime;

    public SendSms() {
    }

    public SendSms(
            java.lang.String cUserName,
            java.lang.String cPassword,
            java.lang.String cBody,
            java.lang.String cSmsnumber,
            java.lang.String cGetid,
            int nCMessage,
            int nTypeSent,
            java.lang.String m_SchedulDate,
            java.lang.String cDomainname,
            java.lang.String cFromNumber,
            int nSpeedsms,
            int nPeriodmin,
            java.lang.String cstarttime,
            java.lang.String cEndTime) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.cBody = cBody;
        this.cSmsnumber = cSmsnumber;
        this.cGetid = cGetid;
        this.nCMessage = nCMessage;
        this.nTypeSent = nTypeSent;
        this.m_SchedulDate = m_SchedulDate;
        this.cDomainname = cDomainname;
        this.cFromNumber = cFromNumber;
        this.nSpeedsms = nSpeedsms;
        this.nPeriodmin = nPeriodmin;
        this.cstarttime = cstarttime;
        this.cEndTime = cEndTime;
    }


    /**
     * Gets the cUserName value for this SendSms.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this SendSms.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this SendSms.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this SendSms.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the cBody value for this SendSms.
     * 
     * @return cBody
     */
    public java.lang.String getCBody() {
        return cBody;
    }


    /**
     * Sets the cBody value for this SendSms.
     * 
     * @param cBody
     */
    public void setCBody(java.lang.String cBody) {
        this.cBody = cBody;
    }


    /**
     * Gets the cSmsnumber value for this SendSms.
     * 
     * @return cSmsnumber
     */
    public java.lang.String getCSmsnumber() {
        return cSmsnumber;
    }


    /**
     * Sets the cSmsnumber value for this SendSms.
     * 
     * @param cSmsnumber
     */
    public void setCSmsnumber(java.lang.String cSmsnumber) {
        this.cSmsnumber = cSmsnumber;
    }


    /**
     * Gets the cGetid value for this SendSms.
     * 
     * @return cGetid
     */
    public java.lang.String getCGetid() {
        return cGetid;
    }


    /**
     * Sets the cGetid value for this SendSms.
     * 
     * @param cGetid
     */
    public void setCGetid(java.lang.String cGetid) {
        this.cGetid = cGetid;
    }


    /**
     * Gets the nCMessage value for this SendSms.
     * 
     * @return nCMessage
     */
    public int getNCMessage() {
        return nCMessage;
    }


    /**
     * Sets the nCMessage value for this SendSms.
     * 
     * @param nCMessage
     */
    public void setNCMessage(int nCMessage) {
        this.nCMessage = nCMessage;
    }


    /**
     * Gets the nTypeSent value for this SendSms.
     * 
     * @return nTypeSent
     */
    public int getNTypeSent() {
        return nTypeSent;
    }


    /**
     * Sets the nTypeSent value for this SendSms.
     * 
     * @param nTypeSent
     */
    public void setNTypeSent(int nTypeSent) {
        this.nTypeSent = nTypeSent;
    }


    /**
     * Gets the m_SchedulDate value for this SendSms.
     * 
     * @return m_SchedulDate
     */
    public java.lang.String getM_SchedulDate() {
        return m_SchedulDate;
    }


    /**
     * Sets the m_SchedulDate value for this SendSms.
     * 
     * @param m_SchedulDate
     */
    public void setM_SchedulDate(java.lang.String m_SchedulDate) {
        this.m_SchedulDate = m_SchedulDate;
    }


    /**
     * Gets the cDomainname value for this SendSms.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this SendSms.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cFromNumber value for this SendSms.
     * 
     * @return cFromNumber
     */
    public java.lang.String getCFromNumber() {
        return cFromNumber;
    }


    /**
     * Sets the cFromNumber value for this SendSms.
     * 
     * @param cFromNumber
     */
    public void setCFromNumber(java.lang.String cFromNumber) {
        this.cFromNumber = cFromNumber;
    }


    /**
     * Gets the nSpeedsms value for this SendSms.
     * 
     * @return nSpeedsms
     */
    public int getNSpeedsms() {
        return nSpeedsms;
    }


    /**
     * Sets the nSpeedsms value for this SendSms.
     * 
     * @param nSpeedsms
     */
    public void setNSpeedsms(int nSpeedsms) {
        this.nSpeedsms = nSpeedsms;
    }


    /**
     * Gets the nPeriodmin value for this SendSms.
     * 
     * @return nPeriodmin
     */
    public int getNPeriodmin() {
        return nPeriodmin;
    }


    /**
     * Sets the nPeriodmin value for this SendSms.
     * 
     * @param nPeriodmin
     */
    public void setNPeriodmin(int nPeriodmin) {
        this.nPeriodmin = nPeriodmin;
    }


    /**
     * Gets the cstarttime value for this SendSms.
     * 
     * @return cstarttime
     */
    public java.lang.String getCstarttime() {
        return cstarttime;
    }


    /**
     * Sets the cstarttime value for this SendSms.
     * 
     * @param cstarttime
     */
    public void setCstarttime(java.lang.String cstarttime) {
        this.cstarttime = cstarttime;
    }


    /**
     * Gets the cEndTime value for this SendSms.
     * 
     * @return cEndTime
     */
    public java.lang.String getCEndTime() {
        return cEndTime;
    }


    /**
     * Sets the cEndTime value for this SendSms.
     * 
     * @param cEndTime
     */
    public void setCEndTime(java.lang.String cEndTime) {
        this.cEndTime = cEndTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendSms)) return false;
        SendSms other = (SendSms) obj;
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
                ((this.cBody == null && other.getCBody() == null) ||
                        (this.cBody != null &&
                                this.cBody.equals(other.getCBody()))) &&
                ((this.cSmsnumber == null && other.getCSmsnumber() == null) ||
                        (this.cSmsnumber != null &&
                                this.cSmsnumber.equals(other.getCSmsnumber()))) &&
                ((this.cGetid == null && other.getCGetid() == null) ||
                        (this.cGetid != null &&
                                this.cGetid.equals(other.getCGetid()))) &&
                this.nCMessage == other.getNCMessage() &&
                this.nTypeSent == other.getNTypeSent() &&
                ((this.m_SchedulDate == null && other.getM_SchedulDate() == null) ||
                        (this.m_SchedulDate != null &&
                                this.m_SchedulDate.equals(other.getM_SchedulDate()))) &&
                ((this.cDomainname == null && other.getCDomainname() == null) ||
                        (this.cDomainname != null &&
                                this.cDomainname.equals(other.getCDomainname()))) &&
                ((this.cFromNumber == null && other.getCFromNumber() == null) ||
                        (this.cFromNumber != null &&
                                this.cFromNumber.equals(other.getCFromNumber()))) &&
                this.nSpeedsms == other.getNSpeedsms() &&
                this.nPeriodmin == other.getNPeriodmin() &&
                ((this.cstarttime == null && other.getCstarttime() == null) ||
                        (this.cstarttime != null &&
                                this.cstarttime.equals(other.getCstarttime()))) &&
                ((this.cEndTime == null && other.getCEndTime() == null) ||
                        (this.cEndTime != null &&
                                this.cEndTime.equals(other.getCEndTime())));
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
        if (getCBody() != null) {
            _hashCode += getCBody().hashCode();
        }
        if (getCSmsnumber() != null) {
            _hashCode += getCSmsnumber().hashCode();
        }
        if (getCGetid() != null) {
            _hashCode += getCGetid().hashCode();
        }
        _hashCode += getNCMessage();
        _hashCode += getNTypeSent();
        if (getM_SchedulDate() != null) {
            _hashCode += getM_SchedulDate().hashCode();
        }
        if (getCDomainname() != null) {
            _hashCode += getCDomainname().hashCode();
        }
        if (getCFromNumber() != null) {
            _hashCode += getCFromNumber().hashCode();
        }
        _hashCode += getNSpeedsms();
        _hashCode += getNPeriodmin();
        if (getCstarttime() != null) {
            _hashCode += getCstarttime().hashCode();
        }
        if (getCEndTime() != null) {
            _hashCode += getCEndTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SendSms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendSms"));
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
        elemField.setFieldName("CBody");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cBody"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CSmsnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cSmsnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CGetid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cGetid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NCMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nCMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NTypeSent");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nTypeSent"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_SchedulDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "m_SchedulDate"));
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
        elemField.setFieldName("CFromNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFromNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cstarttime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cstarttime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CEndTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cEndTime"));
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
