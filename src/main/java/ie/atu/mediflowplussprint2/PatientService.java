package ie.atu.mediflowplussprint2;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository repo;
    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }
    public Patient create(Patient p) { return repo.save(p); }
    public List<Patient> findAll() { return repo.findAll(); }
    public Patient findByPatientId(String id) {
        return repo.findByPatientId(id) //find by the provided id or return an error
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
    }

    public Patient delete(String id) {
        Patient patient = repo.findByPatientId(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        repo.delete(patient);//delete patient with corresponding id
        return patient;
    }

    public Optional<Patient> updateEmail(String id, String email) {
        Patient patient = repo.findByPatientId(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setEmail(email);//use setter to change email
        repo.save(patient);//put patient back into database
        return Optional.of(patient); //return patient information
    }

    public Optional<Patient> updateName(String id, String name) {
        Patient patient = repo.findByPatientId(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setName(name);//use setter to change name
        repo.save(patient);//put person back into database
        return Optional.of(patient); //return patient information
    }

    public Optional<Patient> updateDOB(String id, String DOB) {
        Patient patient = repo.findByPatientId(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setDOB(DOB);//use setter to change name
        repo.save(patient);//put person back into database
        return Optional.of(patient); //return patient information
    }
}
