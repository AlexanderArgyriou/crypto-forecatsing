package rest.endpoints;

import services.ExportWriterServiceIf;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("export")
public class Export {
    @Inject
    ExportWriterServiceIf exportWriterService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response exp(@Context HttpServletResponse response,
                        String json) {
        return exportWriterService.exportFile(response,  json);
    }
}
