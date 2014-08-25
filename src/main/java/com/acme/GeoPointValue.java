package com.acme;

public class GeoPointValue {

    @org.springframework.data.mongodb.core.mapping.Field(value = "0")
    double lon;

    @org.springframework.data.mongodb.core.mapping.Field(value = "1")
    double lat;

    @org.springframework.data.mongodb.core.mapping.Field(value = "2")
    double value;

    public GeoPointValue() {}

    public GeoPointValue(double lon, double lat, double value) {
        this.lon = lon;
        this.lat = lat;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
