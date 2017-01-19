package com.tabula.drugs.rest.impl;

import com.tabula.drugs.dto.TryDto;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.dtomapper.api.DtoMapper;
import com.tabula.drugs.model.medicines.Medicine;
import com.tabula.drugs.rest.api.MedicineRestController;
import com.tabula.drugs.service.api.MedicineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
@RestController
public class MedicineRestControllerImpl implements MedicineRestController {
    @Autowired
    private MedicineService medicineService;

    @Autowired
    private DtoMapper dtoMapper;

    @Override
    public ResponseEntity<MedicineDto> getMedicine(@PathVariable Long id) {
        Medicine medicine = medicineService.getMedicine(id);
        MedicineDto medicineDto = dtoMapper.convertToDto(medicine);

        return new ResponseEntity<>(medicineDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MedicineDto> saveMedicine(@RequestBody MedicineDto medicineDto) {
        Medicine medicine = dtoMapper.convertToEntity(medicineDto);
        medicineService.saveMedicine(medicine);

        return new ResponseEntity<>(new MedicineDto(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MedicineDto> saveMedicine(@RequestBody TryDto tryDto) {
        return new ResponseEntity<>(new MedicineDto(), HttpStatus.OK);
    }

    @Override
    public ModelAndView handleCustomException(Exception ex) {
        ModelAndView model = new ModelAndView("error/generic_error");
        ex.printStackTrace();
        model.addObject("errCode", ex.getStackTrace());
        model.addObject("errMsg", ex.getMessage());

        return model;
    }

    public MedicineService getMedicineService() {
        return medicineService;
    }

    public void setMedicineService(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    public DtoMapper getDtoMapper() {
        return dtoMapper;
    }

    public void setDtoMapper(DtoMapper dtoMapper) {
        this.dtoMapper = dtoMapper;
    }
}