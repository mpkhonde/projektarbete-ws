package se.projektarbete.projektarbetews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.projektarbete.projektarbetews.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // ================================================================
    // CUSTOM QUERY METHODS
    // ================================================================

    // Hitta kund via e-post (Spring Data bygger SQL automatiskt)
    Optional<Customer> findByEmail(String email);
}
