package rest.endpoints;

import services.CoinInfoServiceIf;
import services.ForecastServiceIf;
import utils.URIUtils;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Path("predict")
public class Predict {
    @Inject
    ForecastServiceIf forecastService;

    @Inject
    CoinInfoServiceIf coinInfoService;

    @Inject
    Client client;

    @Inject
    URIUtils uriUtils;

    @Path("btc")
    @GET
    @Produces("application/json")
    public String predictBTC() {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getBTCTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIBTC().toString(), client)))));
        return forecastService.predictBTCJson(forecast);
    }

    @Path("eth")
    @GET
    @Produces("application/json")
    public String predictETH() {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getETHTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIETH().toString(), client)))));
        return forecastService.predictETHJson(forecast);
    }

    @Path("usdt")
    @GET
    @Produces("application/json")
    public String predictUSDT() {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getUSDTTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIUSDT().toString(), client)))));
        return forecastService.predictUSDTJson(forecast);
    }
}
