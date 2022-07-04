package com.bridgelabz.cab;

public class Ride {

    public RideCategory rideType;
    public double distance;
    public int time;

    public Ride(RideCategory rideType, double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;

    }
}