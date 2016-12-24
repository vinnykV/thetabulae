/**
 * InteractionDBManager.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.api;

import com.tabula.drugs.utils.interactionApi.beans.*;

public interface InteractionDBManager extends java.rmi.Remote {
    public java.lang.String[] getVersion() throws java.rmi.RemoteException;
    public java.lang.String[] getInteractionSources() throws java.rmi.RemoteException;
    public InteractionTypeGroup[] findDrugInteractions(java.lang.String rxcui, java.lang.String[] sources) throws java.rmi.RemoteException;
    public FullInteractionTypeGroup[] findInteractionsFromList(java.lang.String[] rxcuiList, java.lang.String[] sources) throws java.rmi.RemoteException;
    public InteractionType DUMMY_DONOTUSE_getOneInteractionType() throws java.rmi.RemoteException;
    public FullInteractionType DUMMY_DONOTUSE_getOneFullInteractionType() throws java.rmi.RemoteException;
    public InteractionConcept DUMMY_DONOTUSE_getOneInteractionConcept() throws java.rmi.RemoteException;
    public InteractionPair DUMMY_DONOTUSE_getOneInteractionPair() throws java.rmi.RemoteException;
    public MinConcept DUMMY_DONOTUSE_getOneMinConcept() throws java.rmi.RemoteException;
}
