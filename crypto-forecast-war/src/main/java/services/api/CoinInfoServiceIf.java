package services.api;

import javax.ws.rs.client.Client;

public interface CoinInfoServiceIf {
    String getETHTimeSeriesJson(String url, Client client);

    String getBTCTimeSeriesJson(String url, Client client);

    String getUSDTTimeSeriesJson(String url, Client client);

    String getSOLTimeSeriesJson(String url, Client client);
}
