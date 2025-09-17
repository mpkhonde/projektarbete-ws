package se.projektarbete.projektarbetews.exception;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 T.ex kund inte hittas i databasen.
 * Fångas upp av {@link GlobalExceptionHandler} och returnerar 404.
 */
@Schema(description = "Undantag som kastas när en resurs inte hittas")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
