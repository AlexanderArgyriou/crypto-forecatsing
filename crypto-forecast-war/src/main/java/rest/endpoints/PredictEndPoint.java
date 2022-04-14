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
        return forecastService.predictBTCJson( uriUtils.getForecastAsyncInvoker( client ),
                Entity.json( uriUtils.constructTimeSeriesJson( coinInfoService.getBTCTimeSeriesJson( uriUtils.buildTimeSeriesGetURIBTC( minutes ).toString(), client ), predictions ) ) );
    }

    @Path("eth/{time}/{predictions}")
    @GET
    @Produces("application/json")
    public String predictETH(@PathParam("time") String minutes,
                             @PathParam("predictions") int predictions) {
        return forecastService.predictETHJson( uriUtils.getForecastAsyncInvoker( client ),
                Entity.json( uriUtils.constructTimeSeriesJson( coinInfoService.getETHTimeSeriesJson( uriUtils.buildTimeSeriesGetURIETH( minutes ).toString(), client ), predictions ) ) );
    }

    @Path("usdt/{time}/{predictions}")
    @GET
    @Produces("application/json")
    public String predictUSDT(@PathParam("time") String minutes,
                              @PathParam("predictions") int predictions) {
        return forecastService.predictUSDTJson( uriUtils.getForecastAsyncInvoker( client ),
                Entity.json( uriUtils.constructTimeSeriesJson( coinInfoService.getUSDTTimeSeriesJson( uriUtils.buildTimeSeriesGetURIUSDT( minutes ).toString(), client ), predictions ) ) );
    }

    @Path("sol/{time}/{predictions}")
    @GET
    @Produces("application/json")
    public String predictSOL(@PathParam("time") String minutes,
                             @PathParam("predictions") int predictions) {
        return forecastService.predictSOLJson( uriUtils.getForecastAsyncInvoker( client ),
                Entity.json( uriUtils.constructTimeSeriesJson( coinInfoService.getSOLTimeSeriesJson( uriUtils.buildTimeSeriesGetURISOL( minutes ).toString(), client ), predictions ) ) );
    }
}
