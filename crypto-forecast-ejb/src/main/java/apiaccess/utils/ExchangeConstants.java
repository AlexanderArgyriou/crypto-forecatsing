package apiaccess.utils;

public enum ExchangeConstants {
    EURO("EUR"),
    DOLLAR("USD");

    String s;

    ExchangeConstants(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
