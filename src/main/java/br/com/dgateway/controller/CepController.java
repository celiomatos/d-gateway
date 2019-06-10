package br.com.dgateway.controller;

import br.com.dgateway.model.CepResponse;
import br.com.dgateway.service.CepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(value = "d gateway")
@RestController
@RequestMapping("v1/ceps")
public class CepController {

    @Autowired
    private CepService cepService;

    @ApiOperation(value = "get cep")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{cep}")
    public CepResponse getCep(
            @ApiParam(value = "cep", required = true)
            @PathVariable String cep) {
        return cepService.getCep(cep);
    }
}
