package com.springbootacademy.pointofsale.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderDetailsSaveDTO {
    private String itemName;
    private double qty;
    private double amount;
    private int items;
}
