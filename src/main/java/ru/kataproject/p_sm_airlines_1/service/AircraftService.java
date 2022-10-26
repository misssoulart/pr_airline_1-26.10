package ru.kataproject.p_sm_airlines_1.service;

import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;
import java.util.List;

public interface AircraftService {
    List<AircraftDto> getAllAircrafts();

    Aircraft getAircraftById(Long id);

    void updateAircraft(Aircraft updatedAircraft);

    void saveAircraft(Aircraft aircraft);

    void deleteAircraftById(Long id);

}
