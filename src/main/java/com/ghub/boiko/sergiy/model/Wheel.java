package com.ghub.boiko.sergiy.model;

public class Wheel {

    Tyres tyres;

    public Wheel(){}

    public Wheel(Tyres tyres) {
        this.tyres = tyres;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

}
