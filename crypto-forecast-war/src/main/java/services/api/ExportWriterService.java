package services.api;

import apiaccess.exporter.ExportWriterIf;
import interceptors.ProfileInterceptorClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

@RequestScoped
@Interceptors(ProfileInterceptorClient.class)
public class ExportWriterService implements ExportWriterServiceIf {
    @Inject
    ExportWriterIf exportWriter;

    @Override
    public Response exportFile(HttpServletResponse response, String json) {
        return exportWriter.getFile( response, json );
    }
}
