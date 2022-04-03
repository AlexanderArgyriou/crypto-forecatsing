package beans;

import javax.inject.Named;
import java.time.LocalDateTime;

@Named("timeStamp")
public class TimeStampBean {
    public String getCurrTimeStamp() {
        return LocalDateTime.now().toLocalTime().toString();
    }
}
