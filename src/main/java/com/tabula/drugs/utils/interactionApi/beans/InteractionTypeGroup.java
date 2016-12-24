/**
 * InteractionTypeGroup.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tabula.drugs.utils.interactionApi.beans;

import java.util.Arrays;

public class InteractionTypeGroup  implements java.io.Serializable {
    private java.lang.Object[] interactionType;

    private SourceDisclaimer sourceDisclaimer;

    private SourceName sourceName;

    public InteractionTypeGroup() {
    }

    public InteractionTypeGroup(
           java.lang.Object[] interactionType,
           SourceDisclaimer sourceDisclaimer,
           SourceName sourceName) {
           this.interactionType = interactionType;
           this.sourceDisclaimer = sourceDisclaimer;
           this.sourceName = sourceName;
    }


    /**
     * Gets the interactionType value for this InteractionTypeGroup.
     * 
     * @return interactionType
     */
    public java.lang.Object[] getInteractionType() {
        return interactionType;
    }


    /**
     * Sets the interactionType value for this InteractionTypeGroup.
     * 
     * @param interactionType
     */
    public void setInteractionType(java.lang.Object[] interactionType) {
        this.interactionType = interactionType;
    }


    /**
     * Gets the sourceDisclaimer value for this InteractionTypeGroup.
     * 
     * @return sourceDisclaimer
     */
    public SourceDisclaimer getSourceDisclaimer() {
        return sourceDisclaimer;
    }


    /**
     * Sets the sourceDisclaimer value for this InteractionTypeGroup.
     * 
     * @param sourceDisclaimer
     */
    public void setSourceDisclaimer(SourceDisclaimer sourceDisclaimer) {
        this.sourceDisclaimer = sourceDisclaimer;
    }


    /**
     * Gets the sourceName value for this InteractionTypeGroup.
     * 
     * @return sourceName
     */
    public SourceName getSourceName() {
        return sourceName;
    }


    /**
     * Sets the sourceName value for this InteractionTypeGroup.
     * 
     * @param sourceName
     */
    public void setSourceName(SourceName sourceName) {
        this.sourceName = sourceName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InteractionTypeGroup)) return false;
        InteractionTypeGroup other = (InteractionTypeGroup) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.interactionType==null && other.getInteractionType()==null) || 
             (this.interactionType!=null &&
              java.util.Arrays.equals(this.interactionType, other.getInteractionType()))) &&
            ((this.sourceDisclaimer==null && other.getSourceDisclaimer()==null) || 
             (this.sourceDisclaimer!=null &&
              this.sourceDisclaimer.equals(other.getSourceDisclaimer()))) &&
            ((this.sourceName==null && other.getSourceName()==null) || 
             (this.sourceName!=null &&
              this.sourceName.equals(other.getSourceName())));
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
        if (getInteractionType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInteractionType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInteractionType(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSourceDisclaimer() != null) {
            _hashCode += getSourceDisclaimer().hashCode();
        }
        if (getSourceName() != null) {
            _hashCode += getSourceName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InteractionTypeGroup.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "InteractionTypeGroup"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("interactionType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "interactionType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceDisclaimer");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sourceDisclaimer"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SourceDisclaimer"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sourceName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sourceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:BeanService", "SourceName"));
        elemField.setNillable(true);
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
          new  org.apache.axis.encoding.ser.BeanSerializer(
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
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

    @Override
    public String toString() {
        return "InteractionTypeGroup{" +
                "sourceName=" + sourceName +
                ", interactionType=" + Arrays.toString(interactionType) +
                ", sourceDisclaimer=" + sourceDisclaimer +
                '}';
    }
}
