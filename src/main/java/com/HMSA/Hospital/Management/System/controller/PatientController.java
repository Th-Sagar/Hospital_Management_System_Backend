package com.HMSA.Hospital.Management.System.controller;

import com.HMSA.Hospital.Management.System.entity.Patient;
import com.HMSA.Hospital.Management.System.repository.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    private PatientsRepository patientsRepository;

    @PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient){
        return patientsRepository.save(patient);

    }
}
