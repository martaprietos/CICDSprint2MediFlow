package ie.atu.mediflowplussprint2;

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
    public Patient byEmployeeId(@PathVariable String id) {
        return service.findByEmployeeId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestParam String email) {//use id to find person, take in new email value
        service.update(id, email);
    }
}