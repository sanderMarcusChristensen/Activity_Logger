package dat.entities;

import dat.dtos.WeatherInfoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name", nullable = false)
    private String location;

    @Embedded
    private WeatherInfoDTO.CurrentData currentData; // Help fra chat

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CurrentData{

        @Column(name = "temperature", nullable = false)
        private double temperature;

        @Column(name = "condition")
        private String condition;

        @Column(name = "humidity")
        private String humidity;

        @Column(name = "wind_speed")
        private String windSpeed;
    }
}
