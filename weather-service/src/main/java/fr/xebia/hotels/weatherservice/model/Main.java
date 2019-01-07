package fr.xebia.hotels.weatherservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Main {
    private String humidity;
    private String pressure;
    private String temp_max;
    private String temp_min;
    private String temp;
}
