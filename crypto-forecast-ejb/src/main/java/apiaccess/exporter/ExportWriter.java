package apiaccess.exporter;

import apiaccess.interceptors.ProfileInterceptorEJB;
import apiaccess.utils.Utils;

import org.apache.log4j.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Stateless
@LocalBean
@Interceptors(ProfileInterceptorEJB.class)
public class ExportWriter implements ExportWriterIfLocal, ExportWriterIfRemote {
    private static final Logger logger = Logger.getLogger( ExportWriter.class );

    @Override
    public Response getFile(HttpServletResponse response, String json) {
        /*
        this meant to get the fields from the json and write them in a proper human readable format.
        It was out of thesis scope(i was bored to do it actually), so we return the same json, which is stupid, but we just want to export.
         */
        Optional<Path> path = Utils.getTempFile();
        if ( path.isPresent() ) {
            try ( FileWriter fileWriter = new FileWriter( path.get().toString() );
                  DataInputStream in = new DataInputStream( new FileInputStream( path.get().toString() ) );
                  ServletOutputStream outStream = response.getOutputStream(); ) {
                Files.write(path.get(), json.getBytes( StandardCharsets.UTF_8));
                response.setContentLength( (int) path.get().toFile().length() );
                response.setHeader( "Content-Disposition", "attachment; filename="
                        + "export.txt" );
                byte[] bbuf = new byte[(int) path.get().toFile().length() + 1024];
                int length = 0;
                while ( ( in != null ) && ( ( length = in.read( bbuf ) ) != -1 ) ) {
                    outStream.write( bbuf, 0, length );
                }
                outStream.flush();
            } catch ( Exception e ) {
                logger.error( e.getMessage() );
            }
        }
        return Response.ok().build();
    }
}
