package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.timeseries.TimeSeries;

import org.apache.http.client.utils.URIBuilder;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@ApplicationScoped
public class URIUtils {
    public URIBuilder buildTimeSeriesGetURIBTC() {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.BTC.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        TimeConstants.LAST_EIGHT_HOURS_VALUES_PER_MINUTE.getS());
    }

    public URIBuilder buildTimeSeriesGetURIETH() {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.ETH.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        TimeConstants.LAST_EIGHT_HOURS_VALUES_PER_MINUTE.getS());
    }

    public URIBuilder buildTimeSeriesGetURIUSDT() {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.USDT.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        TimeConstants.LAST_EIGHT_HOURS_VALUES_PER_MINUTE.getS());
    }

    public AsyncInvoker getForecastAsyncInvoker(Client client) {
        return client
                .target(new URIBuilder()
                        .setScheme(CoinURIConstants.HTTPS.getS())
                        .setHost(TimeSeriesURIConstants.TIMESERIES_API_DOMAIN.getS())
                        .setPath(TimeSeriesURIConstants.TIMESERIES_API_PATH_ANALYSIS.getS()).toString())
                .request(MediaType.APPLICATION_JSON)
                .header(CoinURIConstants.TIME_SERIES_API_KEY_HEADER.getS(),
                        "6ff882db-2369-4fb4-ba16-4b671c12d81e")
                .async();
    }

    public String constructTimeSeriesJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            TimeSeries t = mapper.readValue(json, TimeSeries.class);
            return mapper.writeValueAsString(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "{}";
        }
    }

    public Future<Response> getFutureResponse(String uri, Client client) {
        return client
                .target(uri)
                .request(MediaType.APPLICATION_JSON)
                .async()
                .get();
    }
}
