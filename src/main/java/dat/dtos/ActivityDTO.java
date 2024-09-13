package dat.dtos;

import dat.enums.Activity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ActivityDTO {

    private Activity activityType;
    private LocalDateTime date;
    private CityInfoDTO location;
    private WeatherInfoDTO weatherInfo;

    @Override
    public String toString() {
        return String.format(
                "Activity Details:\n" +
                        " - Type: %s\n" +
                        " - Date: %s\n" +
                        " - Location: %s\n" +
                        " - Weather Info: %s",
                activityType, date, location, weatherInfo
        );
    }
}
