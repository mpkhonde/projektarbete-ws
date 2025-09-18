package se.projektarbete.projektarbetews.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.projektarbete.projektarbetews.exception.ResourceNotFoundException;
import se.projektarbete.projektarbetews.model.Customer;
import se.projektarbete.projektarbetews.repository.CustomerRepository;

import java.util.List;

@Service
@Transactional // säkerställer enhetliga transaktioner för alla skrivoperationer
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    // ================================================================
    // READ – hämta alla kunder
    // ================================================================
    @Transactional(readOnly = true)
    public List<Customer> getAll() {
        return repository.findAll();
    }

    // ================================================================
    // READ – hämta kund via ID (404 om saknas)
    // ================================================================
    @Transactional(readOnly = true)
    public Customer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));
    }

    // ================================================================
    // READ – hämta kund via e-post (404 om saknas)
    // ================================================================
    @Transactional(readOnly = true)
    public Customer findByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with email " + email + " not found"));
    }

    // ================================================================
    // CREATE – spara ny kund
    // ================================================================
    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    // ================================================================
    // UPDATE – uppdatera befintlig kund (404 om saknas)
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
    // DELETE – radera kund via ID (404 om saknas)
    // ================================================================
    public void delete(Long id) {
        Customer existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + " not found"));
        repository.delete(existing);
    }

    // ================================================================
    // DELETE ALL – radera samtliga kunder
    // ================================================================
    public void deleteAll() {
        repository.deleteAll();
    }
}
