package com.springbootacademy.pointofsale.dto.request;

import com.springbootacademy.pointofsale.entity.enums.MeasuringUnitType;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemSaveDTO {
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplierPrice;
    private double sellingPrice;
}
