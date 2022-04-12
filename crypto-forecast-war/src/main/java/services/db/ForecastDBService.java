package services.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbaccess.ForecastAccessIf;
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
    public void addForecast(String json) {
        try {
            forecastAccessIf.addForecast(new ForecastDTOToForecastMapper()
                    .forecastDTOToForecast(new ObjectMapper().readValue(json, ForecastDTO.class)));
        } catch ( JsonProcessingException e ) {
            e.printStackTrace();
        }
    }
}
