package rest.services;

import javax.ejb.Local;

@Local
public interface ForecastServiceLocalIf {
    String predictBTCJson();

    String predictETHJson();

    String predictUSDTJson();
}
