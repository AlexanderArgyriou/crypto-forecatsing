package services;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Local
public interface ForecastServiceLocalIf {
    String predictBTCJson(Future<Response> res);

    String predictETHJson(Future<Response> res);

    String predictUSDTJson(Future<Response> res);
}
