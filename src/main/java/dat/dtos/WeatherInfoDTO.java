package dat.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherInfoDTO {

    @JsonProperty("LocationName")
    private String locationName;

    @JsonProperty("CurrentData")
    private CurrentData currentData;

    @Override
    public String toString() {
        return String.format(
                "Weather Info:\n" +
                        " - Location: %s\n" +
                        " - Current Data: [%s]",
                locationName, currentData
        );
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CurrentData {
        @JsonSetter("temperature")
        private double temperature;

        @JsonSetter("skyText")
        private String condition;

        @JsonSetter("humidity")
        private String humidity;

        @JsonSetter("windText")
        private String windSpeed;

        @Override
        public String toString() {
            return String.format(
                    "Current Data:\n" +
                            " - Temperature: %.1f°C\n" +
                            " - Condition: %s\n" +
                            " - Humidity: %s\n" +
                            " - Wind Speed: %s",
                    temperature, condition, humidity, windSpeed
            );
        }
    }
}
