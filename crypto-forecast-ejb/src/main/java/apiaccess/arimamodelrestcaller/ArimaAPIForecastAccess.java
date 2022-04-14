package apiaccess.arimamodelrestcaller;

import apiaccess.interceptors.ProfileInterceptorEJB;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateless
@LocalBean
@Interceptors(ProfileInterceptorEJB.class)
public class ArimaAPIForecastAccess implements ArimaAPIForecastAccessLocalIf, ArimaAPIForecastAccessRemoteIf {
    @Override
    public String predict(AsyncInvoker asyncInvoker, Entity entity) {
        Future<Response> res = asyncInvoker.post( entity );
        try {
            return res.get( 60, TimeUnit.SECONDS )
                    .readEntity( String.class );
        } catch ( Exception e ) {
            res.cancel( true );
            return e.getMessage();
        }
    }
}
