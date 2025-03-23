package com.home.project.service;

import com.home.project.model.Bus;
import com.home.project.service.MyArrayList;

public class StreamSort {
   public static void main(String[] args) {

       Bus b1 = new Bus.BusBuilder()
               .withNumber(1231)
               .withMileage(32131)
               .withModel("Maz")
               .buidBus();
       Bus b2 = new Bus.BusBuilder()
               .withNumber(21351)
               .withMileage(321546)
               .withModel("Gaz")
               .buidBus();
       Bus b3 = new Bus.BusBuilder()
               .withNumber(1655)
               .withMileage(3213131)
               .withModel("Vaz")
               .buidBus();
       Bus b4 = new Bus.BusBuilder()
               .withNumber(213131)
               .withMileage(2121)
               .withModel("Belaz")
               .buidBus();

       MyArrayList buses = new MyArrayList();
       buses.add(b4);
       buses.add(b1);
       buses.add(b2);
       buses.add(b3);








   }



}
