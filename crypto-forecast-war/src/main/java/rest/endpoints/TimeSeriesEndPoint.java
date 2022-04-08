package rest.endpoints;

import services.CoinInfoServiceIf;
import utils.URIUtils;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Path("timeseries")
public class TimeSeriesEndPoint {
    @Inject
    CoinInfoServiceIf coinInfoService;

    @Inject
    Client client;

    @Inject
    URIUtils uriUtils;

    @Path("btc/{time}")
    @GET
    @Produces("application/json")
    public String getBTCTimeSeries(@PathParam("time") String minutes) {
        Future<Response> btc =
                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIBTC(minutes).toString(), client);
        return coinInfoService.getBTCTimeSeriesJson(btc);
    }

    @Path("eth/{time}")
    @GET
    @Produces("application/json")
    public String getETHTimeSeries(@PathParam("time") String minutes) {
        Future<Response> eth =
                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIETH(minutes).toString(), client);
        return coinInfoService.getETHTimeSeriesJson(eth);
    }

    @Path("usdt/{time}")
    @GET
    @Produces("application/json")
    public String getUSDTTimeSeries(@PathParam("time") String minutes) {
        Future<Response> usdt =
                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIUSDT(minutes).toString(), client);
        return coinInfoService.getUSDTTimeSeriesJson(usdt);
    }

    @Path("sol/{time}")
    @GET
    @Produces("application/json")
    public String getSOLTimeSeries(@PathParam("time") String minutes) {
        Future<Response> sol =
                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURISOL(minutes).toString(), client);
        return coinInfoService.getUSDTTimeSeriesJson(sol);
    }
}
