package services;

import rest.endpoints.Predict;

import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

public interface ForecastServiceIf {
    String predictBTCJson(Future<Response> res);

    String predictETHJson(Future<Response> res);

    String predictUSDTJson(Future<Response> res);

    Predict predictBTCForecast(Future<Response> res);

    Predict predictETHForecast(Future<Response> res);

    Predict predictUSDTForecast(Future<Response> res);
}
