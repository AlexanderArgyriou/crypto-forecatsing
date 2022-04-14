package model.mappers;

import model.dtos.ForecastDTO;
import model.entities.Forecast;

public class ForecastToForecastDTOMapper {
    public ForecastDTO forecastToForecastDTO(Forecast entity) {
        return new ForecastDTO( entity.getLow(), entity.getHigh(), entity.getMean(), entity.getReal(), entity.getDate(), entity.getCoin() );
    }
}
