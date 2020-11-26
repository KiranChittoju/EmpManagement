package com.example.employer.Model;

public class EmployeesBank {

    String Vacation;
    String Sickness_hrs;
    String User_id;

    public EmployeesBank(String vacation, String sickness_hrs, String user_id) {
        Vacation = vacation;
        Sickness_hrs = sickness_hrs;
        User_id = user_id;
    }
    public EmployeesBank(){

    }

    public String getVacation() {
        return Vacation;
    }

    public void setVacation(String vacation) {
        Vacation = vacation;
    }

    public String getSickness_hrs() {
        return Sickness_hrs;
    }

    public void setSickness_hrs(String sickness_hrs) {
        Sickness_hrs = sickness_hrs;
    }

    public String getUser_id() {
        return User_id;
    }

    public void setUser_id(String user_id) {
        User_id = user_id;
    }
}
