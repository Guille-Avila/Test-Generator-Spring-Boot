package com.me.testgenerator.DTO;

import java.util.List;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO {
    private String text;
    private List<Long> options;
    private List<Long> answers;
}