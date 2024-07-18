package com.vmware.gemfire.restapi.service;

import com.vmware.gemfire.restapi.models.Region;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {
    private List<Region> regionList = new ArrayList<>();

    public void addRegion(){
        Region region = new Region();
        region.setId(1);
        region.setTitle("My first region");
        region.setMsg("This is a dummy region for demonstration purposes.");
        regionList.add(region);

        Region region2 = new Region();
        region2.setId(2);
        region2.setTitle("My second region");
        region2.setMsg("This is the second dummy region for demonstration purposes.");
        regionList.add(region2);
    }

    public List<Region> getRegions() {
        return regionList;
    }
}
