package services.api;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

public interface ExportWriterServiceIf {
    Response exportFile(HttpServletResponse response, String json);
}
