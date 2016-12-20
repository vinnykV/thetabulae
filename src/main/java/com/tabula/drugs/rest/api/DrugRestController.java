package com.tabula.drugs.rest.api;

import com.tabula.drugs.model.Drug;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Vladyslav_Vinnyk on 12/20/2016.
 */
@Api(description = "API to work Drugs", produces = "application/json")
@RequestMapping("/drugs")
public interface DrugRestController {

    @ApiOperation(value = "Return All Employee that has ItDepartment role by country Id",
            notes = "Return Map City to List Of Employee.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "/name/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Drug name(@PathVariable("name") String name);


    @ApiOperation(value = "Return All Employee that has ItDepartment role by country Id",
            notes = "Return Map City to List Of Employee.")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "/rxnormId/{rxnormId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Drug rxnormId(@PathVariable("rxnormId") String rxnormId);
}
