package dat;

import dat.config.HibernateConfig;
import dat.daos.ActivityDAO;
import dat.dtos.ActivityDTO;
import dat.dtos.CityInfoDTO;
import dat.dtos.WeatherInfoDTO;
import dat.entities.Activity;
import dat.enums.ActivityType;
import dat.services.ActivityService;
import dat.services.CityService;
import dat.services.WeatherService;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //HibernateConfig.getEntityManagerFactory("activity_log");

        String weatherUri = "http://vejr.eu/api.php?location=Roskilde&degree=C";
        WeatherInfoDTO weather = WeatherService.getWeatherService(WeatherInfoDTO.class, weatherUri);
        //System.out.println(weather);

        String cityUri = "https://api.dataforsyningen.dk/kommuner/0265";
        CityInfoDTO city = CityService.getCityService(CityInfoDTO.class,cityUri);
        //System.out.println(city);

        ActivityDTO dto = ActivityDTO.builder()
                .activityType(ActivityType.WALKING)
                .timeOfDat(LocalDateTime.now())
                .duration(1.3)
                .distance(5.3)
                .location(city)
                .weatherInfo(weather)
                .build();

        //System.out.println(dto);

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory("activity_log");
        ActivityDAO activityDAO = new ActivityDAO(emf);
        ActivityService activityService = new ActivityService(activityDAO);

        //Activity ex = activityService.convertToEntity(dto);
        //activityDAO.create(ex);

        Set<Activity> list = activityDAO.getAll();

        for(Activity activity : list){
            System.out.println(activity);
        }



    }


}
