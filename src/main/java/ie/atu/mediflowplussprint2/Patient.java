package ie.atu.mediflowplussprint2;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String patientId;
    private String DOB;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDOB() {
        return DOB;
    }
    public void setDOB(String DOB1) {
        DOB = DOB1;
    }

    public Patient( String name, String email, String patientId) {
        this.name = name;
        this.email = email;
        this.patientId = patientId;
    }
}
