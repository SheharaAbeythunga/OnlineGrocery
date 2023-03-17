package com.springbootacademy.pointofsale.entity;

import com.springbootacademy.pointofsale.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemId",length = 45)
    private int itemId;

    @Column(name = "itemName",length = 200,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuringUnitType",length = 45,nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balanceQty",length = 45,nullable = false)
    private double balanceQty;

    @Column(name = "supplierPrice",length = 45,nullable = false)
    private double supplierPrice;

    @Column(name = "sellingPrice",length = 45,nullable = false)
    private double sellingPrice;

    @Column(name = "activeState",columnDefinition = "TINYINT default 0")
    private boolean activeState;

    @OneToMany(mappedBy="items")
    private Set<OrderDetails> orderDetailsSet;


}
