package apiaccess.arimamodelrestcaller;

import apiaccess.interceptors.ProfileInterceptorEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateless
@LocalBean
@Interceptors(ProfileInterceptorEJB.class)
public class ArimaAPIForecastAccess implements ArimaAPIForecastAccessLocalIf, ArimaAPIForecastAccessRemoteIf {
    @Override
    public String predictBTC(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String predictETH(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String predictUSDT(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }
}
