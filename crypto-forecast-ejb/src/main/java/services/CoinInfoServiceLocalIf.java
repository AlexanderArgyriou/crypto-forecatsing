package services;

import javax.ejb.Local;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Local
public interface CoinInfoServiceLocalIf {
    String getETHTimeSeriesJson(Future<Response> res);

    String getBTCTimeSeriesJson(Future<Response> res);

    String getUSDTTimeSeriesJson(Future<Response> res);
}
