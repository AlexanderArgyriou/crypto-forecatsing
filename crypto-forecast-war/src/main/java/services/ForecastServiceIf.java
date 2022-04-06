package services;

import rest.endpoints.PredictEndPoint;

import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

public interface ForecastServiceIf {
    String predictBTCJson(Future<Response> res);

    String predictETHJson(Future<Response> res);

    String predictUSDTJson(Future<Response> res);

    PredictEndPoint predictBTCForecast(Future<Response> res);

    PredictEndPoint predictETHForecast(Future<Response> res);

    PredictEndPoint predictUSDTForecast(Future<Response> res);
}
