package json.timeseries.beans;

import services.api.CoinInfoServiceIf;
import services.api.ForecastServiceIf;
import utils.TimeConstants;
import utils.URIUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Named("forecast")
@RequestScoped
public class Forecast {
    @Inject
    ForecastServiceIf forecastService;

    @Inject
    CoinInfoServiceIf coinInfoService;

    @Inject
    Client client;

    @Inject
    URIUtils uriUtils;

    public String getForecastJson() {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getBTCTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIBTC(TimeConstants.LAST_EIGHT_HOURS_VALUES_PER_MINUTE.getS())
                                        .toString(), client)), 10)));
        return forecastService.predictBTCJson(forecast);
    }
}
