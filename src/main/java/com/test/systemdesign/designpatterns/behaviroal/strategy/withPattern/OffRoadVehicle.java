package com.test.systemdesign.designpatterns.behaviroal.strategy.withPattern;

import com.test.systemdesign.designpatterns.behaviroal.strategy.withPattern.drivestrategy.SportsDrive;

/**
 * This class will have same drive method as Sports Vehicle, code duplication is there
 * */
public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SportsDrive());
    }
}
