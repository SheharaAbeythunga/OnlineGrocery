package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.request.RequestOrderSaveDto;
import com.springbootacademy.pointofsale.dto.response.ItemGetDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.entity.OrderDetails;
import com.springbootacademy.pointofsale.entity.Orders;
import com.springbootacademy.pointofsale.repo.CustomerRepo;
import com.springbootacademy.pointofsale.repo.ItemRepository;
import com.springbootacademy.pointofsale.repo.OrderDetailsRepo;
import com.springbootacademy.pointofsale.repo.OrderRepo;
import com.springbootacademy.pointofsale.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;
    @Override
    @Transactional
    public void saveOrder(RequestOrderSaveDto requestOrderSaveDto) {
        Orders orders = new Orders(
                customerRepo.getReferenceById(requestOrderSaveDto.getCustomer_id()),
                requestOrderSaveDto.getDate(),
                requestOrderSaveDto.getTotal()
        );
        orderRepo.save(orders);

        if (orderRepo.existsById(orders.getOrderId())) {
            List<OrderDetails> orderDetails=modelMapper.map(requestOrderSaveDto.getOrderDetailsSet(),
                    new TypeToken<List<OrderDetails>>(){}.getType());
            for(int i=0; i<orderDetails.size(); i++){
                orderDetails.get(i).setOrders(orders);
                orderDetails.get(i).setItems(itemRepository.getReferenceById(requestOrderSaveDto.getOrderDetailsSet().get(i).getItems()));
            }
            if(orderDetails.size()>0){
                orderDetailsRepo.saveAll(orderDetails);
            }
            //orderDetailsRepo.save();
        }
        return ;
    }
}
