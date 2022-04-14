package utils;

public enum CoinConstants {
    BTC( "BTC" ),
    ETH( "ETH" ),
    USDT( "USDT" ),
    SOL( "SOL" );

    String s;

    CoinConstants(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }
}
