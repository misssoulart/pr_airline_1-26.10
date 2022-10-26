package ru.kataproject.p_sm_airlines_1.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;
import ru.kataproject.p_sm_airlines_1.repository.AircraftRepository;
import ru.kataproject.p_sm_airlines_1.service.AircraftService;
import ru.kataproject.p_sm_airlines_1.util.exceptions.AircraftNotFoundException;
import ru.kataproject.p_sm_airlines_1.util.mapper.AircraftMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис для работы с бизнеслогикой Aircraft
 */

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    private final AircraftRepository aircraftRepository;
    @Transactional
    @Override
    public List<AircraftDto> getAllAircrafts() {
        return aircraftRepository.findAll()
                .stream()
                .map(AircraftMapper::mapped)
                .collect(Collectors.toList());

    }

    @Override
    public Aircraft getAircraftById(Long id) {
        return aircraftRepository.findById(id)
                .orElseThrow(() -> new AircraftNotFoundException(id));

    }

    @Override
    @Transactional
    public void updateAircraft(Aircraft updatedAircraft) {
        Aircraft aircraft = getAircraftById(updatedAircraft.getId());

        aircraft.setOnBoardNumber(updatedAircraft.getOnBoardNumber());
        aircraft.setStamp(updatedAircraft.getStamp());
        aircraft.setStamp(updatedAircraft.getStamp());

        aircraft.setModel(updatedAircraft.getModel());
        aircraft.setYearOfRelease(updatedAircraft.getYearOfRelease());

        aircraft.setSeat(updatedAircraft.getSeat());
        aircraftRepository.save(aircraft);
    }

    @Override
    @Transactional
    public void saveAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    @Override
    public void delete(Aircraft aircraft) {
        aircraftRepository.delete(aircraft);
    }

}
