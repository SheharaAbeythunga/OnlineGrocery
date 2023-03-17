package com.springbootacademy.pointofsale.dto.response;

import com.springbootacademy.pointofsale.entity.enums.MeasuringUnitType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ItemGetDTO {
    private int itemId;
    private String itemName;
    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;

    private boolean activeState;
}
