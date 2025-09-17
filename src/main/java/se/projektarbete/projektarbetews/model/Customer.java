package se.projektarbete.projektarbetews.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Schema(description = "Kund-entity som representerar en kund i systemet")
public class Customer {

    // ================================================================
    // Fält
    // ================================================================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unikt ID för kunden (genereras automatiskt)", example = "1")
    private Long id;

    @Schema(description = "Kundens fullständiga namn", example = "Anna Svensson")
    private String name;

    @Schema(description = "Kundens e-postadress", example = "anna.svensson@example.com")
    private String email;

    @Schema(description = "Kundens telefonnummer", example = "+46701234567")
    private String phone;

    // ================================================================
    // Konstruktorer
    // ================================================================
    public Customer() {} // Tom konstruktor krävs av JPA

    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // ================================================================
    // Getters & Setters
    // ================================================================
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }
}
