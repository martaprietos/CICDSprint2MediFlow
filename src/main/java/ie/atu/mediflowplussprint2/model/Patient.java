package ie.atu.mediflowplussprint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(max = 40, min = 3)
    private String username;
    @NotBlank
    @Size(max = 40, min = 3)
    private String name;
    @NotBlank
    @Size(max = 40, min = 3)
    @Email
    private String email;
    @NotBlank
    @Size(max = 40, min = 3)
    private String DOB;
    @NotBlank
    @Size(max = 40, min = 3)
    private String gender;
    @NotBlank
    @Size(max = 6, min = 4)
    private String address;
    @NotBlank
    @Size(max = 40, min = 3)
    private String phone;
    @NotBlank
    @Size(max = 40, min = 5)
    private String doctor;

    public String getUsername() {
        return username;
    }

    public void setUsername(String id) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Patient(String userN, String name, String email, String DOB, String gender, String address, String phone, String doctor) {
        this.username = userN;
        this.name = name;
        this.email = email;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.doctor = doctor;
    }
}
