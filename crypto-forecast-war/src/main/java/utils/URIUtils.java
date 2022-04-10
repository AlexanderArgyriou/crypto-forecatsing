package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import json.timeseries.beans.TimeSeries;

import org.apache.http.client.utils.URIBuilder;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

@ApplicationScoped
public class URIUtils {
    @Inject
    ObjectMapper mapper;

    public URIBuilder buildTimeSeriesGetURIBTC(String minutes) {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.BTC.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        minutes)
                .addParameter("api_key", "a28fafbfb7ab8e5ab7d2b684aabfeb0ec97decf789529ac4130d8bfd181fb000");
    }

    public URIBuilder buildTimeSeriesGetURIETH(String minutes) {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.ETH.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        minutes)
                .addParameter("api_key", "a28fafbfb7ab8e5ab7d2b684aabfeb0ec97decf789529ac4130d8bfd181fb000");
    }

    public URIBuilder buildTimeSeriesGetURIUSDT(String minutes) {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.USDT.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        minutes)
                .addParameter("api_key", "a28fafbfb7ab8e5ab7d2b684aabfeb0ec97decf789529ac4130d8bfd181fb000");
    }

    public URIBuilder buildTimeSeriesGetURISOL(String minutes) {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.SOL.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        minutes)
                .addParameter("api_key", "a28fafbfb7ab8e5ab7d2b684aabfeb0ec97decf789529ac4130d8bfd181fb000");
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

    public String constructTimeSeriesJson(String json, int numberOfPredictions) {
        try {
            TimeSeries t = mapper.readValue(json, TimeSeries.class);
            t.setPredictionsNum(numberOfPredictions);
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
