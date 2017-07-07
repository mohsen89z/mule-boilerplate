/**
 * SendFax.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class SendFax implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private java.lang.String cDomainname;

    private java.lang.String cFaxselect;

    private java.lang.String cFaxnumber;

    private java.lang.String cMobileno;

    private java.lang.String m_SchedulDate;

    public SendFax() {
    }

    public SendFax(
            java.lang.String cUserName,
            java.lang.String cPassword,
            java.lang.String cDomainname,
            java.lang.String cFaxselect,
            java.lang.String cFaxnumber,
            java.lang.String cMobileno,
            java.lang.String m_SchedulDate) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.cDomainname = cDomainname;
        this.cFaxselect = cFaxselect;
        this.cFaxnumber = cFaxnumber;
        this.cMobileno = cMobileno;
        this.m_SchedulDate = m_SchedulDate;
    }


    /**
     * Gets the cUserName value for this SendFax.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this SendFax.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this SendFax.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this SendFax.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the cDomainname value for this SendFax.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this SendFax.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cFaxselect value for this SendFax.
     * 
     * @return cFaxselect
     */
    public java.lang.String getCFaxselect() {
        return cFaxselect;
    }


    /**
     * Sets the cFaxselect value for this SendFax.
     * 
     * @param cFaxselect
     */
    public void setCFaxselect(java.lang.String cFaxselect) {
        this.cFaxselect = cFaxselect;
    }


    /**
     * Gets the cFaxnumber value for this SendFax.
     * 
     * @return cFaxnumber
     */
    public java.lang.String getCFaxnumber() {
        return cFaxnumber;
    }


    /**
     * Sets the cFaxnumber value for this SendFax.
     * 
     * @param cFaxnumber
     */
    public void setCFaxnumber(java.lang.String cFaxnumber) {
        this.cFaxnumber = cFaxnumber;
    }


    /**
     * Gets the cMobileno value for this SendFax.
     * 
     * @return cMobileno
     */
    public java.lang.String getCMobileno() {
        return cMobileno;
    }


    /**
     * Sets the cMobileno value for this SendFax.
     * 
     * @param cMobileno
     */
    public void setCMobileno(java.lang.String cMobileno) {
        this.cMobileno = cMobileno;
    }


    /**
     * Gets the m_SchedulDate value for this SendFax.
     * 
     * @return m_SchedulDate
     */
    public java.lang.String getM_SchedulDate() {
        return m_SchedulDate;
    }


    /**
     * Sets the m_SchedulDate value for this SendFax.
     * 
     * @param m_SchedulDate
     */
    public void setM_SchedulDate(java.lang.String m_SchedulDate) {
        this.m_SchedulDate = m_SchedulDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendFax)) return false;
        SendFax other = (SendFax) obj;
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
                ((this.cFaxselect == null && other.getCFaxselect() == null) ||
                        (this.cFaxselect != null &&
                                this.cFaxselect.equals(other.getCFaxselect()))) &&
                ((this.cFaxnumber == null && other.getCFaxnumber() == null) ||
                        (this.cFaxnumber != null &&
                                this.cFaxnumber.equals(other.getCFaxnumber()))) &&
                ((this.cMobileno == null && other.getCMobileno() == null) ||
                        (this.cMobileno != null &&
                                this.cMobileno.equals(other.getCMobileno()))) &&
                ((this.m_SchedulDate == null && other.getM_SchedulDate() == null) ||
                        (this.m_SchedulDate != null &&
                                this.m_SchedulDate.equals(other.getM_SchedulDate())));
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
        if (getCFaxselect() != null) {
            _hashCode += getCFaxselect().hashCode();
        }
        if (getCFaxnumber() != null) {
            _hashCode += getCFaxnumber().hashCode();
        }
        if (getCMobileno() != null) {
            _hashCode += getCMobileno().hashCode();
        }
        if (getM_SchedulDate() != null) {
            _hashCode += getM_SchedulDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SendFax.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">SendFax"));
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
        elemField.setFieldName("CFaxselect");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFaxselect"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CFaxnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cFaxnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CMobileno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cMobileno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m_SchedulDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "m_SchedulDate"));
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
