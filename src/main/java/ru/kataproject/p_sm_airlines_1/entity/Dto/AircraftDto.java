package ru.kataproject.p_sm_airlines_1.entity.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object (DTO) for communication with the Aircraft.
 * Describe here the fields that come from the aircraft to the server (and from the server to the aircraft).
 * @Schema - description for front developers (swagger)
 */

@Getter
@Setter
@Accessors(chain = true)
public class AircraftDto {

    @Id
    @Schema(description = "Идентификатор оздушного судна.")
    Long id;

    @Schema(description = "Обязательное поле")
    @NotEmpty(message = "On board number should not be empty")
    String onBoardNumber;

    @Schema(description = "Обязательное поле")
    @NotEmpty
    String stamp;

    @Schema(description = "Обязательное поле")
    @NotEmpty
    String model;

    @Schema(description = "Обязательное поле")
    @NotEmpty(message = "Year of release should not be empty")
    @Size(min = 4, max = 4, message = "Year of release must contain 4 characters")
    int yearOfRelease;

    @NotEmpty
    long seat;
}
