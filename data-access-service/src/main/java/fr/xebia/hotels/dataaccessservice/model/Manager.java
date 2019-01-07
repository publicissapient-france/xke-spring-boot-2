package fr.xebia.hotels.dataaccessservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Manager {
    @Id
    private String id;
    @NotBlank
    private String name;
    @Positive
    private int age;
    @NotEmpty
    private String description;
}
