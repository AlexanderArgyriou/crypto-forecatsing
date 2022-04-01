package rest.services;

import apiaccess.arimamodelrestcaller.ArimaAPIForecastAccessLocalIf;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Local
public class ForecastService implements ForecastServiceLocalIf {
    @Inject
    ArimaAPIForecastAccessLocalIf arimaAPIForecastAccess;

    @Override
    public String predictBTCJson() {
        return arimaAPIForecastAccess.predictBTC();
    }

    @Override
    public String predictETHJson() {
        return arimaAPIForecastAccess.predictETH();
    }

    @Override
    public String predictUSDTJson() {
        return arimaAPIForecastAccess.predictUSDT();
    }
}
