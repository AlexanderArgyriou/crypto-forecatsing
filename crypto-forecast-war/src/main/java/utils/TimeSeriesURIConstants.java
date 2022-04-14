package utils;

public enum TimeSeriesURIConstants {
    TIMESERIES_API_DOMAIN( "api.timedoor.io" ),
    TIMESERIES_API_PATH_ANALYSIS( "/invocation/auto-arima" ),
    API_KEY( "api_key" );

    String s;

    TimeSeriesURIConstants(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
