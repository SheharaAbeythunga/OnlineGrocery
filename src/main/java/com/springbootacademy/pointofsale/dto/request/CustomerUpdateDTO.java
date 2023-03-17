package com.springbootacademy.pointofsale.dto.request;

import java.util.ArrayList;

public class CustomerUpdateDTO {
    private int customerId;

    private String customerName;

    private String address;

    private ArrayList contactNumbers;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerId, String customerName, String address, ArrayList contactNumbers) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.contactNumbers = contactNumbers;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(ArrayList contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumbers=" + contactNumbers +
                '}';
    }
}
