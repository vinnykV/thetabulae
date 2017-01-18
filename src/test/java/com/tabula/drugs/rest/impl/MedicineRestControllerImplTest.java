package com.tabula.drugs.rest.impl;

import com.tabula.drugs.TabulaDrugRestApplication;
import com.tabula.drugs.TestConstants;
import com.tabula.drugs.rest.api.MedicineRestController;
import com.tabula.drugs.service.api.MedicineService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Vladyslav_Vinnyk on 1/18/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TabulaDrugRestApplication.class)
@WebAppConfiguration
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class MedicineRestControllerImplTest {
    @Autowired
    private MedicineRestController medicineRestController;

    @Mock
    private MedicineService medicineService;

    private MockMvc mockMvc;

    @LocalServerPort
    private String port;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setUp() {
        ((MedicineRestControllerImpl) medicineRestController).setMedicineService(medicineService);
        mockMvc = MockMvcBuilders.standaloneSetup(medicineRestController).build();
    }

    @Test
    public void shouldParseJSONRequestProperly() throws Exception {
        mockMvc.perform(post("/medicine")
                .contentType(contentType)
                .content(TestConstants.MEDICINE_REQUEST))
                .andExpect(status().is2xxSuccessful());
        Mockito.verify(medicineService, Mockito.times(1)).saveMedicine(MedicineRestTestUtils.createExpectedMedicine());
    }

}