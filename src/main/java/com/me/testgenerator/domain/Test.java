package com.me.testgenerator.domain;

import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore 
    private List<AssignedTest> assignedTests;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "test_questions",
        joinColumns = @JoinColumn(name = "id_test"),
        inverseJoinColumns = @JoinColumn(name = "id_question")
    )
    private Set<Question> questions = new HashSet<>();
}

