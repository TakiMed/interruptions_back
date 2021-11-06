package com.example.predavanjademo.web.controllers;
import com.example.predavanjademo.exceptions.ValidationException;
import com.example.predavanjademo.validators.SubstationPostValidator;
import com.example.predavanjademo.entities.Substation;
import com.example.predavanjademo.services.SubstationService;
import com.example.predavanjademo.web.dto.SubstationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/substations", produces = MediaType.APPLICATION_JSON_VALUE)
// @PreAuthorize("@authComponent.hasPermissionWithArg(#key)")
public class SubstationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubstationController.class);

    @Autowired
    private SubstationService substationService;

    @Autowired
    private SubstationPostValidator substationPostValidator;

    @GetMapping()
    public ResponseEntity<List<SubstationDTO>> findAllSubstations(){
        List<SubstationDTO> substations = substationService.getAllSubstations();
        return substations!=null
                ? new ResponseEntity<>(substations, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubstationDTO> findSubstationById(@PathVariable(value = "id") Integer id){
        SubstationDTO substation = substationService.getSubstationById(id);
        return substation!=null
                ? new ResponseEntity<>(substation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<SubstationDTO>> searchBySubstationName(@RequestParam(value = "name") String nameTerm){
        List<SubstationDTO> substationDTOS = substationService.findByName(nameTerm);
        return substationDTOS!=null
                ? new ResponseEntity<>(substationDTOS, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/filter")
    public ResponseEntity<List<SubstationDTO>> filterByVoltageLevel(@RequestParam(value = "voltageTransformation") String HVLV){
        List<SubstationDTO> substationDTOS = substationService.filterByVoltage(HVLV);
        return substationDTOS!=null
                ? new ResponseEntity<>(substationDTOS, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Substation> createSubstation(@RequestBody Substation substation){
        if(substation.getId()!=null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Substation storedSubstation = substationService.create(substation);
        return storedSubstation!=null
                ? new ResponseEntity<>(storedSubstation, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/dto")
    public ResponseEntity<SubstationDTO> createSubstation(@RequestBody SubstationDTO substationDTO) throws ValidationException
    {
        // if(substationDTO.getId()!=null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Errors potencialErrors = new BeanPropertyBindingResult(substationDTO, "substationDTO"); // MapPropertyBindigResult
        // ValidationUtils.invokeValidator(substationPostValidator, substationDTO, potencialErrors);
       /*
        if(potencialErrors.hasErrors()){
            throw new ValidationException("Fields are not valid", potencialErrors);
        }
        */

        SubstationDTO storedSubstation = substationService.createWithDTO(substationDTO);
        return storedSubstation!=null
                ? new ResponseEntity<>(storedSubstation, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SubstationDTO> updateSubstation( @PathVariable(value = "id") Integer id,
                                                        @RequestBody SubstationDTO substationDTO )
    {
        if(substationDTO.getId()!=null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        SubstationDTO updatedSubstation = substationService.updateSubstation(id, substationDTO);
        return  updatedSubstation != null
                ? new ResponseEntity<>(updatedSubstation, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSubstation( @PathVariable(value = "id") Integer id )
    {
        if (id !=null) substationService.deleteSubstation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
