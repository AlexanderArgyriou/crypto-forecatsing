package json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import dto.ForecastDTOCollection;
import model.dtos.ForecastDTO;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Iterator;

public class ForecastDeserializer extends JsonDeserializer<ForecastDTOCollection> {
    @Override
    public ForecastDTOCollection deserialize(JsonParser jsonParser,
                                             DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree( jsonParser );
        Iterator<JsonNode> i = node.elements();
        ForecastDTOCollection forecasts = new ForecastDTOCollection();
        while ( i.hasNext() ) {
            JsonNode n = i.next();
            BigDecimal low = n.get( ( DeserializeKeywords.LOW.getS() ) ).decimalValue();
            BigDecimal high = n.get( DeserializeKeywords.HIGH.getS() ).decimalValue();
            BigDecimal mean = n.get( DeserializeKeywords.MEAN.getS() ).decimalValue();
            BigDecimal real = n.get( DeserializeKeywords.REAL.getS() ).decimalValue();
            String realDate = n.get( DeserializeKeywords.REAL_DATE.getS() ).asText();
            if ( real != null && !"0".equals(real.toString()) ) {
                forecasts.addForecastDTO( new ForecastDTO( low, high, mean, real, LocalDateTime.parse( realDate.substring( 0, realDate.length() - 1 ) ) ) );
            }
        }
        return forecasts;
    }

    private enum DeserializeKeywords {
        LOW( "low" ),
        HIGH( "high" ),
        MEAN( "mean" ),
        REAL( "real" ),
        REAL_DATE( "realDate" ),
        TIME( "name" );

        String s;

        DeserializeKeywords(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }
    }
}