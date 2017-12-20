package ch.sebooom.springdddspi.repository;

public class InMemoryDatasException extends RuntimeException {

    public InMemoryDatasException(String message) {
        System.out.println(message);
    }
}
