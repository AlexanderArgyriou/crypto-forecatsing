package apiaccess.coinapirestcaller;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateless
@LocalBean
public class CoinAPIAccess implements CoinAPIAccessIfLocal {
    @Override
    public String getETHTimeSeries(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String geUSDTTimeSeries(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }

    @Override
    public String getBTCTimeSeries(Future<Response> res) {
        try {
            return res.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            res.cancel(true);
            return e.getMessage();
        }
    }
}
