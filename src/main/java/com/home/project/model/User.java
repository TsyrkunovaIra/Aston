package com.home.project.model;

public class User {
    private String name;
    private  String password;
    private String email;
    private int year;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString(){
        return "Name " + name + " ,password " + password + " ,email " + email;}
    public static class UserBuilder {
        private final User newUser;
        public UserBuilder () {
            newUser = new User();
        }
        public UserBuilder withGroup(String name) {
            newUser.name = name;
            return this;
        }
        public UserBuilder withPassword(String password) {
            newUser.password = password;
            return this;
        }
        public UserBuilder withEmail(String email) {
            newUser.email = email;
            return this;
        }
        public UserBuilder withYear(int year) {
            newUser.year = year;
            return this;
        }
        public User buidUser() {
            return newUser;
        }
    }
}

