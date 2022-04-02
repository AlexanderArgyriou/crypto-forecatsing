package rest.endpoints;

import services.CoinInfoServiceLocalIf;
import utils.URIUtils;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Path("timeseries")
public class TimeSeries {
    @Inject
    CoinInfoServiceLocalIf coinInfoService;

    @Inject
    Client client;

    @Inject
    URIUtils uriUtils;

    @Path("btc")
    @GET
    @Produces("application/json")
    public String getBTCTimeSeries() {
        Future<Response> btc =
                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIBTC().toString(), client);
        return coinInfoService.getBTCTimeSeriesJson(btc);
    }

    @Path("eth")
    @GET
    @Produces("application/json")
    public String geETHTimeSeries() {
        Future<Response> eth =
                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIETH().toString(), client);
        return coinInfoService.getETHTimeSeriesJson(eth);
    }

    @Path("usdt")
    @GET
    @Produces("application/json")
    public String geUSDTTimeSeries() {
        Future<Response> usdt =
                uriUtils.getFutureResponse(uriUtils.buildTimeSeriesGetURIUSDT().toString(), client);
        return coinInfoService.getUSDTTimeSeriesJson(usdt);
    }
}
