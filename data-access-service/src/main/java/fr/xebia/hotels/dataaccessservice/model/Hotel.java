package fr.xebia.hotels.dataaccessservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    private String id;
    @Size(min = 2, max = 30)
    private String name;
    @NotBlank
    private String city;
    @Size(min = 2, max = 3)
    private String countryCode;
    @NotBlank
    private String description;
    private Manager manager;
}