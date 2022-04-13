package dbaccess;

import apiaccess.interceptors.ProfileInterceptorEJB;
import model.entities.Forecast;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Stateless
@LocalBean
@Interceptors(ProfileInterceptorEJB.class)
public class ForecastAccess implements ForecastAccessIfLocal, ForecastAccessIfRemote {
    @PersistenceContext(unitName = "pu")
    private EntityManager entityManager;

    @Override
    public void addForecast(Forecast forecast) {
        entityManager.persist( forecast );
    }
}
