package com.me.testgenerator.domain;

import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "question_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_question", referencedColumnName = "id")
    @JsonIgnore 
    private Question question;

    @ManyToOne
    @JoinColumn(name = "id_option", referencedColumnName = "id")
    private Option option;
    
}
