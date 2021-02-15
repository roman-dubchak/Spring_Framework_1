package Lesson9_rest.controller;

import Lesson9_rest.dto.CustomerInput;
import Lesson9_rest.dto.ErrorDto;
import Lesson9_rest.entities.Customer;
import Lesson9_rest.exeption.CustomerNotFoundException;
import Lesson9_rest.repo.CustomerRepo;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController("/api/v1/customer")
public class CustomerController {

    //TODO 1. Добавить сущность Customer с полями
    // (id(id в формате UUID), firstName, lastName, city), также через ликвибэйз
    // 2. Добавить контроллер для кастомера, создание(через дто), получение по идентификатору,
    // получение по нескольким идентификаторам, пока что без валидации.

    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
    private final CustomerRepo customerRepo;

    @GetMapping("/")
    public List<Customer> findAll(){
        return customerRepo.findAll();
    }

    @PostMapping("/save")
    public UUID saveCustomer(@RequestBody @Valid CustomerInput customerInput){
        Customer customer = new Customer();
        customer.setFirstname(customerInput.getFirstName());
        customer.setLastname(customerInput.getLastName());
        customer.setCity(customerInput.getCity());

        return customerRepo.save(customer).getId();
    }

    @GetMapping("/customer/{id}")
    public Customer findCustomerBiId(@PathVariable("id") UUID id){
        return customerRepo.findById(id).orElseThrow(()
                -> new CustomerNotFoundException(String.format("Not found Customer by this id %s", id)));
    }

    @ExceptionHandler
    public ErrorDto errorDto(CustomerNotFoundException e){
        return new ErrorDto(e.getMessage());
    }

    @PostMapping("/all")
    public List<Customer> findAllCustomerById(@RequestParam("id") List<UUID> id){
        return customerRepo.findAllById(id);
    }
}
