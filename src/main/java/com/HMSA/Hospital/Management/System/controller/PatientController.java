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

@CrossOrigin(origins = {"http://localhost:4200", "https://angular-spring-hms.netlify.app"}, allowedHeaders = "*", allowCredentials = "true")
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
    public ResponseEntity<Map<String,Boolean>> deletePatient(@PathVariable String id) throws AttributeNotFoundException {
      Patient patient =  patientsRepository.findById(id).orElseThrow(()->
                new AttributeNotFoundException("Patient not found with id:"+ id));
      patientsRepository.delete(patient);

      Map<String,Boolean> response = new HashMap<String,Boolean>();
      response.put("Deleted",Boolean.TRUE);
      return new ResponseEntity<>(response, HttpStatus.OK);

    }
    
    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatientById(@PathVariable String id, @RequestBody Patient patientDetail) throws AttributeNotFoundException {
        Patient patient =  patientsRepository.findById(id).orElseThrow(()->
                new AttributeNotFoundException("Patient not found with id:"+ id));

        patient.setAge(patientDetail.getAge());
        patient.setDose(patientDetail.getDose());
        patient.setBlood(patientDetail.getBlood());
        patient.setFees(patientDetail.getFees());
        patient.setName(patientDetail.getName());
        patient.setPrescription(patientDetail.getPrescription());
        patient.setUrgency(patientDetail.getUrgency());
        Patient savedPatient = patientsRepository.save(patient);
        return new ResponseEntity<>(savedPatient,HttpStatus.OK);

    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) throws AttributeNotFoundException {

       Patient patient= patientsRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Patient not found with id "+id));
       return new ResponseEntity<>(patient,HttpStatus.OK);

    }
}
