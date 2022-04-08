package apiaccess.coinapirestcaller;

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
public class CoinAPIAccess implements CoinAPIAccessIfLocal, CoinAPIAccessIfRemote {
    @Override
    public String getETHTimeSeries(Future<Response> res) {
        try {
            return res.get(60, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String geUSDTTimeSeries(Future<Response> res) {
        try {
            return res.get(60, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String geSOLTimeSeries(Future<Response> res) {
        try {
            return res.get(60, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String getBTCTimeSeries(Future<Response> res) {
        try {
            return res.get(60, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }
}
