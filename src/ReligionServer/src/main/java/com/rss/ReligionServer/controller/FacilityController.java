package com.rss.ReligionServer.controller;

import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;
import com.rss.ReligionServer.response.ResponseForm;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacilityController {
    @RequestMapping(value = "/registerFacility", method = RequestMethod.POST)
    public ResponseForm registerFacility(@RequestBody FacilityModel facilityModel) {
        return null;
    }

    @RequestMapping(value = "/getFacilityAll", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityAll() {
        return null;
    }

    @RequestMapping(value = "/getFacilityByPos", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityByPos(@RequestBody AddressModel addressModel) {
        return null;
    }

    @RequestMapping(value = "/getFacilityByCate", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityByCate(@RequestParam String category) {
        return null;
    }

    @RequestMapping(value = "/getFacilityByName", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityByName(@RequestParam String name) {
        return null;
    }

    @RequestMapping(value = "/updateFacility", method = RequestMethod.PUT)
    public ResponseForm modifyFacility(@RequestBody FacilityModel facilityModel) {
        return null;
    }

    @RequestMapping(value = "/removeFacility", method = RequestMethod.DELETE)
    public ResponseForm deleteFacility(@RequestParam int facilityId) {
        return null;
    }
}
