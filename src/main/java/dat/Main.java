package dat;

import dat.dtos.ActivityDTO;
import dat.dtos.CityInfoDTO;
import dat.dtos.WeatherInfoDTO;
import dat.enums.ActivityType;
import dat.services.CityService;
import dat.services.WeatherService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        String weatherUri = "http://vejr.eu/api.php?location=Roskilde&degree=C";
        WeatherInfoDTO weather = WeatherService.getWeatherService(WeatherInfoDTO.class, weatherUri);
        //System.out.println(weather);

        String cityUri = "https://api.dataforsyningen.dk/kommuner/0265";
        CityInfoDTO city = CityService.getCityService(CityInfoDTO.class,cityUri);
        //System.out.println(city);

        ActivityDTO activity = ActivityDTO.builder()
                .activityType(ActivityType.WALKING)
                .timeOfDat(LocalDateTime.now())
                .duration(1.3)
                .distance(5.3)
                .location(city)
                .weatherInfo(weather)
                .build();

        System.out.println(activity);




    }


}
