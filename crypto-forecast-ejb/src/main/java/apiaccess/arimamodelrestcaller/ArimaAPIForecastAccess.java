package apiaccess.arimamodelrestcaller;

import apiaccess.coinapirestcaller.CoinAPIAccessIfLocal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateless
@LocalBean
public class ArimaAPIForecastAccess implements ArimaAPIForecastAccessLocalIf {
    @Inject
    CoinAPIAccessIfLocal coinAPIService;

    @Override
    public String predictBTC(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String predictETH(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String predictUSDT(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }
}
