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

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    private final AircraftRepository aircraftRepository;

    @Override
    public List<AircraftDto> getAllAircrafts() {
        return aircraftRepository.findAll()
                .stream()
                .map(AircraftMapper::entityToDto)
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
    @Transactional
    public void deleteAircraftById(Long id) {
        aircraftRepository.delete(getAircraftById(id));
    }
}
