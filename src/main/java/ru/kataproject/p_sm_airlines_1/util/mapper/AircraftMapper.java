package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;

public class AircraftMapper {
    public static Aircraft dtoToEntity(AircraftDto aircraftDto) {
        return new Aircraft()
                .setId(aircraftDto.getId())
                .setOnBoardNumber(aircraftDto.getOnBoardNumber())
                .setStamp(aircraftDto.getStamp())
                .setModel(aircraftDto.getModel())
                .setYearOfRelease(aircraftDto.getYearOfRelease())
                .setSeat(aircraftDto.getSeat());
    }

    public static AircraftDto entityToDto(Aircraft aircraft) {
        return new AircraftDto()
                .setId(aircraft.getId())
                .setOnBoardNumber(aircraft.getOnBoardNumber())
                .setStamp(aircraft.getStamp())
                .setModel(aircraft.getModel())
                .setYearOfRelease(aircraft.getYearOfRelease())
                .setSeat(aircraft.getSeat());
    }
}
/*
@Id
    long id;

    @NotEmpty
    String onBoardNumber;

    @NotEmpty
    String stamp;

    @NotEmpty
    String model;

    @NotEmpty(message = "Year of release should not be empty")
    @Size(min = 4, max = 4, message = "Year of release must contain 4 characters")
    int yearOfRelease;

    @NotEmpty
    long seat;
 */