package com.HMSA.Hospital.Management.System.doclogin.repository;

import com.HMSA.Hospital.Management.System.doclogin.enity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentsRepository extends MongoRepository<Appointment,Long> {
}
