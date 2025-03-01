package com.HMSA.Hospital.Management.System.doclogin.repository;

import com.HMSA.Hospital.Management.System.doclogin.enity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment,Long> {
}
