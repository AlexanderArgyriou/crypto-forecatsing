package entities;

import javax.ejb.Local;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Forecast {
    @Id
    @GeneratedValue
    private Local id;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal mean;
    private BigDecimal real;
    private LocalDateTime date;
}
