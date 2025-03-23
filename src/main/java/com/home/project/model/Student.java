package com.home.project.model;

public class Student {
    private  int group;
    private int ball;
    private  long creditNumber;
    private int year;

    public int getGroup() {
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
    public void setCreditNumber(long creditNumber) {
        this.creditNumber = creditNumber;
    }
    public void setGroup(int group) {
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
    public static class StudentBuilder {
        private final Student newStudent;
        public StudentBuilder () {
            newStudent = new Student();
        }
        public StudentBuilder withGroup(int group){
            newStudent.group = group;
            return this;
        }
        public StudentBuilder withCreditNumber(long creditNumber){
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




