package rest.endpoints;

import rest.services.CoinInfoServiceLocalIf;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("timeseries")
public class TimeSeries {
    @Inject
    CoinInfoServiceLocalIf coinInfoService;

    @Path("btc")
    @GET
    @Produces("application/json")
    public String getBTCTimeSeries() {
        return coinInfoService.getBTCTimeSeriesJson();
    }

    @Path("eth")
    @GET
    @Produces("application/json")
    public String geETHTimeSeries() {
        return coinInfoService.getETHTimeSeriesJson();
    }

    @Path("usdt")
    @GET
    @Produces("application/json")
    public String geUSDTTimeSeries() {
        return coinInfoService.getUSDTTimeSeriesJson();
    }
}
