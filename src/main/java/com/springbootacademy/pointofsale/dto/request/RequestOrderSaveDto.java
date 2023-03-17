package com.springbootacademy.pointofsale.dto.request;

import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.entity.OrderDetails;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderSaveDto {
    private int customer_id;
    private Date date;
    private double total;
    private List<RequestOrderDetailsSaveDTO> orderDetailsSet;
}
