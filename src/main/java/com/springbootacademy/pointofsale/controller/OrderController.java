package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.request.ItemSaveDTO;
import com.springbootacademy.pointofsale.dto.request.RequestOrderSaveDto;
import com.springbootacademy.pointofsale.service.OrderService;
import com.springbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveOrder(@RequestBody RequestOrderSaveDto requestOrderSaveDto) {
        //String message=itemService.saveItem(itemSaveDTO);
orderService.saveOrder(requestOrderSaveDto);
        System.out.println(requestOrderSaveDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success","string message"),
                HttpStatus.CREATED);
    }
}
