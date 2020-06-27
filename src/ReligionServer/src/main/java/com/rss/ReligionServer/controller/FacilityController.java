package com.rss.ReligionServer.controller;

import com.rss.ReligionServer.model.AddressModel;
import com.rss.ReligionServer.model.FacilityModel;
import com.rss.ReligionServer.response.ResponseForm;
import com.rss.ReligionServer.service.FacilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacilityController {
    @Autowired
    FacilityService facilityService;

    Logger log = LoggerFactory.getLogger(FacilityController.class);

    @RequestMapping(value = "/registerFacility", method = RequestMethod.POST)
    public ResponseForm registerFacility(@RequestBody FacilityModel facilityModel) {
        int result;
        try {
            result = facilityService.registerFacility(facilityModel);
        } catch (Exception e) {
            log.error("error in controller(register)", e);
            return new ResponseForm(1, -1, e.toString());
        }
        return new ResponseForm(0, result, "");
    }

    @RequestMapping(value = "/getFacilityByUserId", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityByUserId(@RequestParam int userId) {
        List<FacilityModel> facilityModels;
        try {
            facilityModels = facilityService.findByUserId(userId);
            if(facilityModels == null) throw new Exception();

            return facilityModels;
        } catch (Exception e) {
            log.error("error in controller(findAll)", e);
        }
        return null;
    }

    @RequestMapping(value = "/getFacilityByPos", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityByPos(@RequestParam String address, @RequestParam int mode) {
        List<FacilityModel> facilityModels;

        try {
            log.info(String.format("address : %s, mode: %d", address, mode));
            facilityModels = facilityService.findFacilityByPos(address, mode);
            if(facilityModels == null) throw new Exception();
            return facilityModels;
        }catch (Exception e) {
            log.error("error in controller(findByPos)", e);
        }
        return null;
    }

    @RequestMapping(value = "/getFacilityByKind", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityByKind(@RequestParam String kind) {
        List<FacilityModel> facilityModels;

        try {
            facilityModels = facilityService.findFacilityByKind(kind);
            if(facilityModels == null) throw new Exception("null list");

            return facilityModels;
        } catch (Exception e) {
            log.error("error in controller(findByKind", e);
        }
        return null;
    }

    @RequestMapping(value = "/getFacilityByName", method = RequestMethod.GET)
    public List<FacilityModel> findFacilityByName(@RequestParam String name) {
        List<FacilityModel> facilityModels;

        try {
            facilityModels = facilityService.findFacilityByName(name);
            if(facilityModels == null) throw new Exception("null list");
            log.info(String.format("found facility: %s", facilityModels.toString()));
            return facilityModels;
        } catch (Exception e) {
            log.error("error in controller(findByName", e);
        }
        return null;
    }

    @RequestMapping(value = "/updateFacility", method = RequestMethod.PUT)
    public ResponseForm modifyFacility(@RequestBody FacilityModel facilityModel) {
        int code;
        try {
            code = facilityService.modifyFacility(facilityModel);
        } catch (Exception e){
            log.error("error in controller(modify)", e);
            return new ResponseForm(-1, facilityModel.getId(), e.toString());
        }
        return new ResponseForm(code, facilityModel.getId(), "");
    }

    @RequestMapping(value = "/deleteFacility", method = RequestMethod.DELETE)
    public ResponseForm deleteFacility(@RequestParam int facilityId) {
        int code;
        try {
            code = facilityService.deleteFacility(facilityId);
        } catch (Exception e) {
            log.error("error in controller(delete)", e);
            return new ResponseForm(-1, -1, e.toString());
        }
        return new ResponseForm(code, facilityId, "");
    }
}
