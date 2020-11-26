package com.example.employer.Model;

public class Payroll {

    String pay_date;
    String pay_amount;
    String user_id;

    public Payroll(String pay_date, String pay_amount, String user_id) {
        this.pay_date = pay_date;
        this.pay_amount = pay_amount;
        this.user_id = user_id;
    }

    public Payroll(){

    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getPay_amount() {
        return pay_amount;
    }

    public void setPay_amount(String pay_amount) {
        this.pay_amount = pay_amount;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
