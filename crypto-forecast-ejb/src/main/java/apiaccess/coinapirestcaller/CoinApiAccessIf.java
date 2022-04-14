package apiaccess.coinapirestcaller;

import javax.ws.rs.client.Client;

public interface CoinApiAccessIf {
    String getTimeSeries(String url, Client client);
}
