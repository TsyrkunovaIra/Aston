package com.home.project.model;

import java.io.Serializable;
import java.util.Objects;

public class Bus implements Comparable<Bus>, Serializable {
    private int number;
    private String model;
    private int mileage;
    private int year;

    public int getNumber() {
        return number;
    }
    public String getModel() {
        return model;
    }
    public long getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "Bus number" + number + " ,model " + model + " ,mileage " + mileage;
    }
    @Override
    public int compareTo(Bus b)
    {
        if(this.number != b.number)
            return Integer.compare(this.number, b.number);
        if(!this.model.equals(b.model))
            return this.model.compareTo(b.model);
        return Integer.compare(this.mileage, b.mileage);
    }
    @Override
    public int hashCode() {
        return Objects.hash(number, model, mileage);
    }

    public static class BusBuilder implements Serializable{
        private final Bus newBus;
        public BusBuilder () {
            newBus = new Bus();
        }
        public BusBuilder withNumber(int number){
            newBus.number = number;
            return this;
        }
        public BusBuilder withModel(String model){
            newBus.model = model;
            return this;
        }
        public BusBuilder withMileage(int mileage){
            newBus.mileage = mileage;
            return this;
        }
        public BusBuilder withYear(int year){
            newBus.year = year;
            return this;
        }
        public Bus buidBus(){
            return newBus;
        }
    }
}