package ie.atu.mediflowplussprint2.controller;

import ie.atu.mediflowplussprint2.model.Patient;
import ie.atu.mediflowplussprint2.service.PatientService;
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

    @GetMapping("/{user}")
    public Patient byUsername(@PathVariable String user) {
        return service.findByUsername(user);
    }

    @DeleteMapping("/{user}")
    public void delete(@PathVariable String user) {
        service.delete(user);
    }

    @PutMapping("/{user}")
    public void updateEmail(@PathVariable String user, @RequestParam String email) {//use id to find person, take in new email value
        service.updateEmail(user, email);
    }

    @PutMapping("/name/{user}")
    public void updateName(@PathVariable String user, @RequestParam String name) {//use id to find person, take in new name value
        service.updateName(user, name);//call update name function to change the name
    }

    @PutMapping("/DOB/{user}")
    public void updateDOB(@PathVariable String user, @RequestParam String DOB) {//use id to find person, take in new DOB value
        service.updateDOB(user, DOB);//call update name function to change the DOB
    }
}