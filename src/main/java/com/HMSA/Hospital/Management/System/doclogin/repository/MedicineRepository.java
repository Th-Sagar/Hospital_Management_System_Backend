package com.HMSA.Hospital.Management.System.doclogin.repository;

import com.HMSA.Hospital.Management.System.doclogin.enity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long> {
}
