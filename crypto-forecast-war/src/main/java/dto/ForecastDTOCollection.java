package dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import json.deserializer.ForecastDeserializer;
import model.dtos.ForecastDTO;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = ForecastDeserializer.class)
public class ForecastDTOCollection {
    private final List<ForecastDTO> forecastDTOs = new ArrayList<>();

    public void addForecastDTO(ForecastDTO forecastDTO) {
        forecastDTOs.add( forecastDTO );
    }

    public List<ForecastDTO> getForecastDTOs() {
        return forecastDTOs;
    }
}
