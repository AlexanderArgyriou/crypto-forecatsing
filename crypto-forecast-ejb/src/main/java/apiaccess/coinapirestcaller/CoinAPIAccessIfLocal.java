package apiaccess.coinapirestcaller;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Local
public interface CoinAPIAccessIfLocal {
    String getBTCTimeSeries(Future<Response> res);

    String getETHTimeSeries(Future<Response> res);

    String geUSDTTimeSeries(Future<Response> res);
}
