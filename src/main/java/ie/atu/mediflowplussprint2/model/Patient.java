package ie.atu.mediflowplussprint2.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Patients")
@Getter
@Setter
@NoArgsConstructor
@Builder

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String name;
    private String email;
    private String DOB;

    public String getId() {
        return username;
    }

    public void setId(String id) {
        this.username = id;
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

    public String getDOB() {
        return DOB;
    }
    public void setDOB(String DOB1) {
        DOB = DOB1;
    }

    public Patient(String userN, String name, String email, String DOB) {
        this.username = userN;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
    }
}
