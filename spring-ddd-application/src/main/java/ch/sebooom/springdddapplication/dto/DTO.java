package ch.sebooom.springdddapplication.dto;

public interface DTO<T> {

    T fromDTO(DTO dto);

    DTO toDTO(T type);
}
