package com.puhu17.addressapi.service;

import com.puhu17.addressapi.domain.AddressDTO;
import com.puhu17.addressapi.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    //맵퍼 의존성주입
    @Autowired
    AddressMapper addressMapper;

    //받은 쿼리로 검색하는 메소드
    @Override
    public List<AddressDTO> find(String query) {

        //쿼리를 검색용도로 파싱
        String[] val = querySplitter(query);
        List<AddressDTO> addressDTOS = null;
        addressDTOS = addressMapper.findAddress(val);
        return addressDTOS;
    }

    public String[] querySplitter(String query){

        String[] a = query.trim().split(" ");
        int j = a.length;
        for(int i = 0 ; i < j ; i++){
            a[i] = a[i].trim();
            if(a[i].endsWith("시")){
                a[i] = a[i].substring(0,a[i].length()-1);
            }

        }
        return a;
    }
}
