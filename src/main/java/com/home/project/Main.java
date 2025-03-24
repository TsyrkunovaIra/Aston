package com.home.project;

import com.home.project.model.Bus;
import com.home.project.model.Student;
import com.home.project.model.User;
import com.home.project.service.MyArrayList;

public class Main {
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

        Student s1 = new Student.StudentBuilder()
                .withGroup("12n")
                .withCreditNumber(12535)
                .withBall(8)
                .buidStudent();
        Student s2 = new Student.StudentBuilder()
                .withGroup("12n")
                .withCreditNumber(12535)
                .withBall(8)
                .buidStudent();
        Student s3 = new Student.StudentBuilder()
                .withGroup("12n")
                .withCreditNumber(12535)
                .withBall(8)
                .buidStudent();
        Student s4 = new Student.StudentBuilder()
                .withGroup("12n")
                .withCreditNumber(12535)
                .withBall(8)
                .buidStudent();

        MyArrayList students = new MyArrayList();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        User u1 = new User.UserBuilder()
                .withName("tim")
                .withEmail("kgrkjgerjig@lkfm")
                .withPassword("154lkj")
                .buidUser();
        User u2 = new User.UserBuilder()
                .withName("nina")
                .withEmail("fefaerffig@lkfm")
                .withPassword("1125mj")
                .buidUser();
        User u3 = new User.UserBuilder()
                .withName("tom")
                .withEmail("fkjfjrfjerof@lk")
                .withPassword("fdf152")
                .buidUser();
        User u4 = new User.UserBuilder()
                .withName("tilli")
                .withEmail("efewfqefqre@lkf")
                .withPassword("1254dff")
                .buidUser();

        MyArrayList users = new MyArrayList();
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);






    }
}
