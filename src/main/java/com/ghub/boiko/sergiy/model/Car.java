package com.ghub.boiko.sergiy.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Wheel wheels;
    private Engine engine;

    @Autowired
    public Car(Wheel wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public Wheel getWheels() {
        return wheels;
    }

    @Autowired
    public void setWheels(Wheel wheels) {
        this.wheels = wheels;
    }

    public Engine getEngine() {
        return engine;
    }

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "\nwheels tyre size = " + getWheels().getTyres().getSize() +
                "\nwheels tyre name = " + getWheels().getTyres().getName() +
                "\nengine car = " + getEngine().getEngineСapacity() +
                '}';
    }
}
