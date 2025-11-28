package ie.atu.mediflowplussprint2.repository;

import ie.atu.mediflowplussprint2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByUsername(String user);

}
