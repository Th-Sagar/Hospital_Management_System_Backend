package com.HMSA.Hospital.Management.System.repository;

import com.HMSA.Hospital.Management.System.entity.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends MongoRepository<Patient,Long> {
}
