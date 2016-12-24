/**
 * InteractionDBManagerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.api;

public class InteractionDBManagerServiceLocator extends org.apache.axis.client.Service implements InteractionDBManagerService {

    public InteractionDBManagerServiceLocator() {
    }


    public InteractionDBManagerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public InteractionDBManagerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for InteractionAPI
    private java.lang.String InteractionAPI_address = "https://mor.nlm.nih.gov/axis/services/InteractionAPI";

    public java.lang.String getInteractionAPIAddress() {
        return InteractionAPI_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String InteractionAPIWSDDServiceName = "InteractionAPI";

    public java.lang.String getInteractionAPIWSDDServiceName() {
        return InteractionAPIWSDDServiceName;
    }

    public void setInteractionAPIWSDDServiceName(java.lang.String name) {
        InteractionAPIWSDDServiceName = name;
    }

    public InteractionDBManager getInteractionAPI() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(InteractionAPI_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getInteractionAPI(endpoint);
    }

    public InteractionDBManager getInteractionAPI(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            InteractionAPISoapBindingStub _stub = new InteractionAPISoapBindingStub(portAddress, this);
            _stub.setPortName(getInteractionAPIWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setInteractionAPIEndpointAddress(java.lang.String address) {
        InteractionAPI_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (InteractionDBManager.class.isAssignableFrom(serviceEndpointInterface)) {
               InteractionAPISoapBindingStub _stub = new InteractionAPISoapBindingStub(new java.net.URL(InteractionAPI_address), this);
                _stub.setPortName(getInteractionAPIWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("InteractionAPI".equals(inputPortName)) {
            return getInteractionAPI();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://mor.nlm.nih.gov/axis/services/InteractionAPI", "InteractionDBManagerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://mor.nlm.nih.gov/axis/services/InteractionAPI", "InteractionAPI"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("InteractionAPI".equals(portName)) {
            setInteractionAPIEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
