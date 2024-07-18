package com.vmware.gemfire.restapi.controller;

import com.vmware.gemfire.restapi.models.Region;
import com.vmware.gemfire.restapi.service.RegionService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
public class RegionController {
    @Autowired
    private RegionService regionService;

    @Operation(summary = "Creates a new region")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Created the region"),
    @ApiResponse(responseCode = "400", description = "Bad request",
            content = @Content),
    @ApiResponse(responseCode = "500", description = "Internal Server Error",
            content = @Content) })
    @PostMapping("/add")
    public void addRegion() {
        regionService.addRegion();
    }

    @GetMapping("/view")
    public List<Region> viewRegions() {
        return regionService.getRegions();
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
