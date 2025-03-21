package com.pm.smallbusinessmanagement.service;

import com.pm.smallbusinessmanagement.model.Customer;
import com.pm.smallbusinessmanagement.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(client -> {
                    client.setName(updatedCustomer.getName());
                    client.setContactInfo(updatedCustomer.getContactInfo());
                    client.setDebt(updatedCustomer.getDebt());
                    client.setDiscount(updatedCustomer.getDiscount());
                    return customerRepository.save(client);
                }).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}

