package json.timeseries;

import java.math.BigDecimal;
import java.math.BigInteger;

public class TimeSeriesComponent {
    private final BigDecimal low;
    private final BigDecimal high;
    private final BigInteger time;

    public TimeSeriesComponent(BigDecimal low,
                               BigDecimal high,
                               BigInteger time) {
        this.low = low;
        this.high = high;
        this.time = time;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigInteger getTime() {
        return time;
    }
}
