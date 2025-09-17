package se.projektarbete.projektarbetews.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.projektarbete.projektarbetews.exception.ResourceNotFoundException;
import se.projektarbete.projektarbetews.model.Customer;
import se.projektarbete.projektarbetews.repository.CustomerRepository;

import java.util.List;

@Service
@Transactional // enhetliga transaktioner för skrivoperationer
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // ================================================================
    // READ – alla
    // ================================================================
    @Transactional(readOnly = true)
    public List<Customer> getAll() {
        return repository.findAll();
    }

    // ================================================================
    // READ – via id (404 om saknas)
    // ================================================================
    @Transactional(readOnly = true)
    public Customer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));
    }

    // ================================================================
    // CREATE
    // ================================================================
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    // ================================================================
    // UPDATE (404 om saknas)
    // ================================================================
    public Customer update(Long id, Customer updated) {
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));

        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        return repository.save(existing);
    }

    // ================================================================
    // DELETE (404 om saknas)
    // ================================================================
    public void delete(Long id) {
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));
        repository.delete(existing);
    }
}
