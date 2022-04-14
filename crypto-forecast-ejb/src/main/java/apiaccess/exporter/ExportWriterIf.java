package apiaccess.exporter;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

public interface ExportWriterIf {
    Response getFile(HttpServletResponse response, String json);
}
