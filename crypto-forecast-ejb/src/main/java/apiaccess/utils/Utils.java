package apiaccess.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class Utils {
    public static Optional<Path> getTempFile() {
        try {
            return Optional.of(Files.createTempFile( "export", ".log" ));
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
