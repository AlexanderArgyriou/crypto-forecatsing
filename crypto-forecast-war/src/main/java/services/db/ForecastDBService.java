package services.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbaccess.ForecastAccessIf;
import dto.ForecastDTOCollection;
import interceptors.ProfileInterceptorClient;
import model.dtos.ForecastDTO;
import model.mappers.ForecastDTOToForecastMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;

@RequestScoped
@Interceptors(ProfileInterceptorClient.class)
public class ForecastDBService implements ForecastDBServiceIf {
    @Inject
    ForecastAccessIf forecastAccessIf;


    @Override
    public void addForecast(ForecastDTO dto) {
        forecastAccessIf.addForecast( new ForecastDTOToForecastMapper().forecastDTOToForecast( dto ) );
    }

    @Override
    public void addForecasts(String json) {
        try {
            ForecastDTOCollection forecastDTOCollection = new ObjectMapper().readValue( json, ForecastDTOCollection.class );
            ForecastDTOToForecastMapper forecastDTOToForecastMapper = new ForecastDTOToForecastMapper();
            forecastDTOCollection.getForecastDTOs()
                    .forEach( forecastDTO -> forecastAccessIf.addForecast(
                            forecastDTOToForecastMapper.forecastDTOToForecast( forecastDTO ) ) );
        } catch ( JsonProcessingException e ) {
            e.printStackTrace();
        }
    }
}
