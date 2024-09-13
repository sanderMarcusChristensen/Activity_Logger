package dat.entities;

import dat.dtos.CityInfoDTO;
import dat.enums.ActivityType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "activities")

public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type", nullable = false)
    private ActivityType activity;

    @Column(name = "time_of_date", nullable = false)
    private LocalDateTime timeOfDate;

    @Column(name = "duration", nullable = false)
    private double duration;

    @Column(name = "distance", nullable = false)
    private double distance;

    @OneToOne(cascade = CascadeType.ALL)        //help from Chat
    @JoinColumn(name = "city_info_id", referencedColumnName = "id")
    private CityInfo cityInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_info_id", referencedColumnName = "id")
    private WeatherInfo weatherInfo;





}
