package services;

import apiaccess.arimamodelrestcaller.ArimaAPIForecastAccessLocalIf;
import interceptors.ProfileInterceptorClient;
import rest.endpoints.PredictEndPoint;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@RequestScoped
@Interceptors(ProfileInterceptorClient.class)
public class ForecastService implements ForecastServiceIf {
    @Inject
    ArimaAPIForecastAccessLocalIf arimaAPIForecastAccess;

    @Override
    public String predictBTCJson(Future<Response> res) {
        return arimaAPIForecastAccess.predictBTC(res);
    }

    @Override
    public String predictETHJson(Future<Response> res) {
        return arimaAPIForecastAccess.predictETH(res);
    }

    @Override
    public String predictUSDTJson(Future<Response> res) {
        return arimaAPIForecastAccess.predictUSDT(res);
    }

    @Override
    public PredictEndPoint predictBTCForecast(Future<Response> res) {
        return null;
    }

    @Override
    public PredictEndPoint predictETHForecast(Future<Response> res) {
        return null;
    }

    @Override
    public PredictEndPoint predictUSDTForecast(Future<Response> res) {
        return null;
    }

}
