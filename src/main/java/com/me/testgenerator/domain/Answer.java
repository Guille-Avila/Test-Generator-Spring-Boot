package com.me.testgenerator.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "id_question", referencedColumnName = "id")
    private Question question;
    
}
