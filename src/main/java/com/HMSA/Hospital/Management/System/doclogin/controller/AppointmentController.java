package com.HMSA.Hospital.Management.System.doclogin.controller;

import com.HMSA.Hospital.Management.System.doclogin.enity.Appointment;
import com.HMSA.Hospital.Management.System.doclogin.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



}
