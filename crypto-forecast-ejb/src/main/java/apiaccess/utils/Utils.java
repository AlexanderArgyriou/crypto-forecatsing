package apiaccess.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.Future;

public class Utils {
    private Utils() {
    }

    public static Optional<Path> getTempFile() {
        try {
            return Optional.of( Files.createTempFile( "export", ".log" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static Future<Response> getFuture(String uri, Client client) {
        return client
                .target( uri )
                .request( MediaType.APPLICATION_JSON )
                .async()
                .get();
    }
}
