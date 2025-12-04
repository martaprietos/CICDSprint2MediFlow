package ie.atu.mediflowplussprint2.service;

import ie.atu.mediflowplussprint2.repository.PatientRepository;
import ie.atu.mediflowplussprint2.model.Patient;
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

    public Patient findByUsername(String user) {
        return repo.findByUsername(user) //find by the provided id or return an error
                .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
    }

    public Patient delete(String user) {
        Patient patient = repo.findByUsername(user).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        repo.delete(patient);//delete patient with corresponding id
        return patient;
    }

    public Optional<Patient> updateEmail(String user, String email) {
        Patient patient = repo.findByUsername(user).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setEmail(email);//use setter to change email
        repo.save(patient);//put patient back into database
        return Optional.of(patient); //return patient information
    }

    public Optional<Patient> updateName(String user, String name) {
        Patient patient = repo.findByUsername(user).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setName(name);//use setter to change name
        repo.save(patient);//put person back into database
        return Optional.of(patient); //return patient information
    }

    public Optional<Patient> updateDOB(String user, String DOB) {
        Patient patient = repo.findByUsername(user).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setDOB(DOB);//use setter to change name
        repo.save(patient);//put person back into database
        return Optional.of(patient); //return patient information
    }

    public Optional<Patient> updateGender(String user, String gender) {
        Patient patient = repo.findByUsername(user).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setGender(gender);//use setter to change name
        repo.save(patient);//put person back into database
        return Optional.of(patient); //return patient information
    }

    public Optional<Patient> updateAddress(String user, String address) {
        Patient patient = repo.findByUsername(user).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setAddress(address);//use setter to change name
        repo.save(patient);//put person back into database
        return Optional.of(patient); //return patient information
    }

    public Optional<Patient> updatePhone(String user, String phone) {
        Patient patient = repo.findByUsername(user).orElseThrow(() -> new IllegalArgumentException("Patient not found"));;
        patient.setPhone(phone);//use setter to change name
        repo.save(patient);//put person back into database
        return Optional.of(patient); //return patient information
    }
}
