package com.springbootacademy.pointofsale.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@TypeDefs({
        @TypeDef(name="json",typeClass = JsonType.class)
})
@Entity
@Table(name="customer")
public class Customer {
    @Id
    @Column(name = "customer_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customer_name",nullable = false,length = 100)
    private String customerName;

    @Column(name = "customer_address",length = 200)
    private String address;

    @Type(type="json")
    @Column(name = "contact_numbers",columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name = "nic",length = 100)
    private String nic;

    @Column(name = "salary")
    private double salary;

    @Column(name = "active_state",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy="customer")
    private Set<Orders> ordersSet;


    public Customer() {
    }

    public Customer(int customerId, String customerName, String address, ArrayList contactNumbers, String nic, double salary, boolean activeState) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.contactNumbers = contactNumbers;
        this.nic = nic;
        this.salary = salary;
        this.activeState = activeState;
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

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumbers=" + contactNumbers +
                ", nic='" + nic + '\'' +
                ", salary=" + salary +
                ", activeState=" + activeState +
                '}';
    }
}
