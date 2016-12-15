package com.tabula.drugs.utils;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
public class Converter {
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    //Converts Object to XML file
    public void doMarshaling(String fileName, Object graph) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            marshaller.marshal(graph, new StreamResult(fos));
        } finally {
            fos.close();
        }
    }

    //Converts XML to Java Object
    public Object doUnMarshaling(String fileName) throws IOException {
        InputStream stream = new ByteArrayInputStream(fileName.getBytes(StandardCharsets.UTF_8));
        return unmarshaller.unmarshal(new StreamSource(stream));
    }
}
