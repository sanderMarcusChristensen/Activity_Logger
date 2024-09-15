package dat.services;

import dat.daos.ActivityDAO;
import dat.dtos.ActivityDTO;
import dat.dtos.CityInfoDTO;
import dat.dtos.WeatherInfoDTO;
import dat.entities.Activity;
import dat.entities.CityInfo;
import dat.entities.WeatherInfo;


public class ActivityService {

    private final ActivityDAO activityDAO;

    public ActivityService(ActivityDAO activityDAO) {
        this.activityDAO = activityDAO;
    }

    public Activity convertToEntity(ActivityDTO dto) {

           return Activity.builder()
                .activity(dto.getActivityType())
                .timeOfDate(dto.getTimeOfDat())
                .distance(dto.getDistance())
                .duration(dto.getDuration())
                .cityInfo(convertCityInfoDTOToEntity(dto.getLocation()))
                .weatherInfo(convertWeatherInfoDTOToEntity(dto.getWeatherInfo()))
                .build();


    }

    // Convert CityInfoDTO to Entity
    public CityInfo convertCityInfoDTOToEntity(CityInfoDTO dto) {
        if (dto == null) return null;
        return CityInfo.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .build();
    }

    private WeatherInfo convertWeatherInfoDTOToEntity(WeatherInfoDTO dto) {
        if (dto == null) return null;
        return WeatherInfo.builder()
                .location(dto.getLocationName())
                .temperature(dto.getCurrentData().getTemperature())
                .condition(dto.getCurrentData().getCondition())
                .humidity(dto.getCurrentData().getHumidity())
                .windSpeed(dto.getCurrentData().getWindSpeed())
                .build();
    }

}