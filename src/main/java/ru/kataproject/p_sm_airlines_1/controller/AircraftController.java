package ru.kataproject.p_sm_airlines_1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;

import java.util.List;

@Tag(name = "Aircrafts Controller", description = "Operations with aircrafts")
@RequestMapping(AircraftController.BASE_NAME)
public interface AircraftController {
    String MAJOR_VERSION = "/v1";
    String BASE_NAME = MAJOR_VERSION + "/aircrafts";

    /**
     * Метод возвращает список всех оздушных судов из БД. The method returns a list of all aircrafts from DB.
     */
    @GetMapping
    @Operation(summary = "Get list of all aircrafts")
    @ApiResponse(responseCode = "200", description = "Page successfully returned")
    ResponseEntity<List<AircraftDto>> getAllAircrafts();

    /**
     * Метод возвращает воздушное судно по Id. The method gets/returns a aircraft by Id.
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get aircrafts by id")
    @ApiResponse(responseCode = "200", description = "Page successfully returned")
    @ApiResponse(responseCode = "404", description = "Page not found")
    ResponseEntity<AircraftDto> getAircraftById(@PathVariable Long id);

    /**
     * Метод создаёт новый Data Transfer Object (DTO) aircraft. The method create aircraft.
     */
    @PostMapping
    @Operation(summary = "Create new aircraft")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "201", description = "Page successfully returned")
    @ApiResponse(responseCode = "405", description = "Method Not Allowed")
    ResponseEntity<AircraftDto> createAircraft(@RequestBody AircraftDto aircraftDto);

    /**
     * Метод редактирует информацию о воздушном судне. The method update aircraft information.
     */
    @PatchMapping
    @Operation(summary = "Update aircraft info")
    @ApiResponse(responseCode = "200", description = "Aircraft Information successfully updated")
    @ApiResponse(responseCode = "404", description = "Page not found")
    ResponseEntity<AircraftDto> updateAircraft(@RequestBody AircraftDto aircraftDto);


    /**
     * Метод удаляет воздушное судно из базы данных. The method removes the aircraft from the database.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete aircraft")
    @ApiResponse(responseCode = "204", description = "Aircraft successfully removed")
    @ApiResponse(responseCode = "404", description = "Page not found")
    ResponseEntity<Void> deleteAircraftById(@PathVariable Long id);

}
