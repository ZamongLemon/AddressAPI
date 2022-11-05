package com.puhu17.addressapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.puhu17.addressapi.domain.AddressDTO;

@Mapper
public interface AddressMapper {
    @SelectProvider(type= AddressSQL.class,method="findAddress")
    List<AddressDTO> findAddress(String[] received);
}
