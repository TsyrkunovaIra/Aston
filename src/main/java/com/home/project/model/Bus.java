package com.home.project.model;

public class Bus {
    private  int number;
    private  String model;
    private long mileage;
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
    public void setMileage(long mileage) {
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
    public static class BusBuilder {
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
       public BusBuilder withMileage(long mileage){
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
