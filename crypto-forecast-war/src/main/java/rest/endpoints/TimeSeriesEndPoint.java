package rest.endpoints;

import services.api.CoinInfoServiceIf;
import utils.URIUtils;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;

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
        return coinInfoService.getBTCTimeSeriesJson( uriUtils.buildTimeSeriesGetURIBTC( minutes ).toString(), client );
    }

    @Path("eth/{time}")
    @GET
    @Produces("application/json")
    public String getETHTimeSeries(@PathParam("time") String minutes) {
        return coinInfoService.getETHTimeSeriesJson( uriUtils.buildTimeSeriesGetURIETH( minutes ).toString(), client );
    }

    @Path("usdt/{time}")
    @GET
    @Produces("application/json")
    public String getUSDTTimeSeries(@PathParam("time") String minutes) {
        return coinInfoService.getUSDTTimeSeriesJson( uriUtils.buildTimeSeriesGetURIUSDT( minutes ).toString(), client );
    }

    @Path("sol/{time}")
    @GET
    @Produces("application/json")
    public String getSOLTimeSeries(@PathParam("time") String minutes) {
        return coinInfoService.getUSDTTimeSeriesJson( uriUtils.buildTimeSeriesGetURISOL( minutes ).toString(), client );
    }
}
