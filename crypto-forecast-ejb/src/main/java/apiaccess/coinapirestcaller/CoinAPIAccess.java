package apiaccess.coinapirestcaller;

import apiaccess.interceptors.ProfileInterceptorEJB;
import apiaccess.utils.Utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Stateless
@LocalBean
@Interceptors(ProfileInterceptorEJB.class)
public class CoinAPIAccess implements CoinAPIAccessIfLocal, CoinAPIAccessIfRemote {
    @Override
    public String getTimeSeries(String url, Client client) {
        Future<Response> res = Utils.getFuture( url, client );
        try {
            return res.get( 60, TimeUnit.SECONDS )
                    .readEntity( String.class );
        } catch ( Exception e ) {
            res.cancel( true );
            return e.getMessage();
        }
    }
}
