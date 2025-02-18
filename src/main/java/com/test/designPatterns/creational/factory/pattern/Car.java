package com.test.designPatterns.creational.factory.pattern;

public class Car implements Vehicle{
    @Override
    public void drive() {
        System.out.println("Drive a car");
    }
}
