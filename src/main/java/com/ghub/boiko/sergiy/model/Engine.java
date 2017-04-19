package com.ghub.boiko.sergiy.model;

import java.math.BigDecimal;


public class Engine {

    private BigDecimal engineСapacity;

    public Engine(BigDecimal engineСapacity) {
        this.engineСapacity = engineСapacity;
    }

    public BigDecimal getEngineСapacity() {
        return engineСapacity;
    }

    public void setEngineСapacity(BigDecimal engineСapacity) {
        this.engineСapacity = engineСapacity;
    }

}
