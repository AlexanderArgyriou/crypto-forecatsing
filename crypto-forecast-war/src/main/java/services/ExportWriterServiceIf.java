package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

public interface ExportWriterServiceIf {
    Response exportFile(HttpServletResponse response, String json);
}