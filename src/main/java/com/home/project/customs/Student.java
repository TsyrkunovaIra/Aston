package com.home.project.customs;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable {
    private String group;
    private int averageGrade;
    private int gradeBookNumber;
    private int year;

    public String getGroup() {
        return group;
    }
    public int getAverageGrade() {
        return averageGrade;
    }
    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }
    public long getgradeBookNumber() {
        return gradeBookNumber;
    }
    public void setgradeBookNumber(int gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
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
        return "Student Group" + group + " ,average grade " + averageGrade + " ,grade book number  " + gradeBookNumber;
    }
    @Override
    public int hashCode() {
        return Objects.hash(group, averageGrade, gradeBookNumber);
    }
    @Override
    public int compareTo(Student s)
    {
        if(this.gradeBookNumber != s.gradeBookNumber)
            return Integer.compare(this.averageGrade, s.gradeBookNumber);
        if(!this.group.equals(s.group))
            return this.group.compareTo(s.group);
        return Integer.compare(this.averageGrade, s.averageGrade);
    }

    public static class StudentBuilder implements Serializable{
        private final Student newStudent;
        public StudentBuilder () {
            newStudent = new Student();
        }
        public StudentBuilder withGroup(String group){
            newStudent.group = group;
            return this;
        }
        public StudentBuilder withgradeBookNumber(int gradeBookNumber){
            newStudent.gradeBookNumber = gradeBookNumber;
            return this;
        }
        public StudentBuilder withAverageGrade(int averageGrade){
            newStudent.averageGrade = averageGrade;
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