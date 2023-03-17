package com.springbootacademy.pointofsale.dto.request;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSaveDTO {

    private String customerName;

    private String address;

    private ArrayList contactNumbers;

    private String nic;

    private double salary;

    private boolean activeState;

}
