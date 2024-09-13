package dat.dtos;

import dat.enums.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ActivityDTO {

    private ActivityType activityType;
    private LocalDateTime timeOfDat;
    private double duration;
    private double distance;
    private CityInfoDTO location;
    private WeatherInfoDTO weatherInfo;

    @Override
    public String toString() {      // ToString fra Chat
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return String.format(
                "Activity: %s\nDate & Time: %s\nDuration: %.2f hours\nDistance: %.2f km\nLocation: %s\nWeather: %s",
                activityType,
                timeOfDat != null ? timeOfDat.format(formatter) : "N/A",
                duration,
                distance,
                location != null ? location : "N/A",
                weatherInfo != null ? weatherInfo : "N/A"
        );
    }
}
