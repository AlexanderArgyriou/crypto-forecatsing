package apiaccess.coinapirestcaller;

import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

public interface CoinApiAccessIf {
    String getBTCTimeSeries(Future<Response> res);

    String getETHTimeSeries(Future<Response> res);

    String geUSDTTimeSeries(Future<Response> res);
}
