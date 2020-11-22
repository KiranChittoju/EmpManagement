package com.example.employer.Model;

public class EmployeesDetails {

    String UserName;
    String BusinessCode;
    String Password;
    String FirstName;
    String LastName;
    String Phone;
    String Address;

    public EmployeesDetails(String userName, String businessCode, String password, String firstName, String lastName, String phone, String address) {
        UserName = userName;
        BusinessCode = businessCode;
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        Phone = phone;
        Address = address;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getBusinessCode() {
        return BusinessCode;
    }

    public void setBusinessCode(String businessCode) {
        BusinessCode = businessCode;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public EmployeesDetails(){

    }
}
