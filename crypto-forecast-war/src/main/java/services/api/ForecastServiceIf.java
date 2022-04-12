package services.api;

import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

public interface ForecastServiceIf {
    String predictBTCJson(Future<Response> res);

    String predictETHJson(Future<Response> res);

    String predictUSDTJson(Future<Response> res);

    String predictSOLJson(Future<Response> res);
}
