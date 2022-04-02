package apiaccess.arimamodelrestcaller;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Local
public interface ArimaAPIForecastAccessLocalIf {
    String predictBTC(Future<Response> res);

    String predictETH(Future<Response> res);

    String predictUSDT(Future<Response> res);
}
