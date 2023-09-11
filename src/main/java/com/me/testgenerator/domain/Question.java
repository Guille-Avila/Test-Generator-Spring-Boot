package com.me.testgenerator.domain;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String name;

    @ManyToMany
    @JoinTable(
        name = "test_questions",
        joinColumns = @JoinColumn(name = "id_question"),
        inverseJoinColumns = @JoinColumn(name = "id_test")
    )
    private Set<Test> tests = new HashSet<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;
    
}
