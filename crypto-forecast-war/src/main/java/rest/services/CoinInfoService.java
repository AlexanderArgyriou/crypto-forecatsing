package rest.services;

import apiaccess.coinapirestcaller.CoinAPIAccessIfLocal;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local(CoinInfoServiceLocalIf.class)
public class CoinInfoService implements CoinInfoServiceLocalIf {
    @Inject
    CoinAPIAccessIfLocal coinAPIAccess;

    public String getETHTimeSeriesJson() {
        return coinAPIAccess.getETHTimeSeries();
    }

    public String getBTCTimeSeriesJson() {
        return coinAPIAccess.getBTCTimeSeries();
    }

    public String getUSDTTimeSeriesJson() {
        return coinAPIAccess.geUSDTTimeSeries();
    }
}
