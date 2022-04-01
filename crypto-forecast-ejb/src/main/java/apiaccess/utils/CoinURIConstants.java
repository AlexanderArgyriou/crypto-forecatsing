package apiaccess.utils;

public enum CoinURIConstants {
    HTTPS("https"),
    COIN_API_DOMAIN("min-api.cryptocompare.com"),
    COIN_API_PATH_HISTORICAL("/data/v2/histominute"),
    TIME_SERIES_API_KEY_HEADER("X-Time-Door-Key"),
    COIN_ARGUMENT("fsym"),
    EXCHANGE_ARGUMENT("tsym"),
    MINUTES_BEFORE_NOW("limit");

    String s;

    CoinURIConstants(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
