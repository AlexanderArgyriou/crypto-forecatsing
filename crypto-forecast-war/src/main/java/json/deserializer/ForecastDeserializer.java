package json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import json.timeseries.TimeSeriesComponent;
import model.dtos.ForecastDTO;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

public class ForecastDeserializer extends JsonDeserializer<ForecastDTO> {
    @Override
    public ForecastDTO deserialize(JsonParser jsonParser,
                                   DeserializationContext deserializationContext)
            throws IOException {
//        JsonNode node = jsonParser.getCodec().readTree( jsonParser );
//        ArrayNode dataNode = (ArrayNode) node.get( TimeSeriesDeserializer.DeserializeKeywords.DATA.getS() )
//                .get( TimeSeriesDeserializer.DeserializeKeywords.DATA.getS() );
//        Iterator<JsonNode> i = dataNode.elements();
//        ForecastDTO forecastDTO = new ForecastDTO();
//        while ( i.hasNext() ) {
//            JsonNode n = i.next();
//            BigDecimal low = n.get( ( TimeSeriesDeserializer.DeserializeKeywords.LOW.getS() ) ).decimalValue();
//            BigDecimal high = n.get( TimeSeriesDeserializer.DeserializeKeywords.HIGH.getS() ).decimalValue();
//            BigInteger time = BigInteger.valueOf( n.get( TimeSeriesDeserializer.DeserializeKeywords.TIME.getS() ).longValue() );
//            timeSeries.addValue( new TimeSeriesComponent( low, high, time ) );
//        }
        return new ForecastDTO();
    }

    private enum DeserializeKeywords {
        DATA( "Data" ),
        LOW( "low" ),
        HIGH( "high" ),
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