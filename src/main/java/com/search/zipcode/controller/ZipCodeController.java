package com.search.zipcode.controller;

import com.search.zipcode.model.ZipCodeModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
@Api(value = "API Zip Code")
@CrossOrigin(origins = "*")
public class ZipCodeController {

    @Value("${url.viacep}")
    private String uri;

    @GetMapping(value="/{zip-code}")
    @ApiOperation(value = "Search for an address from a zip code")
    public ResponseEntity<ZipCodeModel> doGetZipCode(@PathVariable(name = "zip-code") String zipCode) {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> params = new HashMap<String, String>();

        params.put("zip-code", zipCode);

        ZipCodeModel zipCodeModel = restTemplate.getForObject(uri, ZipCodeModel.class, params);

        return new ResponseEntity<ZipCodeModel>(zipCodeModel, HttpStatus.OK);
    }

}
