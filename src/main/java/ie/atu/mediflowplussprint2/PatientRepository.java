package ie.atu.mediflowplussprint2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmployeeId(String employeeId);

}
