package apiaccess.arimamodelrestcaller;

import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

public interface ArimaAPIForecastAccessIf {
    String predictBTC(Future<Response> res);

    String predictETH(Future<Response> res);

    String predictUSDT(Future<Response> res);
}
