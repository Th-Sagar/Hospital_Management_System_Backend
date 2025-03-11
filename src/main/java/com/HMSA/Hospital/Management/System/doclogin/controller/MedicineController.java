package com.HMSA.Hospital.Management.System.doclogin.controller;


import com.HMSA.Hospital.Management.System.doclogin.enity.Medicine;
import com.HMSA.Hospital.Management.System.doclogin.repository.MedicineRepository;
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

    @GetMapping("/medicines/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable String id) throws AttributeNotFoundException {
     Medicine medicine=   medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found of this id: "+ id));
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    @PutMapping("/medicines/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable String id, @RequestBody Medicine medicineDetail) throws AttributeNotFoundException {
        Medicine medicine=   medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found of this id: "+ id));
        medicine.setDrugName(medicineDetail.getDrugName());
        medicine.setStock(medicineDetail.getStock());

        medicineRepository.save(medicine);
        return new ResponseEntity<>(medicine,HttpStatus.OK);

    }

    @DeleteMapping("/medicines/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteMedicine(@PathVariable String id) throws AttributeNotFoundException {
        Medicine medicine=   medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found of this id: "+ id));
        medicineRepository.delete(medicine);
        Map<String,Boolean> response = new HashMap<String,Boolean>();
        response.put("Deleted",true);
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
}
