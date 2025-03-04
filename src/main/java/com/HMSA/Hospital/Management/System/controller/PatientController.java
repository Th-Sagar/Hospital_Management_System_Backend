package com.HMSA.Hospital.Management.System.controller;

import com.HMSA.Hospital.Management.System.entity.Patient;
import com.HMSA.Hospital.Management.System.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    private PatientsRepository patientsRepository;

    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient){
        return patientsRepository.save(patient);
    }


    @GetMapping
    public List<Patient> getAllPatient(){
        return patientsRepository.findAll();
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
      Patient patient =  patientsRepository.findById(id).orElseThrow(()->
                new AttributeNotFoundException("Patient not found with id:"+ id));
      patientsRepository.delete(patient);

      Map<String,Boolean> response = new HashMap<String,Boolean>();
      response.put("Deleted",Boolean.TRUE);
      return new ResponseEntity<>(response, HttpStatus.OK);




    }


}
