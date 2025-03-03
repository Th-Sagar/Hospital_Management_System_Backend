package com.HMSA.Hospital.Management.System.controller;

import com.HMSA.Hospital.Management.System.entity.Patient;
import com.HMSA.Hospital.Management.System.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


}
