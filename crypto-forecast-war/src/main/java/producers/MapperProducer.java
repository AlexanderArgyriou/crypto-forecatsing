package producers;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.inject.Produces;

public class MapperProducer {
    @Produces
    private ObjectMapper createObjectMapper() {
        return new ObjectMapper();
    }
}
