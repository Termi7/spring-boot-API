package com.amigos;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController

class CustomerHTTP {

    private final CustomerRepository repository;

    CustomerHTTP(CustomerRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/customers")
    List<Customer> all() {
        return repository.findAll();
    }


    @PostMapping("/customers")
    Customer newEmployee(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }


    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    Customer replaceEmployee(@RequestBody Customer newCustomer, @PathVariable Integer id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newCustomer.getName());
                    employee.setEmail(newCustomer.getEmail());
                    employee.setId(newCustomer.getId());
                    employee.setAge(newCustomer.getAge());


                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }

    @PatchMapping("/customers/{id}")
    Customer updateEmployee(@RequestBody Customer customer, @PathVariable Integer id) {
        return repository.findById(id)
                .map(existingCustomer -> {
                    if (customer.getName() != null) {
                        existingCustomer.setName(customer.getName());
                    }
                    if (customer.getEmail() != null) {
                        existingCustomer.setEmail(customer.getEmail());
                    }
                    if (customer.getAge() != null) {
                        existingCustomer.setAge(customer.getAge());
                    }
                    return repository.save(existingCustomer);
                })
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @DeleteMapping("/customers/{id}")
    void deleteEmployee(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}

