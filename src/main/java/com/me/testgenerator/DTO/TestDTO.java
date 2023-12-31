package com.me.testgenerator.DTO;

import java.util.List;
import com.me.testgenerator.domain.Question;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDTO {
    private String name;
    private String description;
    private List<Question> questions;
}
