package dat.daos;

import dat.entities.Activity;
import dat.entities.CityInfo;
import dat.entities.WeatherInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ActivityDAO implements IDAO<Activity> {

    EntityManagerFactory emf;

    public ActivityDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Activity create(Activity activity) {

        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(activity);
            em.getTransaction().commit();

            return activity;
        } catch (PersistenceException e){
            System.out.println("Failed to create Activity:" + e.getMessage());
            return null;
        }

        /*

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();

            // Query to check if an identical activity already exists (based on relevant attributes)
            TypedQuery<Activity> query = em.createQuery(
                    "SELECT a FROM Activity a WHERE a.activity = :activityType AND a.timeOfDate = :timeOfDate AND a.cityInfo = :cityInfo",
                    Activity.class
            );
            query.setParameter("activityType", activity.getActivity());
            query.setParameter("timeOfDate", activity.getTimeOfDate());
            query.setParameter("cityInfo", activity.getCityInfo());

            // If the query finds any matching activity, it means a duplicate exists
            List<Activity> existingActivities = query.getResultList();
            if (!existingActivities.isEmpty()) {
                System.out.println("An identical activity already exists.");
                return null;  // or throw an exception depending on business logic
            }

            // Proceed with persisting related entities (CityInfo, WeatherInfo) and the Activity
            CityInfo existingCityInfo = em.find(CityInfo.class, activity.getCityInfo().getId());
            if (existingCityInfo == null) {
                em.persist(activity.getCityInfo());
            } else {
                activity.setCityInfo(existingCityInfo);
            }

            WeatherInfo existingWeatherInfo = em.find(WeatherInfo.class, activity.getWeatherInfo().getId());
            if (existingWeatherInfo == null) {
                em.persist(activity.getWeatherInfo());
            } else {
                activity.setWeatherInfo(existingWeatherInfo);
            }

            // Persist the Activity entity
            em.persist(activity);
            em.getTransaction().commit();

            return activity; // Return the activity with the generated ID
        } catch (PersistenceException e) {
            System.out.println("Failed to create Activity: " + e.getMessage());
            return null;
        }

         */
    }


    @Override
    public Activity update(Activity activity) {
        try (EntityManager em = emf.createEntityManager()) {
            Activity activityFound = em.find(Activity.class, activity.getId());
            em.getTransaction().begin();

            if (activityFound.getActivity() != null) {
                activityFound.setActivity(activity.getActivity());
            }

            if (activityFound.getTimeOfDate() != null) {
                activityFound.setTimeOfDate(activityFound.getTimeOfDate());
            }

            if (activityFound.getDistance() != 0.0) {
                activityFound.setDistance(activity.getDistance());
            }

            if (activityFound.getDuration() != 0.0) {
                activityFound.setDuration(activity.getDuration());
            }

            if (activityFound.getCityInfo() != null) {
                activityFound.setCityInfo(activity.getCityInfo());
            }

            if (activityFound.getWeatherInfo() != null) {
                activityFound.setWeatherInfo(activity.getWeatherInfo());
            }
            em.getTransaction().commit();
            return activityFound;
        }
    }

    @Override
    public void delete(Activity activity) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(activity);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            System.out.println("Error while deleting activity");
        }

    }

    @Override
    public Activity getById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Activity.class, id);
        } catch (PersistenceException e) {
            System.out.println("Error while getting activity by id");
            return null;
        }
    }

    @Override
    public Set<Activity> getAll() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT a FROM Activity a", Activity.class).getResultStream().collect(Collectors.toSet());
        } catch (PersistenceException e) {
            System.out.println("Error while getting all activities");
            return null;
        }
    }
}
