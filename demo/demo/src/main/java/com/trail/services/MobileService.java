package com.trail.services;

import com.trail.contoller.RequestDTO;
import com.trail.contoller.ResponseDTO;
import com.trail.contoller.ResponseData;
import com.trail.model.Mobile;
import com.trail.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class MobileService {

    @Autowired
    private MobileRepository repository;

    public Mobile addMobile(Mobile mobile){
        return repository.save(mobile);
    }

    public List<Mobile> viewAllMobile(){
        return repository.findAll();
    }

    public List<Mobile> viewByBrand(String brandName){
        return repository.findByBrand(brandName);
    }

    public ResponseDTO TestTwo(RequestDTO requestDTO){

        String bName = requestDTO.getBrandName();
        List<String> phoneList = repository.findName(bName);

        List<ResponseData> finalList = new ArrayList<>();

        for(String name: phoneList){
            ResponseData responseData = new ResponseData();
            responseData.setBrandName(requestDTO.getBrandName());
            responseData.setPhoneName(name);
            if(name.equals("E63")){
                responseData.setComments("Qwerty Keypad, Good built");
            } else if (name.equals("E72")) {
                responseData.setComments("Qwerty keyboard, Front Camera");
            } else if (name.equals("Lumia 510")) {
                responseData.setComments("Touchscreen, Windows phones");
            }

            finalList.add(responseData);
        }

        //        System.out.println(finalList);

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setPhoneFinalList(finalList);

        return responseDTO;
    }
}
