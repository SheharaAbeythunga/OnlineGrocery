package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerSaveDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerSaveDTO customerSaveDTO);
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();


    String deleteCustomerById(int customerId);


    List<CustomerDTO> findCustomerByActiveState(boolean state);
}
