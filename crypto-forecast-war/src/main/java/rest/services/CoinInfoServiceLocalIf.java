package rest.services;

import javax.ejb.Local;

@Local
public interface CoinInfoServiceLocalIf {
    String getETHTimeSeriesJson();

    String getBTCTimeSeriesJson();

    String getUSDTTimeSeriesJson();
}
