package model.mappers;

import model.dtos.ForecastDTO;
import model.entities.Forecast;

public class ForecastToForecastDTOMapper {
    public ForecastDTO forecastToForecastDTO(Forecast entity) {
        return new ForecastDTO(entity.getId(), entity.getLow(), entity.getHigh(), entity.getMean(), entity.getReal(), entity.getDate());
    }
}
