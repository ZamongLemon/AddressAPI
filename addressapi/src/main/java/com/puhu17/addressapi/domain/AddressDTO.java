package com.puhu17.addressapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDTO {
    private String postcode,city,guname,roadname,roadnum1,roadnum2,buildingname,fulladdress;
}
