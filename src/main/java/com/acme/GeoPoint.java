package com.acme;

public class GeoPoint {
    GeoPointValue[] points;

    public GeoPoint() {}

    public GeoPoint(GeoPointValue[] points) {
        this.points = points;
    }

    public GeoPointValue[] getPoints() {
        return points;
    }
}
