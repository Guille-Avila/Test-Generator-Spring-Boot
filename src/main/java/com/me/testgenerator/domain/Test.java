package com.me.testgenerator.domain;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {

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

    @ManyToMany(mappedBy = "tests")
    private Set<Question> questions = new HashSet<>();
}

