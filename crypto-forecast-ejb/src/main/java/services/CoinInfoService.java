package services;

import apiaccess.coinapirestcaller.CoinAPIAccessIfLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Stateless
@LocalBean
public class CoinInfoService implements CoinInfoServiceLocalIf {
    @Inject
    CoinAPIAccessIfLocal coinAPIAccess;

    public String getETHTimeSeriesJson(Future<Response> res) {
        return coinAPIAccess.getETHTimeSeries(res);
    }

    public String getBTCTimeSeriesJson(Future<Response> res) {
        return coinAPIAccess.getBTCTimeSeries(res);
    }

    public String getUSDTTimeSeriesJson(Future<Response> res) {
        return coinAPIAccess.geUSDTTimeSeries(res);
    }
}
