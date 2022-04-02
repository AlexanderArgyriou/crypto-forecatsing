package services;

import apiaccess.arimamodelrestcaller.ArimaAPIForecastAccessLocalIf;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@Stateless
@Local
public class ForecastService implements ForecastServiceLocalIf {
    @Inject
    ArimaAPIForecastAccessLocalIf arimaAPIForecastAccess;

    @Override
    public String predictBTCJson(Future<Response> res) {
        return arimaAPIForecastAccess.predictBTC(res);
    }

    @Override
    public String predictETHJson(Future<Response> res) {
        return arimaAPIForecastAccess.predictETH(res);
    }

    @Override
    public String predictUSDTJson(Future<Response> res) {
        return arimaAPIForecastAccess.predictUSDT(res);
    }
}
