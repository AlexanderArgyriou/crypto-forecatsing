package rest.endpoints;

import services.api.CoinInfoServiceIf;
import services.api.ForecastServiceIf;
import utils.URIUtils;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Path("predict")
public class PredictEndPoint {
    @Inject
    ForecastServiceIf forecastService;

    @Inject
    CoinInfoServiceIf coinInfoService;

    @Inject
    Client client;

    @Inject
    URIUtils uriUtils;

    @Path("btc/{time}/{predictions}")
    @GET
    @Produces("application/json")
    public String predictBTC(@PathParam("time") String minutes,
                             @PathParam("predictions") int predictions) {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getBTCTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIBTC(minutes).toString(), client)), predictions)));
        return forecastService.predictBTCJson(forecast);
    }

    @Path("eth/{time}/{predictions}")
    @GET
    @Produces("application/json")
    public String predictETH(@PathParam("time") String minutes,
                             @PathParam("predictions") int predictions) {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getETHTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIETH(minutes).toString(), client)), predictions)));
        return forecastService.predictETHJson(forecast);
    }

    @Path("usdt/{time}/{predictions}")
    @GET
    @Produces("application/json")
    public String predictUSDT(@PathParam("time") String minutes,
                              @PathParam("predictions") int predictions) {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getUSDTTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIUSDT(minutes).toString(), client)), predictions)));
        return forecastService.predictUSDTJson(forecast);
    }

    @Path("sol/{time}/{predictions}")
    @GET
    @Produces("application/json")
    public String predictSOL(@PathParam("time") String minutes,
                              @PathParam("predictions") int predictions) {
        Future<Response> forecast = uriUtils.getForecastAsyncInvoker(client)
                .post(Entity.json(uriUtils.constructTimeSeriesJson(
                        coinInfoService.getSOLTimeSeriesJson(
                                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURISOL(minutes).toString(), client)), predictions)));
        return forecastService.predictSOLJson(forecast);
    }
}
