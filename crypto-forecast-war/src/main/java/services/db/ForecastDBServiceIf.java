package services.db;

import model.dtos.ForecastDTO;

public interface ForecastDBServiceIf {
    void addForecast(ForecastDTO dto);

    void addForecasts(String json);
}
