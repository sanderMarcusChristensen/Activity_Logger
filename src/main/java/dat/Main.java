package dat;

import dat.config.HibernateConfig;
import dat.dtos.ActivityDTO;
import dat.dtos.CityInfoDTO;
import dat.dtos.WeatherInfoDTO;
import dat.enums.Activity;
import dat.services.CityService;
import dat.services.WeatherService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

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
                .activityType(Activity.WALKING)
                .date(LocalDateTime.now())
                .location(city)
                .weatherInfo(weather)
                .build();

        System.out.println(activity);




    }


}
