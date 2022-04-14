package services.api;

import apiaccess.arimamodelrestcaller.ArimaAPIForecastAccessLocalIf;
import interceptors.ProfileInterceptorClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Entity;

@RequestScoped
@Interceptors(ProfileInterceptorClient.class)
public class ForecastService implements ForecastServiceIf {
    @Inject
    ArimaAPIForecastAccessLocalIf arimaAPIForecastAccess;

    @Override
    public String predictBTCJson(AsyncInvoker asyncInvoker, Entity entity) {
        return arimaAPIForecastAccess.predict( asyncInvoker, entity );
    }

    @Override
    public String predictETHJson(AsyncInvoker asyncInvoker, Entity entity) {
        return arimaAPIForecastAccess.predict( asyncInvoker, entity );
    }

    @Override
    public String predictUSDTJson(AsyncInvoker asyncInvoker, Entity entity) {
        return arimaAPIForecastAccess.predict( asyncInvoker, entity );
    }

    @Override
    public String predictSOLJson(AsyncInvoker asyncInvoker, Entity entity) {
        return arimaAPIForecastAccess.predict( asyncInvoker, entity );
    }
}
