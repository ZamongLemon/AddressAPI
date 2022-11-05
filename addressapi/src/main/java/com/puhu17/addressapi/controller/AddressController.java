package com.puhu17.addressapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.puhu17.addressapi.domain.AddressDTO;
import com.puhu17.addressapi.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
    @GetMapping(value = "/getaddress/{address}",produces = "text/plain;charset=UTF-8")
    public String getAddress(@PathVariable("address") String address) throws Exception{
        Gson gson = new Gson();
        List<AddressDTO> addressDTOS = null;
        if(address!="" || address!=null)
            addressDTOS =addressService.find(address);
        else
            addressDTOS = null;
        
        if(addressDTOS!=null) {
        	return gson.toJson(addressDTOS) ;        	
        }else return "결과가 없습니다. 새로 입력해보세요.";
    }

}