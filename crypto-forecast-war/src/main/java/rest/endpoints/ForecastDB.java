package rest.endpoints;

import services.db.ForecastDBServiceIf;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("save")
public class ForecastDB {
    @Inject
    ForecastDBServiceIf forecastDBService;

    @PUT
    public void addForecasts(String json) {
        forecastDBService.addForecasts( json );
    }
}
