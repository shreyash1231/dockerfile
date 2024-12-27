package com.backend.backend.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Document(collection = "prof")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class professor {
    @Id
    private Long prof_id;
    private String name;
    private String email;
    private String password;
}
