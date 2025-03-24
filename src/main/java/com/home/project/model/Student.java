package com.home.project.model;

import com.home.project.service.MyBinarySearch;
import com.home.project.service.MySorting;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private  String group;
    private int ball;
    private  int creditNumber;
    private int year;

    public String getGroup() {
        return group;
    }
    public int getBall() {
        return ball;
    }
    public void setBall(int ball) {
        this.ball = ball;
    }
    public long getCreditNumber() {
        return creditNumber;
    }
    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString(){
        return "Group" + group + " ,ball " + ball + " ,credit number  " + creditNumber;
    }
    @Override
    public int hashCode() {
        return Objects.hash(group, ball, creditNumber);
    }
    @Override
    public int compareTo(Student s)
    {
        if(this.creditNumber != s.creditNumber)
            return Integer.compare(this.ball, s.creditNumber);
        if(!this.group.equals(s.group))
            return this.group.compareTo(s.group);
        return Integer.compare(this.ball, s.ball);
    }

    public static class StudentBuilder {
        private final Student newStudent;
        public StudentBuilder () {
            newStudent = new Student();
        }
        public StudentBuilder withGroup(String group){
            newStudent.group = group;
            return this;
        }
        public StudentBuilder withCreditNumber(int creditNumber){
            newStudent.creditNumber = creditNumber;
            return this;
        }
        public StudentBuilder withBall(int ball){
            newStudent.ball = ball;
            return this;
        }
        public StudentBuilder withYear(int year){
            newStudent.year = year;
            return this;
        }
        public Student buidStudent(){
            return newStudent;
        }
    }
}




