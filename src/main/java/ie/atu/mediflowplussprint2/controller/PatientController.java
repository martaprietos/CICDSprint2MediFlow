package ie.atu.mediflowplussprint2.controller;

import ie.atu.mediflowplussprint2.Patient;
import ie.atu.mediflowplussprint2.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Patients")
public class PatientController {
    private final PatientService service;
    public PatientController(PatientService service) { this.service = service; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient create(@Valid @RequestBody Patient person) {
        return service.create(person);
    }

    @GetMapping
    public List<Patient> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Patient byPatientId(@PathVariable String id) {
        return service.findByPatientId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void updateEmail(@PathVariable String id, @RequestParam String email) {//use id to find person, take in new email value
        service.updateEmail(id, email);
    }

    @PutMapping("/name/{id}")
    public void updateName(@PathVariable String id, @RequestParam String name) {//use id to find person, take in new name value
        service.updateName(id, name);//call update name function to change the name
    }

    @PutMapping("/DOB/{id}")
    public void updateDOB(@PathVariable String id, @RequestParam String DOB) {//use id to find person, take in new DOB value
        service.updateDOB(id, DOB);//call update name function to change the DOB
    }
}