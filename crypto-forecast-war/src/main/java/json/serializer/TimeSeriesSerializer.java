package json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import json.timeseries.beans.TimeSeries;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeSeriesSerializer extends JsonSerializer<TimeSeries> {
    @Override
    public void serialize(TimeSeries timeSeries,
                          JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeBooleanField( SerializeKeywords.STEPWISE.getS(), false );
        jsonGenerator.writeBooleanField( SerializeKeywords.APPROX.getS(), false );
        jsonGenerator.writeNumberField( SerializeKeywords.HORIZON.getS(), timeSeries.getPredictionsNum() );
        jsonGenerator.writeNumberField( SerializeKeywords.CI_LEVEL.getS(), 80 );

        jsonGenerator.writeObjectFieldStart( SerializeKeywords.PRECISION.getS() );
        jsonGenerator.writeNumberField( SerializeKeywords.DIGITS.getS(), 4 );
        jsonGenerator.writeStringField( SerializeKeywords.METHOD.getS(), SerializeKeywords.SIGNIFICANT.getS() );
        jsonGenerator.writeEndObject();

        jsonGenerator.writeArrayFieldStart( SerializeKeywords.TIME_SERIES_FIELD.getS() );
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart( SerializeKeywords.DATA_FIELD.getS() );
        timeSeries.getTimeSeriesList()
                .forEach( tc -> {
                    try {
                        String date = LocalDateTime.ofInstant( Instant.ofEpochSecond( tc.getTime().longValue() ), ZoneId.systemDefault() )
                                .truncatedTo( ChronoUnit.SECONDS )
                                .format( DateTimeFormatter.ofPattern( SerializeKeywords.TIME_SERIES_PATTERN.getS() ) );
                        BigDecimal mean = tc.getHigh().add( tc.getLow() )
                                .divide( BigDecimal.valueOf( 2 ), 2, BigDecimal.ROUND_HALF_UP );
                        jsonGenerator.writeNumberField( date, mean );
                    } catch ( IOException e ) {
                        e.printStackTrace();
                    }
                        }
                );
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    private enum SerializeKeywords {
        TIME_SERIES_PATTERN( "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" ),
        TIME_SERIES_FIELD( "time_series" ),
        DATA_FIELD( "data" ),
        STEPWISE( "stepwise" ),
        APPROX( "approximation" ),
        HORIZON( "horizon" ),
        CI_LEVEL( "ci_level" ),
        PRECISION( "precision" ),
        DIGITS( "digits" ),
        METHOD( "method" ),
        SIGNIFICANT( "significant" );

        String s;

        SerializeKeywords(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }
    }
}
