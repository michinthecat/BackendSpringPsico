package com.unibague.backpsyco.patient.infraestructure.driveradapter;

import com.unibague.backpsyco.gender.infraestructure.driveradapter.GenderData;
import com.unibague.backpsyco.patienttype.infraestructure.driveradapter.PatientTypeData;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "patients")
@Data
public class PatientData {

    @Id
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "phone", nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(name = "patient_typeid", nullable = false)
    private PatientTypeData patientType;

    @ManyToOne
    @JoinColumn(name = "genderid", nullable = false)
    private GenderData gender;

    @Column(name = "notes", columnDefinition="TEXT")
    private String notes;

}