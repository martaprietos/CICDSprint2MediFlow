package ie.atu.mediflowplussprint2;

import org.springframework.stereotype.Service;

import java.security.cert.Extension;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository repo;
    public PatientService(PatientRepository repo) { this.repo = repo; }
    public Patient create(Patient p) { return repo.save(p); }
    public List<Patient> findAll() { return repo.findAll(); }
    public Patient findByEmployeeId(String id) {
        return repo.findByEmployeeId(id) //find by the provided id or return an error
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
    }

    public Patient delete(String id) {
        Patient patient = repo.findByEmployeeId(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));;
        repo.delete(patient);//delete person with corresponding id
        return patient;
    }

    public Patient update(String id, String email) {
        Patient patient = repo.findByEmployeeId(id).orElseThrow(() -> new IllegalArgumentException("Person not found"));;
        patient.setEmail(email);//use setter to change email
        repo.save(patient);//put person back into database
        return patient; //return patient information
    }
}
