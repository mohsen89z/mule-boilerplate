/**
 * Sendmail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Sendmail implements java.io.Serializable {
    private java.lang.String cUsername;

    private java.lang.String cpassword;

    private java.lang.String cDomainname;

    private java.lang.String cSendername;

    private java.lang.String cTo;

    private java.lang.String csubject;

    private long nSendmailid;

    public Sendmail() {
    }

    public Sendmail(
            java.lang.String cUsername,
            java.lang.String cpassword,
            java.lang.String cDomainname,
            java.lang.String cSendername,
            java.lang.String cTo,
            java.lang.String csubject,
            long nSendmailid) {
        this.cUsername = cUsername;
        this.cpassword = cpassword;
        this.cDomainname = cDomainname;
        this.cSendername = cSendername;
        this.cTo = cTo;
        this.csubject = csubject;
        this.nSendmailid = nSendmailid;
    }


    /**
     * Gets the cUsername value for this Sendmail.
     * 
     * @return cUsername
     */
    public java.lang.String getCUsername() {
        return cUsername;
    }


    /**
     * Sets the cUsername value for this Sendmail.
     * 
     * @param cUsername
     */
    public void setCUsername(java.lang.String cUsername) {
        this.cUsername = cUsername;
    }


    /**
     * Gets the cpassword value for this Sendmail.
     * 
     * @return cpassword
     */
    public java.lang.String getCpassword() {
        return cpassword;
    }


    /**
     * Sets the cpassword value for this Sendmail.
     * 
     * @param cpassword
     */
    public void setCpassword(java.lang.String cpassword) {
        this.cpassword = cpassword;
    }


    /**
     * Gets the cDomainname value for this Sendmail.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this Sendmail.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cSendername value for this Sendmail.
     * 
     * @return cSendername
     */
    public java.lang.String getCSendername() {
        return cSendername;
    }


    /**
     * Sets the cSendername value for this Sendmail.
     * 
     * @param cSendername
     */
    public void setCSendername(java.lang.String cSendername) {
        this.cSendername = cSendername;
    }


    /**
     * Gets the cTo value for this Sendmail.
     * 
     * @return cTo
     */
    public java.lang.String getCTo() {
        return cTo;
    }


    /**
     * Sets the cTo value for this Sendmail.
     * 
     * @param cTo
     */
    public void setCTo(java.lang.String cTo) {
        this.cTo = cTo;
    }


    /**
     * Gets the csubject value for this Sendmail.
     * 
     * @return csubject
     */
    public java.lang.String getCsubject() {
        return csubject;
    }


    /**
     * Sets the csubject value for this Sendmail.
     * 
     * @param csubject
     */
    public void setCsubject(java.lang.String csubject) {
        this.csubject = csubject;
    }


    /**
     * Gets the nSendmailid value for this Sendmail.
     * 
     * @return nSendmailid
     */
    public long getNSendmailid() {
        return nSendmailid;
    }


    /**
     * Sets the nSendmailid value for this Sendmail.
     * 
     * @param nSendmailid
     */
    public void setNSendmailid(long nSendmailid) {
        this.nSendmailid = nSendmailid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sendmail)) return false;
        Sendmail other = (Sendmail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.cUsername == null && other.getCUsername() == null) ||
                        (this.cUsername != null &&
                                this.cUsername.equals(other.getCUsername()))) &&
                ((this.cpassword == null && other.getCpassword() == null) ||
                        (this.cpassword != null &&
                                this.cpassword.equals(other.getCpassword()))) &&
                ((this.cDomainname == null && other.getCDomainname() == null) ||
                        (this.cDomainname != null &&
                                this.cDomainname.equals(other.getCDomainname()))) &&
                ((this.cSendername == null && other.getCSendername() == null) ||
                        (this.cSendername != null &&
                                this.cSendername.equals(other.getCSendername()))) &&
                ((this.cTo == null && other.getCTo() == null) ||
                        (this.cTo != null &&
                                this.cTo.equals(other.getCTo()))) &&
                ((this.csubject == null && other.getCsubject() == null) ||
                        (this.csubject != null &&
                                this.csubject.equals(other.getCsubject()))) &&
                this.nSendmailid == other.getNSendmailid();
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
        if (getCUsername() != null) {
            _hashCode += getCUsername().hashCode();
        }
        if (getCpassword() != null) {
            _hashCode += getCpassword().hashCode();
        }
        if (getCDomainname() != null) {
            _hashCode += getCDomainname().hashCode();
        }
        if (getCSendername() != null) {
            _hashCode += getCSendername().hashCode();
        }
        if (getCTo() != null) {
            _hashCode += getCTo().hashCode();
        }
        if (getCsubject() != null) {
            _hashCode += getCsubject().hashCode();
        }
        _hashCode += new Long(getNSendmailid()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Sendmail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Sendmail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUsername");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cUsername"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cpassword");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cpassword"));
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
        elemField.setFieldName("CSendername");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cSendername"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csubject");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "csubject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NSendmailid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nSendmailid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
