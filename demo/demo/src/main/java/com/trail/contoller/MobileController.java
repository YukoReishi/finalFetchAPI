package com.trail.contoller;

import com.trail.model.Mobile;
import com.trail.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService service;

    @PostMapping("/add")
    public ResponseEntity<?> addMobile(@RequestBody Mobile mobile){
        return new ResponseEntity<>(service.addMobile(mobile), HttpStatus.OK);
    }

    @GetMapping("/viewall")
    public ResponseEntity<?> viewAllMobiles(){
        return new ResponseEntity<>(service.viewAllMobile(), HttpStatus.OK);
    }

    @GetMapping("/viewbybrand")
    public ResponseEntity<?> viewByBrand(@Param("brand") String brand){
        return new ResponseEntity<>(service.viewByBrand(brand), HttpStatus.OK);
    }

    @PostMapping("/testAPI2")
    public ResponseEntity<?> testAPITwo(@RequestBody RequestDTO dto){
        return new ResponseEntity<>(service.TestTwo(dto), HttpStatus.OK);
    }
}
