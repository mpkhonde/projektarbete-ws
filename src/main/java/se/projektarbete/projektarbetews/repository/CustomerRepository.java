package se.projektarbete.projektarbetews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.projektarbete.projektarbetews.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository ger oss alla CRUD-metoder automatiskt:
    // save(), findAll(), findById(), delete() osv.
}
