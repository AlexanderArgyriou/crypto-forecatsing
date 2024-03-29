package utils;

public enum TimeConstants {
    LAST_EIGHT_HOURS_VALUES_PER_MINUTE( "480" ),
    LAST_TEN_HOURS_VALUES_PER_MINUTE( "600" ),
    LAST_DAY_VALUES_PER_MINUTE( "1440" ),
    NOW( "0" );

    String s;

    TimeConstants(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
