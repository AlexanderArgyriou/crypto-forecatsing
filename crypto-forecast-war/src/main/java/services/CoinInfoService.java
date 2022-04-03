package services;

import apiaccess.coinapirestcaller.CoinAPIAccessIfLocal;
import interceptors.ProfileInterceptorClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@RequestScoped
@Interceptors(ProfileInterceptorClient.class)
public class CoinInfoService implements CoinInfoServiceIf {
    @Inject
    CoinAPIAccessIfLocal coinAPIAccess;

    public String getETHTimeSeriesJson(Future<Response> res) {
        return coinAPIAccess.getETHTimeSeries(res);
    }

    public String getBTCTimeSeriesJson(Future<Response> res) {
        return coinAPIAccess.getBTCTimeSeries(res);
    }

    public String getUSDTTimeSeriesJson(Future<Response> res) {
        return coinAPIAccess.geUSDTTimeSeries(res);
    }
}
