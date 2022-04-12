package dbaccess;

import apiaccess.interceptors.ProfileInterceptorEJB;
import model.entities.Forecast;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

@Stateless
@LocalBean
@Interceptors(ProfileInterceptorEJB.class)
public class ForecastAccess implements ForecastAccessIfLocal, ForecastAccessIfRemote {
    @PersistenceUnit(name = "pu")
    EntityManager entityManager;


    @Override
    public void addForecast(Forecast forecast) {
        entityManager.persist( forecast );
    }
}
