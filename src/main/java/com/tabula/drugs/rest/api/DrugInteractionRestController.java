package com.tabula.drugs.rest.api;

import com.tabula.drugs.dto.InteractionDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * @author Vladyslav_Vinnyk on 12/21/2016.
 */
@Api(description = "API to check interaction of drugs", produces = "application/json")
@RequestMapping("/interaction")
public interface DrugInteractionRestController {
    @ApiOperation(value = "If excists return All Drugs Interactions by specified rxcui.",
            notes = "List of InteractionDto")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successful"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @RequestMapping(value = "",
            params = "rxcui",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<InteractionDto> searchInteraction(@RequestParam Set<String> rxcui);
}
