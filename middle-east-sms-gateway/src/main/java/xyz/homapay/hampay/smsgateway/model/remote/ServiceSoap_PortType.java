/**
 * ServiceSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package xyz.homapay.hampay.smsgateway.model.remote;

public interface ServiceSoap_PortType extends java.rmi.Remote {
    public boolean sendmailtoserver(long nSendmailid) throws java.rmi.RemoteException;
    public java.lang.String createsubjectemail(java.lang.String cUsername, java.lang.String cpassword, java.lang.String cDomainname, java.lang.String cFrom, java.lang.String cSendername, java.lang.String csubject, java.lang.String cBody) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.GetemailsubjectResponseGetemailsubjectResult getemailsubject(java.lang.String cUsername, java.lang.String cpassword, java.lang.String cDomainname) throws java.rmi.RemoteException;
    public boolean sendmail(java.lang.String cUsername, java.lang.String cpassword, java.lang.String cDomainname, java.lang.String cSendername, java.lang.String cTo, java.lang.String csubject, long nSendmailid) throws java.rmi.RemoteException;
    public void divertsms(int nAccountusesid) throws java.rmi.RemoteException;
    public void sendHttpAutoAnswer(int nAccountusesid, java.lang.String cpath) throws java.rmi.RemoteException;
    public java.lang.String deliver1Row(java.lang.String cEncrypt, long ntag, int status, int nid, int nreason) throws java.rmi.RemoteException;
    public boolean initializeReceive(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cConnection) throws java.rmi.RemoteException;
    public boolean arziabi(long naccountusesid, boolean lSms) throws java.rmi.RemoteException;
    public void faxTransactionNew() throws java.rmi.RemoteException;
    public void confirmSendsms(java.lang.String cCommand, int nId, int nTable, int nTypeaccept, int nUserid) throws java.rmi.RemoteException;
    public void checkurlvalid(java.lang.String cCommand) throws java.rmi.RemoteException;
    public java.lang.String forgetPassword(java.lang.String cDomainname, java.lang.String cUsername, java.lang.String cMobileno) throws java.rmi.RemoteException;
    public java.lang.String chargeuser(java.lang.String cDomainname, java.lang.String cUsername, java.lang.String cpassword, java.lang.String cUsercharge, long nCharge, java.lang.String cDesCharge) throws java.rmi.RemoteException;
    public void getSmsAsanak(java.lang.String cCommand) throws java.rmi.RemoteException;
    public void getsmsRahyabDll(java.lang.String cCommand) throws java.rmi.RemoteException;
    public java.lang.String activateCentral(java.lang.String cUSername, java.lang.String cPassword, java.lang.String cDomainname, java.lang.String cSerial) throws java.rmi.RemoteException;
    public void moneybacktoUser(java.lang.String cCommand, int nservice, int nSmsServerid) throws java.rmi.RemoteException;
    public java.lang.String writeXMLS(java.lang.String cXMLS) throws java.rmi.RemoteException;
    public int fixSend(java.lang.String cCommand) throws java.rmi.RemoteException;
    public int killProccess(java.lang.String cCommand) throws java.rmi.RemoteException;
    public boolean checkSendEmailToServer() throws java.rmi.RemoteException;
    public boolean getEmails() throws java.rmi.RemoteException;
    public java.lang.String sendArea(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cBody, long nRandomList, int nCMessage, java.lang.String m_SchedulDate, java.lang.String cDomainname, java.lang.String cFromNumber, long npro, java.lang.String careacode, java.lang.String cfilter, long nbank, int nSpeedsms, int nPeriodmin, java.lang.String cStartTime, java.lang.String cEndTime) throws java.rmi.RemoteException;
    public java.lang.String sendSms(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cBody, java.lang.String cSmsnumber, java.lang.String cGetid, int nCMessage, int nTypeSent, java.lang.String m_SchedulDate, java.lang.String cDomainname, java.lang.String cFromNumber, int nSpeedsms, int nPeriodmin, java.lang.String cstarttime, java.lang.String cEndTime) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString checkFeeSms(xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString cSystemChecker) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong sendSms1To1(java.lang.String cDomainname, java.lang.String cUserName, java.lang.String cPassword, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aBody, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aMobileno, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong aGetid, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt aCMessage, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aFromNumber, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt atypeUnicodemessage, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString am_SchedulDate, int nTypeSent, int nSpeedsms, int nPeriodmin) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getDelivery(java.lang.String cUserName, java.lang.String cPassword, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString aSid) throws java.rmi.RemoteException;
    public java.lang.String changePassword(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cNewPassword, java.lang.String cDomainName) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getuserInfo(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cDomainName) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString getDeliveryWithGetid(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cGetid, boolean lReturnSid, java.lang.String cDomainname) throws java.rmi.RemoteException;

    public void receivesmsLowLevel(java.lang.String cUserName, java.lang.String cPassword, boolean lReceiveAllmsg, java.lang.String cDomainName, java.lang.String cFromnumber, xyz.homapay.hampay.smsgateway.model.remote.holders.ArrayOfStringHolder aBody, xyz.homapay.hampay.smsgateway.model.remote.holders.ArrayOfStringHolder aMobileno, xyz.homapay.hampay.smsgateway.model.remote.holders.ArrayOfLongHolder aMessageid, xyz.homapay.hampay.smsgateway.model.remote.holders.ArrayOfStringHolder aReceivedate, xyz.homapay.hampay.smsgateway.model.remote.holders.ArrayOfStringHolder afromnumber) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ReceiveSmsResponseReceiveSmsResult receiveSms(java.lang.String cUserName, java.lang.String cPassword, boolean lReceiveAllmsg, java.lang.String cDomainName, java.lang.String cFromnumber, java.lang.String cFromDate, java.lang.String cToDate) throws java.rmi.RemoteException;
    public java.lang.String changeReceiveNo(java.lang.String cUserName, java.lang.String cPassword, boolean lReceiveAllmsg, java.lang.String cDomainName, java.lang.String cFromNumber) throws java.rmi.RemoteException;
    public java.lang.String smsTrySendToServer(int naccountUsesid) throws java.rmi.RemoteException;
    public java.lang.String smsTrySendToServer1To1() throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt getMessageDelivery1To1(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cDomainname, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong longid) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong getMessageIds1To1(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cDomainname, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong nCustomerid) throws java.rmi.RemoteException;
    public void checkValidMobileAll(java.lang.String cCommand) throws java.rmi.RemoteException;
    public java.lang.String smsSentToServer(int naccountUsesid) throws java.rmi.RemoteException;
    public java.lang.String smsSentToServer1To1(int naccountid, java.lang.String cServerName) throws java.rmi.RemoteException;
    public java.lang.String showError(java.lang.String cErrorCode, java.lang.String cLanShow) throws java.rmi.RemoteException;
    public int getMessageLength(java.lang.String cBody) throws java.rmi.RemoteException;
    public int getUnicodeMessage(java.lang.String cBody) throws java.rmi.RemoteException;
    public java.lang.String getSms(java.lang.String cFrom, java.lang.String cTo, java.lang.String cText, java.lang.String cEnterRed_Date, java.lang.String cStatus, java.lang.String cMessageId) throws java.rmi.RemoteException;
    public void sendRecTocustomer(java.lang.String cCommand) throws java.rmi.RemoteException;
    public void sendtoc1Customer(java.lang.String cAccountid) throws java.rmi.RemoteException;
    public void getsms80(java.lang.String cCommand) throws java.rmi.RemoteException;
    public void sendDeltoCustomer(java.lang.String cCommand) throws java.rmi.RemoteException;
    public void sendTocus1MobUses(java.lang.String cAccountid) throws java.rmi.RemoteException;

    public xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong mehrafrazDelivery(java.lang.String cCommand, java.lang.String cFormatSms, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfLong asid, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfInt nsmsstatus, xyz.homapay.hampay.smsgateway.model.remote.ArrayOfString adate) throws java.rmi.RemoteException;
    public void deliveryEvent80(java.lang.String cCommand) throws java.rmi.RemoteException;
    public java.lang.String sendFax(java.lang.String cUserName, java.lang.String cPassword, java.lang.String cDomainname, java.lang.String cFaxselect, java.lang.String cFaxnumber, java.lang.String cMobileno, java.lang.String m_SchedulDate) throws java.rmi.RemoteException;
    public void autoFax(int nAccountusesid) throws java.rmi.RemoteException;
    public void faxTransaction(int nFaxUsesid) throws java.rmi.RemoteException;
    public boolean datagather(int naccountusesid, boolean lsms) throws java.rmi.RemoteException;
    public java.lang.String matchgraph(java.lang.String cDomainname, java.lang.String cUsername, java.lang.String cpassword, int nmatchid) throws java.rmi.RemoteException;
    public boolean match(long naccountusesid) throws java.rmi.RemoteException;
    public void getdelivery1To1(java.lang.String cCommand, int nTypesms) throws java.rmi.RemoteException;
    public java.lang.String checkDeliverFromServer(int nAccountUsesid, int ntypeSms) throws java.rmi.RemoteException;
    public void checkSendsmsToServer(java.lang.String cCommand, int ndis) throws java.rmi.RemoteException;
    public void checkSendsmsToServermagfa1To1(java.lang.String cCommand, java.lang.String cServername) throws java.rmi.RemoteException;
    public void checkRealDelivey(java.lang.String cCommand, int ntypesms) throws java.rmi.RemoteException;
    public void checkRealDelivey2000(java.lang.String cCommand, java.lang.String csmsserver, boolean ldelegate) throws java.rmi.RemoteException;
    public void automailanswer(int nAccountusesid) throws java.rmi.RemoteException;
}
