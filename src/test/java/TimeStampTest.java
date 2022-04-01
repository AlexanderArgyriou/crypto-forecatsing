import org.apache.http.client.utils.URIBuilder;
import org.junit.Test;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeStampTest {
    @Test
    public void timeStampCheck() {
        LocalDateTime now = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime beforeAWeek = now.minusWeeks(1);
        System.out.println(now);
        System.out.println(beforeAWeek);
        // "https://rest.coinapi.io/v1/exchangerate/BTC/USD/history?period_id=1MIN&time_start=2022-01-01T00:00:00&time_end=2022-01-01T03:00:00"
        URI uri = URI.create("https://rest.coinapi.io/v1/exchangerate/BTC/USD/history?period_id=1MIN&time_start=2022-01-01T00:00:00&time_end=2022-01-01T03:00:00");
        URIBuilder uriBuilder = new URIBuilder()
                .setScheme("https")
                .setHost("rest.coinapi.io")
                .setPath("/v1/exchangerate/BTC/USD/history")
                .setParameter("period_id", "1MIN")
                .setParameter("time_start", beforeAWeek.truncatedTo(ChronoUnit.SECONDS).toString())
                .setParameter("time_end", now.toString());
        System.out.println(uriBuilder);
    }
}
