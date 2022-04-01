package apiaccess.arimamodelrestcaller;

import javax.ejb.Local;

@Local
public interface ArimaAPIForecastAccessLocalIf {
    String predictBTC();

    String predictETH();

    String predictUSDT();
}
