package com.rss.ReligionServer.controller;

import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;
import com.rss.ReligionServer.response.ResponseForm;
import com.rss.ReligionServer.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacilityController {
    @Autowired
    FacilityService facilityService;

    @RequestMapping(value = "/registerFacility", method = RequestMethod.POST)
    public ResponseForm registerFacility(@RequestBody FacilityModel facilityModel) {
        int result;
        try {
            result = facilityService.registerFacility(facilityModel);
        } catch (Exception e) {
            return new ResponseForm(1, -1, e.toString());
        }
        return new ResponseForm(0, result, "");
    }

    @RequestMapping(value = "/getFacilityAll", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityAll() {
        List<FacilityModel> facilityModels;
        try {
            facilityModels = facilityService.findAll();
            if(facilityModels == null) throw new Exception();

            return facilityModels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/getFacilityByPos", method = RequestMethod.POST)
    public List<FacilityModel> findFacilityByPos(@RequestBody AddressModel addressModel) {
        List<FacilityModel> facilityModels;

        try {
            facilityModels = facilityService.findFacilityByPos(addressModel);
            if(facilityModels == null) throw new Exception();
            return facilityModels;
        }catch (Exception e) {
            e.printStackTrace();
        }
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
