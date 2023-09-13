package com.me.testgenerator.domain;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "option")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {

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
