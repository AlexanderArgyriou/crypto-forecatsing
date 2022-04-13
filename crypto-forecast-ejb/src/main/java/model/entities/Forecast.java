package model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Forecast {
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal mean;
    private BigDecimal real;
    private LocalDateTime date;
    private String coin;

    public Forecast() {
    }

    public Forecast(Long id, BigDecimal low, BigDecimal high, BigDecimal mean, BigDecimal real, LocalDateTime date, String coin) {
        this.id = id;
        this.low = low;
        this.high = high;
        this.mean = mean;
        this.real = real;
        this.date = date;
        this.coin = coin;
    }

    public Forecast(BigDecimal low, BigDecimal high, BigDecimal mean, BigDecimal real, LocalDateTime date, String coin) {
        this.low = low;
        this.high = high;
        this.mean = mean;
        this.real = real;
        this.date = date;
        this.coin = coin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getMean() {
        return mean;
    }

    public void setMean(BigDecimal mean) {
        this.mean = mean;
    }

    public BigDecimal getReal() {
        return real;
    }

    public void setReal(BigDecimal real) {
        this.real = real;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }
}
