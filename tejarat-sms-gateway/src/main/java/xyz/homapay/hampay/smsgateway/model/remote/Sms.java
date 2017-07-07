/**
 * Sms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public interface Sms extends javax.xml.rpc.Service {
    public java.lang.String getsmsSoap12Address();

    public xyz.homapay.hampay.smsgateway.model.remote.SmsSoap_PortType getsmsSoap12() throws javax.xml.rpc.ServiceException;

    public xyz.homapay.hampay.smsgateway.model.remote.SmsSoap_PortType getsmsSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getsmsSoapAddress();

    public xyz.homapay.hampay.smsgateway.model.remote.SmsSoap_PortType getsmsSoap() throws javax.xml.rpc.ServiceException;

    public xyz.homapay.hampay.smsgateway.model.remote.SmsSoap_PortType getsmsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
