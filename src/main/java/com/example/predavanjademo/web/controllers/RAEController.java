package com.example.predavanjademo.web.controllers;


import com.example.predavanjademo.services.InterruptionService;
import com.example.predavanjademo.web.dto.InterruptionRAEDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/rae", produces = MediaType.APPLICATION_JSON_VALUE)
public class RAEController {

    @Autowired
    private InterruptionService interruptionService;

    @GetMapping()
    public ResponseEntity<Map<Integer, List<InterruptionRAEDTO>>> getReport(){
        Map<Integer, List<InterruptionRAEDTO>> RAEList = interruptionService.getRAEInterruptionMap();
        return RAEList!=null
                ? new ResponseEntity<>(RAEList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<InterruptionRAEDTO>> getReportList(){
        List<InterruptionRAEDTO> RAEList = interruptionService.getRAEList();
        return RAEList!=null
                ? new ResponseEntity<>(RAEList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
