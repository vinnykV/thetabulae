package com.tabula.drugs.rest.api;

import com.tabula.drugs.dto.TryDto;
import com.tabula.drugs.dto.medicines.MedicineDto;
import com.tabula.drugs.model.medicines.Medicine;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @ApiOperation(value = "Save Medicine",
            notes = "Reutrns saved Medicine")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<MedicineDto> saveMedicine(@ApiParam(name = "medicine", value = "Medicine model.", required = true) @RequestBody MedicineDto medicine);

    @ApiOperation(value = "Save Medicine2",
            notes = "Reutrns saved Medicine2")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful2"),
            @ApiResponse(code = 500, message = "Internal server error2")})
    @RequestMapping(value = "/2", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    ResponseEntity<MedicineDto> saveMedicine(@RequestBody TryDto tryDto);
}