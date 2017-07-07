/**
 * SmsSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public interface SmsSoap_PortType extends java.rmi.Remote {
    public java.lang.String helloWorld() throws java.rmi.RemoteException;
    public java.lang.String doGetInfo(java.lang.String uUsername, java.lang.String uPassword) throws java.rmi.RemoteException;
    public java.lang.String doSendSMS(java.lang.String uUsername, java.lang.String uPassword, java.lang.String uNumber, java.lang.String uCellphones, java.lang.String uMessage, boolean uFarsi, boolean uTopic, boolean uFlash, java.lang.String uUDH) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString doSendArraySMS(java.lang.String uUsername, java.lang.String uPassword, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString uNumber, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString uCellphone, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString uMessage, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfBoolean uFarsi, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfBoolean uFlash, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString uUDH) throws java.rmi.RemoteException;
    public java.lang.String doSendSMSByteArr(java.lang.String uUsername, java.lang.String uPassword, java.lang.String uNumber, java.lang.String uCellphones, byte[] uMessage, boolean uFarsi, boolean uTopic, boolean uFlash, java.lang.String uUDH) throws java.rmi.RemoteException;
    public java.lang.String doGetDelivery(java.lang.String uUsername, java.lang.String uReturnIDs) throws java.rmi.RemoteException;
    public java.lang.String doReceiveSMS(java.lang.String uUsername, java.lang.String uPassword, long uLastRowID) throws java.rmi.RemoteException;
    public java.lang.String doReceiveSMSAll(java.lang.String uUsername, java.lang.String uPassword) throws java.rmi.RemoteException;
}
