import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.timeseries.TimeSeries;

import org.junit.Test;

public class JsonTests {
    @Test
    public void dsrlzrTest() throws JsonProcessingException {
        String json = "{\n" +
                "  \"Response\": \"Success\",\n" +
                "  \"Message\": \"\",\n" +
                "  \"HasWarning\": false,\n" +
                "  \"Type\": 100,\n" +
                "  \"RateLimit\": {},\n" +
                "  \"Data\": {\n" +
                "    \"Aggregated\": false,\n" +
                "    \"TimeFrom\": 1648785960,\n" +
                "    \"TimeTo\": 1648814760,\n" +
                "    \"Data\": [\n" +
                "      {\n" +
                "        \"time\": 1648785960,\n" +
                "        \"high\": 40397.62,\n" +
                "        \"low\": 40364.08,\n" +
                "        \"open\": 40388.01,\n" +
                "        \"volumefrom\": 0.5932,\n" +
                "        \"volumeto\": 23950.12,\n" +
                "        \"close\": 40397.62,\n" +
                "        \"conversionType\": \"direct\",\n" +
                "        \"conversionSymbol\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\": 1648786020,\n" +
                "        \"high\": 40397.62,\n" +
                "        \"low\": 40334.86,\n" +
                "        \"open\": 40397.62,\n" +
                "        \"volumefrom\": 3.049,\n" +
                "        \"volumeto\": 123034.37,\n" +
                "        \"close\": 40341.1,\n" +
                "        \"conversionType\": \"direct\",\n" +
                "        \"conversionSymbol\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\": 1648786080,\n" +
                "        \"high\": 40344.24,\n" +
                "        \"low\": 40332.4,\n" +
                "        \"open\": 40341.1,\n" +
                "        \"volumefrom\": 0.4127,\n" +
                "        \"volumeto\": 16645.68,\n" +
                "        \"close\": 40334.58,\n" +
                "        \"conversionType\": \"direct\",\n" +
                "        \"conversionSymbol\": \"\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"time\": 1648814760,\n" +
                "        \"high\": 40825.97,\n" +
                "        \"low\": 40824.43,\n" +
                "        \"open\": 40825.97,\n" +
                "        \"volumefrom\": 0,\n" +
                "        \"volumeto\": 0,\n" +
                "        \"close\": 40824.43,\n" +
                "        \"conversionType\": \"direct\",\n" +
                "        \"conversionSymbol\": \"\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";


        ObjectMapper mapper = new ObjectMapper();
        TimeSeries t = mapper.readValue(json, TimeSeries.class);
        String s = mapper.writeValueAsString(t);
        System.out.println(s);
    }
}
