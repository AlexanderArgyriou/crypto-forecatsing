package model.mappers;

import model.dtos.ForecastDTO;
import model.entities.Forecast;

public class ForecastDTOToForecastMapper {
    public Forecast forecastDTOToForecast(ForecastDTO dto) {
        return new Forecast(dto.getId(), dto.getLow(), dto.getHigh(), dto.getMean(), dto.getReal(), dto.getDate());
    }
}
