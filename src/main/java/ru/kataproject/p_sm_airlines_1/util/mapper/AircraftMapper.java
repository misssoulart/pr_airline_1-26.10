package ru.kataproject.p_sm_airlines_1.util.mapper;

import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;

public class AircraftMapper {
    public static Aircraft dtoToEntity(AircraftDto aircraftDto) {
        return new Aircraft()
                .setId(aircraftDto.getId())
                .setPNR(aircraftDto.getPNR())
                .setStamp(aircraftDto.getStamp())
                .setModel(aircraftDto.getModel())
                .setYearOfRelease(aircraftDto.getYearOfRelease())
                .setSeat(aircraftDto.getSeat());
    }

    public static AircraftDto entityToDto(Aircraft aircraft) {
        return new AircraftDto()
                .setId(aircraft.getId())
                .setPNR(aircraft.getPNR())
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
 */