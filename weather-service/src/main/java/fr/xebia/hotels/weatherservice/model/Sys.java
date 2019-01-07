package fr.xebia.hotels.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sys {
    private String message;
    private String id;
    private String sunset;
    private String sunrise;
    private String type;
    private String country;
}
