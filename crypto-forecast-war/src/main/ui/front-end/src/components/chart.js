import TradingViewWidget from "react-tradingview-widget"

const Chart = () => {
  return (
    <div className="App">
      <div style={{ height: 500 }}>
        <
          TradingViewWidget symbol="COINBASE:BTCEUR"
          interval="1"
          timezone="Europe/Athens"
          theme="Light"
          style="3"
          locale="us"
          toolbar_bg="#f1f3f6"
          hide_top_toolbar={true}
          hide_legend={true}
          save_image={false}
          watchlist={
            [
              "COINBASE:BTCEUR",
              "COINBASE:USDTEUR",
              "COINBASE:ETHEUR"
            ]
          }
          autosize
        />
      </div>
    </div>
  )
};

export default Chart;
