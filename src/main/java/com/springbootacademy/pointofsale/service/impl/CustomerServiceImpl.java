package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerSaveDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.repo.CustomerRepo;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;
    // @Override
//    public String saveCustomer(CustomerDTO customerDTO) {
//        Customer customer=new Customer(
//                customerDTO.getCustomerId(),
//                customerDTO.getCustomerName(),
//                customerDTO.getAddress(),
//                customerDTO.getContactNumbers(),
//                customerDTO.getNic(),
//                customerDTO.getSalary(),
//                customerDTO.isActiveState()
//        );
//        customerRepo.save(customer);
//        return "Saved from impl";
//    }

    @Override
    public String saveCustomer(CustomerSaveDTO customerSaveDTO) {
        Customer customer = modelMapper.map(customerSaveDTO, Customer.class);
        customerRepo.save(customer);
        return "Saved from impl2";
    }

    //    @Override
//    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
//        if(customerRepo.existsById(customerUpdateDTO.getCustomerId())){
//            Customer customer=customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
//            customer.setCustomerName(customerUpdateDTO.getCustomerName());
//            customer.setAddress(customerUpdateDTO.getAddress());
//            customer.setContactNumbers(customerUpdateDTO.getContactNumbers());
//            customerRepo.save(customer);
//        }
//        else {
//            throw new RuntimeException("id not found");
//        }
//        return "updated";
//    }
    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setAddress(customerUpdateDTO.getAddress());
            customer.setContactNumbers(customerUpdateDTO.getContactNumbers());
            customerRepo.save(customer);
        } else {
            throw new RuntimeException("id not found");
        }
        return "updated";
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getAddress(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.getSalary(),
                    customer.isActiveState()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("No customer available");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getAddress(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.getSalary(),
                    customer.isActiveState()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }

    @Override
    public String deleteCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Deleted success.";
        } else {
            throw new RuntimeException("No customer found.");
        }
    }

    @Override
    public List<CustomerDTO> findCustomerByActiveState(boolean state) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveStateEquals(state);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        for (Customer customer : getAllCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getAddress(),
                    customer.getContactNumbers(),
                    customer.getNic(),
                    customer.getSalary(),
                    customer.isActiveState()
            );

            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
