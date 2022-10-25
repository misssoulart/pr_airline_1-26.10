package ru.kataproject.p_sm_airlines_1.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.kataproject.p_sm_airlines_1.controller.AircraftController;
import ru.kataproject.p_sm_airlines_1.entity.Dto.AircraftDto;
import ru.kataproject.p_sm_airlines_1.entity.Aircraft;
import ru.kataproject.p_sm_airlines_1.service.AircraftService;
import ru.kataproject.p_sm_airlines_1.util.mapper.AircraftMapper;

import java.util.List;

/**
 * Контроллер для обработки запросов по добавлению, изминению и получению данных воздушного судна
*/

@RestController
public class AircraftControllerImpl implements AircraftController {
    private final AircraftService aircraftService;

    public AircraftControllerImpl(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @Override
    public ResponseEntity<List<AircraftDto>> getAllAircrafts() {
        return new ResponseEntity<>(aircraftService.getAllAircrafts(), HttpStatus.OK);
    }

    /**
     * Получение данных по ID
     * @return ResponseEntity<AircraftDTO>
     */

    @Override
    public ResponseEntity<AircraftDto> getAircraftById(Long id) {
        AircraftDto aircraft = AircraftMapper.entityToDto(aircraftService.getAircraftById(id));
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }

    /**
     * Создание воздушного судна
     * @return ResponseEntity<AircraftDTO>
     */

    @Override
    public ResponseEntity<AircraftDto> createAircraft(AircraftDto aircraftDto) {
        aircraftService.saveAircraft(AircraftMapper.dtoToEntity(aircraftDto));
        return new ResponseEntity<>(aircraftDto, HttpStatus.OK);
    }

    /**
     * Обновление данных по воздушному судну
     * @return ResponseEntity<AircraftDTO>
     */

    @Override
    public ResponseEntity<AircraftDto> updateAircraft(AircraftDto aircraftDto) {
        aircraftService.updateAircraft(AircraftMapper.dtoToEntity(aircraftDto));
        return new ResponseEntity<>(aircraftDto, HttpStatus.OK);
    }

    /**
     * Удаление данных о воздушном судне по ID
     * @return ResponseEntity<AircraftDTO>
     */

    @Override
    public ResponseEntity<Void> deleteAircraftById(Long id) {
        Aircraft aircraft = aircraftService.getAircraftById(id);
        aircraftService.deleteAircraftById(aircraft.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
