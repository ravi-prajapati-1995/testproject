package com.test.designPatterns.behaviroal.strategy.withoutPattern;


/**
 In this code what problem we are facing is:
 our SportsVehicle and OffRoadVehicle has same kind of functionality:
 There is not way we can common this code so to resolve this issue we can use strategy design pattern

 Currently there is only one method  drive which we have vehicle there may be case that we have multiple methods like:
 display, noOfSeats, features there may be case that more than 1 child has same kind of code so there we have code
 duplication problem.

 So to avoid this code duplication we can use Strategy design pattern
* */
class Main {
    public static void main(String[] args) {
        final var passengerVehicle = new PassengerVehicle();
        final var sportsVehicle = new SportsVehicle();
        final var offRoadVehicle = new OffRoadVehicle();

        passengerVehicle.drive();
        sportsVehicle.drive();
        offRoadVehicle.drive();
    }
}