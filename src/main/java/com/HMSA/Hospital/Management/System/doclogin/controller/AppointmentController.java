package com.HMSA.Hospital.Management.System.doclogin.controller;

import com.HMSA.Hospital.Management.System.doclogin.enity.Appointment;
import com.HMSA.Hospital.Management.System.doclogin.repository.AppointmentsRepository;
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
@RequestMapping("/api/v2")
public class AppointmentController {

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentsRepository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentsRepository.findAll();
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {

       Appointment appointment= appointmentsRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Appointment Not Found With ID"));
       appointmentsRepository.delete(appointment);

       Map<String,Boolean> response = new HashMap<String,Boolean>();
       response.put("Deleted",Boolean.TRUE);
       return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
