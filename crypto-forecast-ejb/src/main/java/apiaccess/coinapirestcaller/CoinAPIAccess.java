package apiaccess.coinapirestcaller;

import apiaccess.utils.URIUtils;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateless
@Local(CoinAPIAccessIfLocal.class)
public class CoinAPIAccess implements CoinAPIAccessIfLocal {
    public String getETHTimeSeries() {
        Future<Response> eth = getFutureResponse(URIUtils.buildTimeSeriesGetURIETH().toString());
        try {
            return eth.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            eth.cancel(true);
            return e.getMessage();
        }
    }

    public String geUSDTTimeSeries() {
        Future<Response> usdt = getFutureResponse(URIUtils.buildTimeSeriesGetURIUSDT().toString());
        try {
            return usdt.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            usdt.cancel(true);
            return e.getMessage();
        }
    }

    public String getBTCTimeSeries() {
        Future<Response> btc = getFutureResponse(URIUtils.buildTimeSeriesGetURIBTC().toString());
        try {
            return btc.get(15, TimeUnit.SECONDS)
                    .readEntity(String.class);
        } catch (Exception e) {
            btc.cancel(true);
            return e.getMessage();
        }
    }

    private Future<Response> getFutureResponse(String uri) {
        return ClientBuilder.newClient()
                .target(uri)
                .request(MediaType.APPLICATION_JSON)
                .async()
                .get();
    }
}
