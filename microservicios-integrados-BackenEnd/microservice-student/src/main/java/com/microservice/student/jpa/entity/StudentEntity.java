package com.microservice.student.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "students")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "course_number")
    private Long courseNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attendant_id")
    private AttendantEntity attendant;
}
