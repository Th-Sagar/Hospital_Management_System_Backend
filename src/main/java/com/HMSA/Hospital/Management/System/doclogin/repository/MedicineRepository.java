package com.HMSA.Hospital.Management.System.doclogin.repository;

import com.HMSA.Hospital.Management.System.doclogin.enity.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine,Long> {
}
