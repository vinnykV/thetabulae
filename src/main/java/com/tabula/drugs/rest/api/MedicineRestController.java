package com.tabula.drugs.rest.api;

import com.tabula.drugs.dto.TryDto;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.dto.medicines.SimpleMedicineDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author Vladyslav_Vinnyk on 12/26/2016.
 */
@Api(description = "API retrieve information about Medicine", produces = "application/json")
@RequestMapping("/medicine")
public interface MedicineRestController {
    @ApiOperation(value = "Returns Medicine by specified id",
            notes = "Medicine")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<MedicineDto> getMedicine(@ApiParam(name = "id", value = "Medicine identifier.", required = true) @PathVariable Long id);

    @ApiOperation(value = "Returns All Medicines",
            notes = "Medicine")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<List<SimpleMedicineDto>> getAllMedicines();

    @ApiOperation(value = "Save Medicine",
            notes = "Reutrns saved Medicine")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<MedicineDto> saveMedicine(@ApiParam(name = "medicine", value = "Medicine model.", required = true) @RequestBody MedicineDto medicine);


    @ExceptionHandler(Exception.class)
    public ModelAndView handleCustomException(Exception ex);
}