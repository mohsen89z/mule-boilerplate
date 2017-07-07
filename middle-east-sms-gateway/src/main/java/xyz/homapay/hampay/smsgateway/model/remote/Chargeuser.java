/**
 * Chargeuser.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public class Chargeuser implements java.io.Serializable {
    private java.lang.String cDomainname;

    private java.lang.String cUsername;

    private java.lang.String cpassword;

    private java.lang.String cUsercharge;

    private long nCharge;

    private java.lang.String cDesCharge;

    public Chargeuser() {
    }

    public Chargeuser(
            java.lang.String cDomainname,
            java.lang.String cUsername,
            java.lang.String cpassword,
            java.lang.String cUsercharge,
            long nCharge,
            java.lang.String cDesCharge) {
        this.cDomainname = cDomainname;
        this.cUsername = cUsername;
        this.cpassword = cpassword;
        this.cUsercharge = cUsercharge;
        this.nCharge = nCharge;
        this.cDesCharge = cDesCharge;
    }


    /**
     * Gets the cDomainname value for this Chargeuser.
     * 
     * @return cDomainname
     */
    public java.lang.String getCDomainname() {
        return cDomainname;
    }


    /**
     * Sets the cDomainname value for this Chargeuser.
     * 
     * @param cDomainname
     */
    public void setCDomainname(java.lang.String cDomainname) {
        this.cDomainname = cDomainname;
    }


    /**
     * Gets the cUsername value for this Chargeuser.
     * 
     * @return cUsername
     */
    public java.lang.String getCUsername() {
        return cUsername;
    }


    /**
     * Sets the cUsername value for this Chargeuser.
     * 
     * @param cUsername
     */
    public void setCUsername(java.lang.String cUsername) {
        this.cUsername = cUsername;
    }


    /**
     * Gets the cpassword value for this Chargeuser.
     * 
     * @return cpassword
     */
    public java.lang.String getCpassword() {
        return cpassword;
    }


    /**
     * Sets the cpassword value for this Chargeuser.
     * 
     * @param cpassword
     */
    public void setCpassword(java.lang.String cpassword) {
        this.cpassword = cpassword;
    }


    /**
     * Gets the cUsercharge value for this Chargeuser.
     * 
     * @return cUsercharge
     */
    public java.lang.String getCUsercharge() {
        return cUsercharge;
    }


    /**
     * Sets the cUsercharge value for this Chargeuser.
     * 
     * @param cUsercharge
     */
    public void setCUsercharge(java.lang.String cUsercharge) {
        this.cUsercharge = cUsercharge;
    }


    /**
     * Gets the nCharge value for this Chargeuser.
     * 
     * @return nCharge
     */
    public long getNCharge() {
        return nCharge;
    }


    /**
     * Sets the nCharge value for this Chargeuser.
     * 
     * @param nCharge
     */
    public void setNCharge(long nCharge) {
        this.nCharge = nCharge;
    }


    /**
     * Gets the cDesCharge value for this Chargeuser.
     * 
     * @return cDesCharge
     */
    public java.lang.String getCDesCharge() {
        return cDesCharge;
    }


    /**
     * Sets the cDesCharge value for this Chargeuser.
     * 
     * @param cDesCharge
     */
    public void setCDesCharge(java.lang.String cDesCharge) {
        this.cDesCharge = cDesCharge;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Chargeuser)) return false;
        Chargeuser other = (Chargeuser) obj;
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
                ((this.cUsername == null && other.getCUsername() == null) ||
                        (this.cUsername != null &&
                                this.cUsername.equals(other.getCUsername()))) &&
                ((this.cpassword == null && other.getCpassword() == null) ||
                        (this.cpassword != null &&
                                this.cpassword.equals(other.getCpassword()))) &&
                ((this.cUsercharge == null && other.getCUsercharge() == null) ||
                        (this.cUsercharge != null &&
                                this.cUsercharge.equals(other.getCUsercharge()))) &&
                this.nCharge == other.getNCharge() &&
                ((this.cDesCharge == null && other.getCDesCharge() == null) ||
                        (this.cDesCharge != null &&
                                this.cDesCharge.equals(other.getCDesCharge())));
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
        if (getCUsername() != null) {
            _hashCode += getCUsername().hashCode();
        }
        if (getCpassword() != null) {
            _hashCode += getCpassword().hashCode();
        }
        if (getCUsercharge() != null) {
            _hashCode += getCUsercharge().hashCode();
        }
        _hashCode += new Long(getNCharge()).hashCode();
        if (getCDesCharge() != null) {
            _hashCode += getCDesCharge().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Chargeuser.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">chargeuser"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDomainname");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cDomainname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("CUsercharge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cUsercharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "nCharge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CDesCharge");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "cDesCharge"));
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
