package json.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import json.timeseries.TimeSeriesComponent;
import json.timeseries.beans.TimeSeries;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

public class TimeSeriesDeserializer extends JsonDeserializer<TimeSeries> {
    @Override
    public TimeSeries deserialize(JsonParser jsonParser,
                                  DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        ArrayNode dataNode = (ArrayNode) node.get(DeserializeKeywords.DATA.getS())
                .get(DeserializeKeywords.DATA.getS());
        Iterator<JsonNode> i = dataNode.elements();
        TimeSeries timeSeries = new TimeSeries();
        while (i.hasNext()) {
            JsonNode n = i.next();
            BigDecimal low = n.get((DeserializeKeywords.LOW.getS())).decimalValue();
            BigDecimal high = n.get(DeserializeKeywords.HIGH.getS()).decimalValue();
            BigInteger time = BigInteger.valueOf(n.get(DeserializeKeywords.TIME.getS()).longValue());
            timeSeries.addValue(new TimeSeriesComponent(low, high, time));
        }
        return timeSeries;
    }

    private enum DeserializeKeywords {
        DATA("Data"),
        LOW("low"),
        HIGH("high"),
        TIME("time");

        String s;

        DeserializeKeywords(String s) {
            this.s = s;
        }

        public String getS() {
            return s;
        }
    }
}
