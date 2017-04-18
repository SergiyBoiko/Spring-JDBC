package com.ghub.boiko.sergiy.model;

public class Tyres {

    private String size;
    private String name;

    public Tyres(){}

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tyres{" +
                "size='" + size + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
