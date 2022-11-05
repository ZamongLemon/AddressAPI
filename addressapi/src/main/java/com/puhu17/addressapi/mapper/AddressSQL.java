package com.puhu17.addressapi.mapper;

public class AddressSQL {
    public static final String findAddress =  " SELECT * FROM address where ";

    public String findAddress(String[] received) {

        StringBuilder query = new StringBuilder();

        query.append(findAddress);

        int j = (received.length <= 8 )? received.length: 8;
        for(int i = 0 ; i < j ; i++){
            query.append("fulladdress like '%"+received[i]+"%' ");
            if(i < j-1) query.append("and ");
        }
        query.append("limit 20");
        return query.toString();
    }
}
