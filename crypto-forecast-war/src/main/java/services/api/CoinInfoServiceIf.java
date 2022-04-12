package services.api;

import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

public interface CoinInfoServiceIf {
    String getETHTimeSeriesJson(Future<Response> res);

    String getBTCTimeSeriesJson(Future<Response> res);

    String getUSDTTimeSeriesJson(Future<Response> res);

    String getSOLTimeSeriesJson(Future<Response> res);
}
