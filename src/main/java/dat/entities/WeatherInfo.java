package dat.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location_name", nullable = false)
    private String location;

    @Column(name = "temperature", nullable = false)
    private double temperature;

    @Column(name = "condition")
    private String condition;

    @Column(name = "humidity")
    private String humidity;

    @Column(name = "wind_speed")
    private String windSpeed;
}
