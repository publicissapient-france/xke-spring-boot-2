package fr.xebia.hotels.weatherservice.controller;

import fr.xebia.hotels.weatherservice.model.CityWeather;
import fr.xebia.hotels.weatherservice.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private static final String WEATHER_REQUEST_FORMAT = "http://api.openweathermap.org/data/2.5/weather?q=%s,%s&APPID=%s";
    private static final String HOTEL_REQUEST_FORMAT = "http://data-access-service/hotels/%s";

    @Autowired
    private RestTemplate loadBalancedRestTemplate;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${weather-id}")
    private String appId;

    @GetMapping
    public Mono<CityWeather> getWeather(@RequestParam String hotelId) {
        return Mono.just(loadBalancedRestTemplate.getForObject(String.format(HOTEL_REQUEST_FORMAT, hotelId), Hotel.class))
                .map(hotel -> new RestTemplate().getForObject(
                        String.format(WEATHER_REQUEST_FORMAT, hotel.getCity(), hotel.getCountry(), appId),
                        CityWeather.class)
                );
    }
}
