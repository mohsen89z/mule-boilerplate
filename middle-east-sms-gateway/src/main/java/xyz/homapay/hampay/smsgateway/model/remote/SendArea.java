/**
 * SendArea.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SendArea implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private java.lang.String cBody;

    private long nRandomList;

    private int nCMessage;

    private java.lang.String m_SchedulDate;

    private java.lang.String cDomainname;

    private java.lang.String cFromNumber;

    private long npro;

    private java.lang.String careacode;

    private java.lang.String cfilter;

    private long nbank;

    private int nSpeedsms;

    private int nPeriodmin;

    private java.lang.String cStartTime;

    private java.lang.String cEndTime;

    public SendArea() {
    }

    public SendArea(
            java.lang.String cUserName,
            java.lang.String cPassword,
            java.lang.String cBody,
            long nRandomList,
            int nCMessage,
            java.lang.String m_SchedulDate,
            java.lang.String cDomainname,
            java.lang.String cFromNumber,
            long npro,
            java.lang.String careacode,
            java.lang.String cfilter,
            long nbank,
            int nSpeedsms,
            int nPeriodmin,
            java.lang.String cStartTime,
            java.lang.String cEndTime) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.cBody = cBody;
        this.nRandomList = nRandomList;
        this.nCMessage = nCMessage;
        this.m_SchedulDate = m_SchedulDate;
        this.cDomainname = cDomainname;
        this.cFromNumber = cFromNumber;
        this.npro = npro;
        this.careacode = careacode;
        this.cfilter = cfilter;
        this.nbank = nbank;
        this.nSpeedsms = nSpeedsms;
        this.nPeriodmin = nPeriodmin;
        this.cStartTime = cStartTime;
        this.cEndTime = cEndTime;
    }


    /**
     * Gets the cUserName value for this SendArea.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this SendArea.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this SendArea.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this SendArea.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the cBody value for this SendArea.
     * 
     * @return cBody
     */
    public java.lang.String getCBody() {
        return cBody;
    }


    /**
     * Sets the cBody value for this SendArea.
     * 
     * @param cBody
     */
    public void setCBody(java.lang.String cBody) {
        this.cBody = cBody;
    }


    /**
     * Gets the nRandomList value for this SendArea.
     * 
     * @return nRandomList
     */
    public long getNRandomList() {
        return nRandomList;
    }


    /**
     * Sets the nRandomList value for this SendArea.
     * 
     * @param nRandomList
     */
    public void setNRandomList(long nRandomList) {
        this.nRandomList = nRandomList;
    }


    /**
     * Gets the nCMessage value for this SendArea.
     * 
     * @return nCMessage
     */
    public int getNCMessage() {
        return nCMessage;
    }


    /**
     * Sets the nCMessage value for this SendArea.
     * 
     * @param nCMessage
     */
    public void setNCMessage(int nCMessage) {
        this.nCMessage = nCMessage;
    }


    /**
     * Gets the m_SchedulDate value for this SendArea.
     * 
     * @return m_SchedulDate
     */
    public java.lang.String getM_SchedulDate() {
        return m_SchedulDate;
    }


    /**
     * Sets the m_SchedulDate value for this SendArea.
     * 
     * @param m_SchedulDate
     */
    public void setM_SchedulDate(java.lang.String m_SchedulDate) {
        this.m_SchedulDate = m_SchedulDate;
    }


    /**
     * Gets the cDomainname value for this SendArea.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this SendArea.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cFromNumber value for this SendArea.
     * 
     * @return cFromNumber
     */
    public java.lang.String getCFromNumber() {
        return cFromNumber;
    }


    /**
     * Sets the cFromNumber value for this SendArea.
     * 
     * @param cFromNumber
     */
    public void setCFromNumber(java.lang.String cFromNumber) {
        this.cFromNumber = cFromNumber;
    }


    /**
     * Gets the npro value for this SendArea.
     * 
     * @return npro
     */
    public long getNpro() {
        return npro;
    }


    /**
     * Sets the npro value for this SendArea.
     * 
     * @param npro
     */
    public void setNpro(long npro) {
        this.npro = npro;
    }


    /**
     * Gets the careacode value for this SendArea.
     * 
     * @return careacode
     */
    public java.lang.String getCareacode() {
        return careacode;
    }


    /**
     * Sets the careacode value for this SendArea.
     * 
     * @param careacode
     */
    public void setCareacode(java.lang.String careacode) {
        this.careacode = careacode;
    }


    /**
     * Gets the cfilter value for this SendArea.
     * 
     * @return cfilter
     */
    public java.lang.String getCfilter() {
        return cfilter;
    }


    /**
     * Sets the cfilter value for this SendArea.
     * 
     * @param cfilter
     */
    public void setCfilter(java.lang.String cfilter) {
        this.cfilter = cfilter;
    }


    /**
     * Gets the nbank value for this SendArea.
     * 
     * @return nbank
     */
    public long getNbank() {
        return nbank;
    }


    /**
     * Sets the nbank value for this SendArea.
     * 
     * @param nbank
     */
    public void setNbank(long nbank) {
        this.nbank = nbank;
    }


    /**
     * Gets the nSpeedsms value for this SendArea.
     * 
     * @return nSpeedsms
     */
    public int getNSpeedsms() {
        return nSpeedsms;
    }


    /**
     * Sets the nSpeedsms value for this SendArea.
     * 
     * @param nSpeedsms
     */
    public void setNSpeedsms(int nSpeedsms) {
        this.nSpeedsms = nSpeedsms;
    }


    /**
     * Gets the nPeriodmin value for this SendArea.
     * 
     * @return nPeriodmin
     */
    public int getNPeriodmin() {
        return nPeriodmin;
    }


    /**
     * Sets the nPeriodmin value for this SendArea.
     * 
     * @param nPeriodmin
     */
    public void setNPeriodmin(int nPeriodmin) {
        this.nPeriodmin = nPeriodmin;
    }


    /**
     * Gets the cStartTime value for this SendArea.
     * 
     * @return cStartTime
     */
    public java.lang.String getCStartTime() {
        return cStartTime;
    }


    /**
     * Sets the cStartTime value for this SendArea.
     * 
     * @param cStartTime
     */
    public void setCStartTime(java.lang.String cStartTime) {
        this.cStartTime = cStartTime;
    }


    /**
     * Gets the cEndTime value for this SendArea.
     * 
     * @return cEndTime
     */
    public java.lang.String getCEndTime() {
        return cEndTime;
    }


    /**
     * Sets the cEndTime value for this SendArea.
     * 
     * @param cEndTime
     */
    public void setCEndTime(java.lang.String cEndTime) {
        this.cEndTime = cEndTime;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendArea)) return false;
        SendArea other = (SendArea) obj;
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
                this.nRandomList == other.getNRandomList() &&
                this.nCMessage == other.getNCMessage() &&
                ((this.m_SchedulDate == null && other.getM_SchedulDate() == null) ||
                        (this.m_SchedulDate != null &&
                                this.m_SchedulDate.equals(other.getM_SchedulDate()))) &&
                ((this.cDomainname == null && other.getCDomainname() == null) ||
                        (this.cDomainname != null &&
                                this.cDomainname.equals(other.getCDomainname()))) &&
                ((this.cFromNumber == null && other.getCFromNumber() == null) ||
                        (this.cFromNumber != null &&
                                this.cFromNumber.equals(other.getCFromNumber()))) &&
                this.npro == other.getNpro() &&
                ((this.careacode == null && other.getCareacode() == null) ||
                        (this.careacode != null &&
                                this.careacode.equals(other.getCareacode()))) &&
                ((this.cfilter == null && other.getCfilter() == null) ||
                        (this.cfilter != null &&
                                this.cfilter.equals(other.getCfilter()))) &&
                this.nbank == other.getNbank() &&
                this.nSpeedsms == other.getNSpeedsms() &&
                this.nPeriodmin == other.getNPeriodmin() &&
                ((this.cStartTime == null && other.getCStartTime() == null) ||
                        (this.cStartTime != null &&
                                this.cStartTime.equals(other.getCStartTime()))) &&
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
        _hashCode += new Long(getNRandomList()).hashCode();
        _hashCode += getNCMessage();
        if (getM_SchedulDate() != null) {
            _hashCode += getM_SchedulDate().hashCode();
        }
        if (getCDomainname() != null) {
            _hashCode += getCDomainname().hashCode();
        }
        if (getCFromNumber() != null) {
            _hashCode += getCFromNumber().hashCode();
        }
        _hashCode += new Long(getNpro()).hashCode();
        if (getCareacode() != null) {
            _hashCode += getCareacode().hashCode();
        }
        if (getCfilter() != null) {
            _hashCode += getCfilter().hashCode();
        }
        _hashCode += new Long(getNbank()).hashCode();
        _hashCode += getNSpeedsms();
        _hashCode += getNPeriodmin();
        if (getCStartTime() != null) {
            _hashCode += getCStartTime().hashCode();
        }
        if (getCEndTime() != null) {
            _hashCode += getCEndTime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SendArea.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendArea"));
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
        elemField.setFieldName("NRandomList");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nRandomList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NCMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nCMessage"));
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
        elemField.setFieldName("npro");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "npro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("careacode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "careacode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cfilter");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cfilter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nbank");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nbank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("CStartTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cStartTime"));
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
