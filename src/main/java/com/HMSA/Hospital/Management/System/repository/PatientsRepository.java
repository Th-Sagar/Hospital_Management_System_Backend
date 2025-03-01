package com.HMSA.Hospital.Management.System.repository;

import com.HMSA.Hospital.Management.System.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientsRepository extends JpaRepository<Patient,Long> {
}
