package com.example.spring_boot_practice.dto;

/**
 * Represents a standardized error response returned by the API.
 * <p>
 * Contains HTTP status information and an error message
 * describing what went wrong during request processing.
 */
public class ErrorResponse {

    /**
     * HTTP status code associated with the error.
     */
    private int status;

    /**
     * Human-readable error message.
     */
    private String message;

    /**
     * Constructs an ErrorResponse with status and message.
     *
     * @param status  the HTTP status code
     * @param message the error message
     */
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Default constructor required for serialization/deserialization.
     */
    public ErrorResponse() {
    }

    /**
     * Returns the HTTP status code.
     *
     * @return the status code
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code.
     *
     * @param status the status code to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Returns the error message.
     *
     * @return the error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the error message.
     *
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}