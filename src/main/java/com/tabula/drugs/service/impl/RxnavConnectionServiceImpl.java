package com.tabula.drugs.service.impl;

import com.tabula.drugs.dto.RxNormDataDto;
import com.tabula.drugs.model.Drug;
import com.tabula.drugs.service.api.RxnavConnectionService;
import com.tabula.drugs.utils.XmlConverter;
import com.tabula.drugs.utils.translator.api.Transliterator;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * @author Vladyslav_Vinnyk on 12/15/2016.
 */
@Service
public class RxnavConnectionServiceImpl implements RxnavConnectionService {
    @Autowired
    private RestOperations restOperations;

    @Autowired
    private XmlConverter xmlConverter;

    @Autowired
    private Transliterator transliterator;

    @Override
    public Drug getDrugsByName(String name) {
        name = "lipitor";
        RestTemplate restTemplate = new RestTemplate();
        try {
            RxNormDataDto rxNormDataDto = (RxNormDataDto) xmlConverter.doUnMarshaling(get("https://rxnav.nlm.nih.gov/REST/rxcui?name=" + name));
            return new Drug(rxNormDataDto.getIdGroup(), transliterator.transliterate(rxNormDataDto.getIdGroup().getName().toLowerCase(Locale.ENGLISH)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Drug getDrugByRxnormId(String rxnormId) {
        rxnormId = "7052";
        RestTemplate restTemplate = new RestTemplate();

        try {
            RxNormDataDto rxNormDataDto = (RxNormDataDto) xmlConverter.doUnMarshaling(get("https://rxnav.nlm.nih.gov/REST/rxcui/" + rxnormId));
            return new Drug(rxNormDataDto.getIdGroup(), transliterator.transliterate(rxNormDataDto.getIdGroup().getName().toLowerCase(Locale.ENGLISH)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String get(String url) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", HTTP.USER_AGENT);
        HttpResponse response = null;
        try {
            response = client.execute(request);


            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            //TODO
            throw new RuntimeException(e);
        }
    }
}
