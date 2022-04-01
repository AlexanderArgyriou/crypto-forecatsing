package apiaccess.utils;

import org.apache.http.client.utils.URIBuilder;

public class URIUtils {
    private URIUtils() {
    }

    public static URIBuilder buildTimeSeriesGetURIBTC() {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.BTC.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        TimeConstants.LAST_EIGHT_HOURS_VALUES_PER_MINUTE.getS());
    }

    public static URIBuilder buildTimeSeriesGetURIETH() {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.ETH.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        TimeConstants.LAST_EIGHT_HOURS_VALUES_PER_MINUTE.getS());
    }

    public static URIBuilder buildTimeSeriesGetURIUSDT() {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(CoinURIConstants.COIN_API_DOMAIN.getS())
                .setPath(CoinURIConstants.COIN_API_PATH_HISTORICAL.getS())
                .addParameter(CoinURIConstants.COIN_ARGUMENT.getS(), CoinConstants.USDT.getS())
                .addParameter(CoinURIConstants.EXCHANGE_ARGUMENT.getS(), ExchangeConstants.EURO.getS())
                .addParameter(CoinURIConstants.MINUTES_BEFORE_NOW.getS(),
                        TimeConstants.LAST_EIGHT_HOURS_VALUES_PER_MINUTE.getS());
    }

    public static URIBuilder buildForecastURI() {
        return new URIBuilder()
                .setScheme(CoinURIConstants.HTTPS.getS())
                .setHost(TimeSeriesURIConstants.TIMESERIES_API_DOMAIN.getS())
                .setPath(TimeSeriesURIConstants.TIMESERIES_API_PATH_ANALYSIS.getS());
    }
}
