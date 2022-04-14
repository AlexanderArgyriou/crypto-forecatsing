package apiaccess.arimamodelrestcaller;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Entity;

public interface ArimaAPIForecastAccessIf {
    String predict(AsyncInvoker asyncInvoker, Entity entity);
}
