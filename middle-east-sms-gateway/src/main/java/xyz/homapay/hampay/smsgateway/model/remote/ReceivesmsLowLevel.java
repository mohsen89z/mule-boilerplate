/**
 * ReceivesmsLowLevel.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class ReceivesmsLowLevel implements java.io.Serializable {
    private java.lang.String cUserName;

    private java.lang.String cPassword;

    private boolean lReceiveAllmsg;

    private java.lang.String cDomainName;

    private java.lang.String cFromnumber;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aMessageid;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aReceivedate;

    private xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString afromnumber;

    public ReceivesmsLowLevel() {
    }

    public ReceivesmsLowLevel(
            java.lang.String cUserName,
            java.lang.String cPassword,
            boolean lReceiveAllmsg,
            java.lang.String cDomainName,
            java.lang.String cFromnumber,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aMessageid,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aReceivedate,
            xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString afromnumber) {
        this.cUserName = cUserName;
        this.cPassword = cPassword;
        this.lReceiveAllmsg = lReceiveAllmsg;
        this.cDomainName = cDomainName;
        this.cFromnumber = cFromnumber;
        this.aBody = aBody;
        this.aMobileno = aMobileno;
        this.aMessageid = aMessageid;
        this.aReceivedate = aReceivedate;
        this.afromnumber = afromnumber;
    }


    /**
     * Gets the cUserName value for this ReceivesmsLowLevel.
     * 
     * @return cUserName
     */
    public java.lang.String getCUserName() {
        return cUserName;
    }


    /**
     * Sets the cUserName value for this ReceivesmsLowLevel.
     * 
     * @param cUserName
     */
    public void setCUserName(java.lang.String cUserName) {
        this.cUserName = cUserName;
    }


    /**
     * Gets the cPassword value for this ReceivesmsLowLevel.
     * 
     * @return cPassword
     */
    public java.lang.String getCPassword() {
        return cPassword;
    }


    /**
     * Sets the cPassword value for this ReceivesmsLowLevel.
     * 
     * @param cPassword
     */
    public void setCPassword(java.lang.String cPassword) {
        this.cPassword = cPassword;
    }


    /**
     * Gets the lReceiveAllmsg value for this ReceivesmsLowLevel.
     * 
     * @return lReceiveAllmsg
     */
    public boolean isLReceiveAllmsg() {
        return lReceiveAllmsg;
    }


    /**
     * Sets the lReceiveAllmsg value for this ReceivesmsLowLevel.
     * 
     * @param lReceiveAllmsg
     */
    public void setLReceiveAllmsg(boolean lReceiveAllmsg) {
        this.lReceiveAllmsg = lReceiveAllmsg;
    }


    /**
     * Gets the cDomainName value for this ReceivesmsLowLevel.
     * 
     * @return cDomainName
     */
    public java.lang.String getCDomainName() {
        return cDomainName;
    }


    /**
     * Sets the cDomainName value for this ReceivesmsLowLevel.
     * 
     * @param cDomainName
     */
    public void setCDomainName(java.lang.String cDomainName) {
        this.cDomainName = cDomainName;
    }


    /**
     * Gets the cFromnumber value for this ReceivesmsLowLevel.
     * 
     * @return cFromnumber
     */
    public java.lang.String getCFromnumber() {
        return cFromnumber;
    }


    /**
     * Sets the cFromnumber value for this ReceivesmsLowLevel.
     * 
     * @param cFromnumber
     */
    public void setCFromnumber(java.lang.String cFromnumber) {
        this.cFromnumber = cFromnumber;
    }


    /**
     * Gets the aBody value for this ReceivesmsLowLevel.
     * 
     * @return aBody
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getABody() {
        return aBody;
    }


    /**
     * Sets the aBody value for this ReceivesmsLowLevel.
     * 
     * @param aBody
     */
    public void setABody(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody) {
        this.aBody = aBody;
    }


    /**
     * Gets the aMobileno value for this ReceivesmsLowLevel.
     * 
     * @return aMobileno
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAMobileno() {
        return aMobileno;
    }


    /**
     * Sets the aMobileno value for this ReceivesmsLowLevel.
     * 
     * @param aMobileno
     */
    public void setAMobileno(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno) {
        this.aMobileno = aMobileno;
    }


    /**
     * Gets the aMessageid value for this ReceivesmsLowLevel.
     * 
     * @return aMessageid
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getAMessageid() {
        return aMessageid;
    }


    /**
     * Sets the aMessageid value for this ReceivesmsLowLevel.
     * 
     * @param aMessageid
     */
    public void setAMessageid(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aMessageid) {
        this.aMessageid = aMessageid;
    }


    /**
     * Gets the aReceivedate value for this ReceivesmsLowLevel.
     * 
     * @return aReceivedate
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAReceivedate() {
        return aReceivedate;
    }


    /**
     * Sets the aReceivedate value for this ReceivesmsLowLevel.
     * 
     * @param aReceivedate
     */
    public void setAReceivedate(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aReceivedate) {
        this.aReceivedate = aReceivedate;
    }


    /**
     * Gets the afromnumber value for this ReceivesmsLowLevel.
     * 
     * @return afromnumber
     */
    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getAfromnumber() {
        return afromnumber;
    }


    /**
     * Sets the afromnumber value for this ReceivesmsLowLevel.
     * 
     * @param afromnumber
     */
    public void setAfromnumber(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString afromnumber) {
        this.afromnumber = afromnumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReceivesmsLowLevel)) return false;
        ReceivesmsLowLevel other = (ReceivesmsLowLevel) obj;
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
                ((this.aBody == null && other.getABody() == null) ||
                        (this.aBody != null &&
                                this.aBody.equals(other.getABody()))) &&
                ((this.aMobileno == null && other.getAMobileno() == null) ||
                        (this.aMobileno != null &&
                                this.aMobileno.equals(other.getAMobileno()))) &&
                ((this.aMessageid == null && other.getAMessageid() == null) ||
                        (this.aMessageid != null &&
                                this.aMessageid.equals(other.getAMessageid()))) &&
                ((this.aReceivedate == null && other.getAReceivedate() == null) ||
                        (this.aReceivedate != null &&
                                this.aReceivedate.equals(other.getAReceivedate()))) &&
                ((this.afromnumber == null && other.getAfromnumber() == null) ||
                        (this.afromnumber != null &&
                                this.afromnumber.equals(other.getAfromnumber())));
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
        if (getABody() != null) {
            _hashCode += getABody().hashCode();
        }
        if (getAMobileno() != null) {
            _hashCode += getAMobileno().hashCode();
        }
        if (getAMessageid() != null) {
            _hashCode += getAMessageid().hashCode();
        }
        if (getAReceivedate() != null) {
            _hashCode += getAReceivedate().hashCode();
        }
        if (getAfromnumber() != null) {
            _hashCode += getAfromnumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ReceivesmsLowLevel.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">ReceivesmsLowLevel"));
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
        elemField.setFieldName("AMessageid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aMessageid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfLong"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AReceivedate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "aReceivedate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("afromnumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "afromnumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", "ArrayOfString"));
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
