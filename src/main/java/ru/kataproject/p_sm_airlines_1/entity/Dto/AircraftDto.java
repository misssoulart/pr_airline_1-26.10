package ru.kataproject.p_sm_airlines_1.entity.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) for communication with the Aircraft.
 * Describe here the fields that come from the aircraft to the server (and from the server to the aircraft).
 */

@Getter
@Setter
@Accessors(chain = true)
public class AircraftDto {

    @Id
    long id;

    @NotEmpty
    String PNR;

    @NotEmpty
    String stamp;

    @NotEmpty
    String model;

    @NotEmpty(message = "Year of release should not be empty")
    @Size(min = 4, max = 4, message = "Year of release must contain 4 characters")
    int yearOfRelease;

    @NotEmpty
    long seat;
}
