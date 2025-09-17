package se.projektarbete.projektarbetews.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.projektarbete.projektarbetews.model.Customer;
import se.projektarbete.projektarbetews.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // ================================================================
    // GET alla
    // ================================================================
    @Operation(summary = "Hämta alla kunder", description = "Returnerar en lista på alla kunder i systemet.")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Kunder hämtades") })
    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }

    // ================================================================
    // GET via ID
    // ================================================================
    @Operation(summary = "Hämta kund via ID", description = "Sök efter en kund baserat på dess unika ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Kund hittades"),
            @ApiResponse(responseCode = "404", description = "Kund saknas")
    })
    @GetMapping("/{id}")
    public Customer getById(
            @Parameter(description = "Kundens unika ID", example = "1")
            @PathVariable Long id) {
        return service.getById(id);
    }

    // ================================================================
    // POST
    // ================================================================
    @Operation(summary = "Skapa ny kund", description = "Lägger till en ny kund i systemet.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Kund skapades"),
            @ApiResponse(responseCode = "400", description = "Valideringsfel")
    })
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        if (customer.getName() == null || customer.getEmail() == null) {
            return ResponseEntity.badRequest().build();
        }
        Customer saved = service.create(customer);
        return ResponseEntity.status(201).body(saved);
    }

    // ================================================================
    // PUT
    // ================================================================
    @Operation(summary = "Uppdatera kund", description = "Ändrar informationen för en befintlig kund.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Kund uppdaterades"),
            @ApiResponse(responseCode = "404", description = "Kund saknas")
    })
    @PutMapping("/{id}")
    public Customer update(
            @Parameter(description = "Kundens ID som ska uppdateras", example = "1")
            @PathVariable Long id,
            @RequestBody Customer updated) {
        return service.update(id, updated);
    }

    // ================================================================
    // DELETE
    // ================================================================
    @Operation(summary = "Radera kund", description = "Tar bort en kund baserat på ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Kund raderades"),
            @ApiResponse(responseCode = "404", description = "Kund saknas")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @Parameter(description = "Kundens ID som ska raderas", example = "1")
            @PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
