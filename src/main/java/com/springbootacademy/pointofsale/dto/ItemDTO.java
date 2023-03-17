package com.springbootacademy.pointofsale.dto;

import com.springbootacademy.pointofsale.entity.enums.MeasuringUnitType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringUnitType;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;

    private boolean activeState;

}
