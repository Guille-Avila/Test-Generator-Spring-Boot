package com.me.testgenerator.domain;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "assigned_test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignedTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "score")
    private float score;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_test", referencedColumnName = "id")
    private Test test;
}
