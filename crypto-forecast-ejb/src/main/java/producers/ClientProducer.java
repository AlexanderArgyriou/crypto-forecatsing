package producers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public class ClientProducer {
    @Produces
    private Client produceClient(InjectionPoint injectionPoint) {
        return ClientBuilder.newClient();
    }

    private void closeClient(@Disposes Client client) {
        client.close();
    }
}
