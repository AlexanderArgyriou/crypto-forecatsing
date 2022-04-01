package apiaccess.arimamodelrestcaller;

import apiaccess.coinapirestcaller.CoinAPIAccessIfLocal;
import apiaccess.utils.CoinURIConstants;
import apiaccess.utils.URIUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.timeseries.TimeSeries;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateless
@Local(ArimaAPIForecastAccessLocalIf.class)
public class ArimaAPIForecastAccess implements ArimaAPIForecastAccessLocalIf {
    @Inject
    CoinAPIAccessIfLocal coinAPIService;

    @Override
    public String predictBTC() {
        Future<Response> forecast = getAsyncInvoker()
                .post(Entity.json(constructBTCTimeSeriesJson()));
        try {
            return forecast.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            forecast.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String predictETH() {
        Future<Response> forecast = getAsyncInvoker()
                .post(Entity.json(constructETHTimeSeriesJson()));
        try {
            return forecast.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            forecast.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String predictUSDT() {
        Future<Response> forecast = getAsyncInvoker()
                .post(Entity.json(constructUSDTTimeSeriesJson()));
        try {
            return forecast.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            forecast.cancel(true);
            return e.getMessage();
        }
    }

    private AsyncInvoker getAsyncInvoker() {
        return ClientBuilder.newClient()
                .target(URIUtils.buildForecastURI().toString())
                .request(MediaType.APPLICATION_JSON)
                .header(CoinURIConstants.TIME_SERIES_API_KEY_HEADER.getS(),
                        "6ff882db-2369-4fb4-ba16-4b671c12d81e")
                .async();
    }

    private String constructBTCTimeSeriesJson() {
        return construct(coinAPIService.getBTCTimeSeries());
    }

    private String constructETHTimeSeriesJson() {
        return construct(coinAPIService.getETHTimeSeries());
    }

    private String constructUSDTTimeSeriesJson() {
        return construct(coinAPIService.geUSDTTimeSeries());
    }

    private String construct(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            TimeSeries t = mapper.readValue(json, TimeSeries.class);
            return mapper.writeValueAsString(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
