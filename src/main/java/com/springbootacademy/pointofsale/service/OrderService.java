package com.springbootacademy.pointofsale.service;


import com.springbootacademy.pointofsale.dto.request.RequestOrderSaveDto;

public interface OrderService {
    void saveOrder(RequestOrderSaveDto requestOrderSaveDto);
}
