package com.backend.backend.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Document(collection = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class student {
    @Id
    private Long student_id;
    private String name;
    private String email;
    private String password;
}
