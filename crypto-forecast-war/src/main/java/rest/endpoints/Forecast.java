package rest.endpoints;

import rest.services.ForecastServiceLocalIf;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("predict")
public class Forecast {
    @Inject
    ForecastServiceLocalIf forecastService;

    @Path("btc")
    @GET
    @Produces("application/json")
    public String predictBTC() {
        return forecastService.predictBTCJson();
    }

    @Path("eth")
    @GET
    @Produces("application/json")
    public String predictETH() {
        return forecastService.predictETHJson();
    }

    @Path("usdt")
    @GET
    @Produces("application/json")
    public String predictUSDT() {
        return forecastService.predictUSDTJson();
    }
}
