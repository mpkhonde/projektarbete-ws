package se.projektarbete.projektarbetews.exception;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Standardiserad felrespons")
public class ErrorResponse {

    @Schema(description = "HTTP-statuskod", example = "404")
    private int status;

    @Schema(description = "Felkategori eller typ", example = "Not Found")
    private String error;

    @Schema(description = "Detaljerad beskrivning av felet", example = "Customer with id 123 not found")
    private String message;

    // --- Constructors ---
    public ErrorResponse() {}

    public ErrorResponse(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    // --- Getters & Setters ---
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
