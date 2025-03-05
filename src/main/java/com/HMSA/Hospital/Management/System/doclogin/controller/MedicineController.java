package com.HMSA.Hospital.Management.System.doclogin.controller;


import com.HMSA.Hospital.Management.System.doclogin.enity.Medicine;
import com.HMSA.Hospital.Management.System.doclogin.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine){
        return medicineRepository.save(medicine);
    }

    @GetMapping
    public List<Medicine> findAllMedicine(){
        return medicineRepository.findAll();
    }
}
