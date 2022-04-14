package services.api;

import apiaccess.coinapirestcaller.CoinAPIAccessIfLocal;
import interceptors.ProfileInterceptorClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.client.Client;

@RequestScoped
@Interceptors(ProfileInterceptorClient.class)
public class CoinInfoService implements CoinInfoServiceIf {
    @Inject
    CoinAPIAccessIfLocal coinAPIAccess;

    @Override
    public String getETHTimeSeriesJson(String url, Client client) {
        return coinAPIAccess.getTimeSeries( url, client );
    }

    @Override
    public String getBTCTimeSeriesJson(String url, Client client) {
        return coinAPIAccess.getTimeSeries( url, client );
    }

    @Override
    public String getUSDTTimeSeriesJson(String url, Client client) {
        return coinAPIAccess.getTimeSeries( url, client );
    }

    @Override
    public String getSOLTimeSeriesJson(String url, Client client) {
        return coinAPIAccess.getTimeSeries( url, client );
    }
}
