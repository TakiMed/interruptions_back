package com.example.predavanjademo.web.controllers;

import com.example.predavanjademo.entities.Interruption;
import com.example.predavanjademo.services.InterruptionService;
import com.example.predavanjademo.web.dto.CreateInterruptionDTO;
import com.example.predavanjademo.web.dto.InterruptionDTO;
import com.example.predavanjademo.web.dto.InterruptionRAEDTO;
import com.example.predavanjademo.web.dto.SubstationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/interruptions", produces = MediaType.APPLICATION_JSON_VALUE)
public class InterruptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterruptionController.class);
    @Autowired
    private InterruptionService interruptionService;

    // only for inspection purpose
    @GetMapping
    public ResponseEntity<List<Interruption>> findAll(){
        List<Interruption> interruptions = interruptionService.findAll();
        return interruptions!=null
                ? new ResponseEntity<>(interruptions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/dto")
    public ResponseEntity<List<InterruptionDTO>> findAllByDtos(){
        List<InterruptionDTO> interruptionDTOS = interruptionService.findByDTOs();
        return interruptionDTOS!=null
                ? new ResponseEntity<>(interruptionDTOS, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/dto/{id}")
    public ResponseEntity<InterruptionDTO> findByIdWithDTO(@PathVariable(value = "id") Integer id){
        InterruptionDTO interruptionDTO = interruptionService.findWithDTOById(id);
        return interruptionDTO!=null
                ? new ResponseEntity<>(interruptionDTO, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/by-voltage/{voltage}")
    public ResponseEntity<List<Interruption>> findByVoltageLevel(@RequestParam String voltageLevel){
        List<Interruption> interruptions = interruptionService.findByVoltageLevel(voltageLevel);
        return interruptions!=null
                ? new ResponseEntity<>(interruptions, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/dto")
    public ResponseEntity<InterruptionDTO> createWithDTO(@RequestBody CreateInterruptionDTO interruptionDTO){

        InterruptionDTO interruption = interruptionService.createWithDTO(interruptionDTO);

        return interruption!=null
                ? new ResponseEntity<>(interruption, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping(value = "/rae")
    public ResponseEntity<Map<Integer, List<InterruptionRAEDTO>>> getRAEReport(){
        Map<Integer, List<InterruptionRAEDTO>> RAEList = interruptionService.getRAEInterruptionList();
        return RAEList!=null
                ? new ResponseEntity<>(RAEList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id){
        interruptionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
