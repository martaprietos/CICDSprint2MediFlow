package ie.atu.mediflowplussprint2.service;

import ie.atu.mediflowplussprint2.Patient;
import ie.atu.mediflowplussprint2.PatientRepository;
import ie.atu.mediflowplussprint2.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatientServiceTest {

    private PatientRepository repo;
    private PatientService service;

    @BeforeEach
    void setup() {
        repo = mock(PatientRepository.class); //setup mock to prevent accessing the real databse
        service = new PatientService(repo); // inject the mocked repo into service
    }

    @Test
    void createThenFindById() {
        Patient p = new Patient("P1", "Paul", "paul@atu.ie", "02-02-2000");
        when(repo.save(p)).thenReturn(p); //when save called, return patient
        when(repo.findByPatientId("P1")).thenReturn(Optional.of(p));//mock that when id is found, return patient information
        service.create(p);
        //test that patient info is actually returned
        Patient found = service.findByPatientId("P1");
        assertEquals("Paul", found.getName());
    }

    @Test
    void findByIdFail() {
        when(repo.findByPatientId("P1")).thenReturn(Optional.empty());//pretend to return empty when this is called
        assertThrows(IllegalArgumentException.class, //if empty then throw error when findBy is called
                () -> service.findByPatientId("P1"));//generate arg exc
    }

    @Test
    void deleteSuccess() {
        Patient p = new Patient("P1", "Bob", "bob@atu.ie", "02-20-2000");
        when(repo.findByPatientId("P1")).thenReturn(Optional.of(p));
        Patient deleted = service.delete("P1");
        verify(repo).delete(p);//make sure delete was called
        assertEquals("P1", deleted.getPatientId());
    }

    @Test
    void deleteFail() {
        when(repo.findByPatientId("P1")).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class,
                () -> service.delete("P1"));
    }

    @Test
    void updateEmailSuccess() {
        Patient p = new Patient("P1", "Bob", "bob@atu.ie", "02-02-2000");
        //mock finding and saving
        when(repo.findByPatientId("P1")).thenReturn(Optional.of(p));
        when(repo.save(p)).thenReturn(p);//store then return
        Optional<Patient> updatedOpt = service.updateEmail("P1", "new@atu.ie");
        assertTrue(updatedOpt.isPresent());
        assertEquals("new@atu.ie", updatedOpt.get().getEmail());
    }

    @Test
    void updateEmailFail() {
        when(repo.findByPatientId("P1")).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class,
                () -> service.updateEmail("P1", "new@atu.ie"));
    }

    @Test
    void updateNameSuccess() {
        Patient p = new Patient("P1", "Mike", "mike@atu.ie", "02-02-2000");
        when(repo.findByPatientId("P1")).thenReturn(Optional.of(p));
        when(repo.save(p)).thenReturn(p);
        Optional<Patient> updated = service.updateName("P1", "NewName");
        assertTrue(updated.isPresent());
        assertEquals("NewName", updated.get().getName());
    }

    @Test
    void updateDOBSuccess() {
        Patient p = new Patient("P1", "Mike", "mike@atu.ie", "20-20-2000");
        when(repo.findByPatientId("P1")).thenReturn(Optional.of(p));
        when(repo.save(p)).thenReturn(p);
        Optional<Patient> updated = service.updateDOB("P1", "20-02-1999");
        assertTrue(updated.isPresent());
        assertEquals("20-02-1999", updated.get().getDOB());
    }
}
