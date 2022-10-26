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
 * Контроллер для обработки запросов по добавлению, изминению и получению данных о воздушном судне
 */

@RestController
public class AircraftControllerImpl implements AircraftController {
    private final AircraftService aircraftService;

    public AircraftControllerImpl(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }
    /**
     * Вывод всех Aircraft
     */
    @Override
    public ResponseEntity<List<AircraftDto>> getAllAircrafts() {
        return new ResponseEntity<>(aircraftService.getAllAircrafts(), HttpStatus.OK);
    }
    /**
    * Получение Aircraft по ID
    */

    @Override
    public ResponseEntity<AircraftDto> getAircraftById(Long id) {
        AircraftDto aircraft = AircraftMapper.mapped(aircraftService.getAircraftById(id));
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }

    /**
     * Создание Aircraft
     */
    @Override
    public ResponseEntity<AircraftDto> createAircraft(AircraftDto aircraft) {
        aircraftService.saveAircraft(AircraftMapper.mapped(aircraft));
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }

    /**
     * Обновление данных Aircraft
     */
    @Override
    public ResponseEntity<AircraftDto> updateAircraft(AircraftDto aircraft) {
        aircraftService.updateAircraft(AircraftMapper.mapped(aircraft));
        return new ResponseEntity<>(aircraft, HttpStatus.OK);
    }
    /**
     * Удаление данных Aircraft
     */
    @Override
    public ResponseEntity<AircraftDto> deleteAircraftById(Long id) {
        Aircraft aircraft = aircraftService.getAircraftById(id);
        aircraftService.delete(aircraft);
        return new ResponseEntity<>(AircraftMapper.mapped(aircraft), HttpStatus.OK);
    }
}
