package com.springbootacademy.pointofsale.controller;
import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerSaveDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateDTO;
import com.springbootacademy.pointofsale.service.CustomerService;
import com.springbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequestMapping("api/v1/customer")
@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO){
        String message=customerService.saveCustomer(customerSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",message),HttpStatus.CREATED
        );
    }
    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message=customerService.updateCustomer(customerUpdateDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"updated",message),
                HttpStatus.OK
        );
    }
    @GetMapping(value = "/get-by-id",params = "id")
    public CustomerDTO searchCustomerById(@RequestParam(value="id") int customerId){
       CustomerDTO customerDTO= customerService.getCustomerById(customerId);
        return customerDTO;
    }
    @GetMapping("/get-all-customer")
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<CustomerDTO> customerDTOS= customerService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"success",customerDTOS), HttpStatus.OK);
    }
    @DeleteMapping(path = "delete-by-id/{id}")
    public String deleteCustomerById(@PathVariable (value="id")int customerId){
        return customerService.deleteCustomerById(customerId);
    }
   @GetMapping(path = ("find-by-active-state/{state}"))
    public List<CustomerDTO> findCustomerByActiveState(@PathVariable (value = "state") boolean state){
        return customerService.findCustomerByActiveState(state);
    }
}
