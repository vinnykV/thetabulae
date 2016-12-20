package com.tabula.drugs.service.impl;

import com.tabula.drugs.dto.RxNormDataDto;
import com.tabula.drugs.model.Drug;
import com.tabula.drugs.service.api.ApplicationPropertyService;
import com.tabula.drugs.service.api.RxnavConnectionService;
import com.tabula.drugs.utils.XmlConverter;
import com.tabula.drugs.utils.api.RequestSender;
import com.tabula.drugs.utils.translator.api.Transliterator;
import com.tabula.drugs.utils.translator.utils.CharacterUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private RequestSender requestSender;

    @Autowired
    private ApplicationPropertyService applicationPropertyService;

    @Autowired
    private XmlConverter xmlConverter;

    @Autowired
    private Transliterator transliterator;

    @Override
    public Drug getDrugsByName(String name) {
        if (CharacterUtils.isRussian(name)) {
            name = transliterator.transliterate(name);
        }
        try {
            String response = requestSender.send(applicationPropertyService.getUrlToRetrieveDrugByName() + name);
            RxNormDataDto rxNormDataDto = (RxNormDataDto) xmlConverter.doUnMarshaling(response);
            if (rxNormDataDto.getIdGroup().getRxnormId() == null) {
                throw new RuntimeException("Drug not Found!");
            }
            return new Drug(rxNormDataDto.getIdGroup(), getRusName(rxNormDataDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Drug getDrugByRxnormId(String rxnormId) {
        try {
            String response = requestSender.send(applicationPropertyService.getUrlToRetrieveDrugByRxcui() + rxnormId);
            RxNormDataDto rxNormDataDto = (RxNormDataDto) xmlConverter.doUnMarshaling(response);
            return new Drug(rxNormDataDto.getIdGroup(), getRusName(rxNormDataDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getRusName(RxNormDataDto rxNormDataDto) {
        return transliterator.transliterate(rxNormDataDto.getIdGroup().getName().toLowerCase(Locale.ENGLISH));
    }

}