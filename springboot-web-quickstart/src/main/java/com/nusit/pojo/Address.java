package com.nusit.pojo;

public class Address {
    private String province;
    private String city;

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    @Override
    public String toString() {
        return "Address{province = "+province+", city = "+city+"}";
    }
}
