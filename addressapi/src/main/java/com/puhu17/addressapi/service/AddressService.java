package com.puhu17.addressapi.service;

import com.puhu17.addressapi.domain.AddressDTO;


import java.util.List;


public interface AddressService {

    public List<AddressDTO> find(String query);
}
