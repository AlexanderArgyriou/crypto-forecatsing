package services.api;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Entity;

public interface ForecastServiceIf {
    String predictBTCJson(AsyncInvoker asyncInvoker, Entity entity);

    String predictETHJson(AsyncInvoker asyncInvoker, Entity entity);

    String predictUSDTJson(AsyncInvoker asyncInvoker, Entity entity);

    String predictSOLJson(AsyncInvoker asyncInvoker, Entity entity);
}
