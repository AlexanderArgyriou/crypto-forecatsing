package apiaccess.coinapirestcaller;

import javax.ejb.Local;

@Local
public interface CoinAPIAccessIfLocal {
    String getBTCTimeSeries();

    String getETHTimeSeries();

    String geUSDTTimeSeries();
}
