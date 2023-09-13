package com.me.testgenerator.DTO;

import java.util.Set;
import com.me.testgenerator.domain.Question;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {
    private Long id;
    private String name;
    private String description;
    private Set<Question> questions;
}
