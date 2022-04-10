import Predict from "./components/predict";
import './App.css';

const App = () => {
  const time = new Date();
  time.setSeconds(time.getSeconds() + 600); // 10 minutes timer
  return (
    <div>
      <div className='nav-bar-div'>
        <p>DSS TimeSeries Forecasting test nav HEADER</p>
      </div>
      <Predict coin="btc" name={require('./images/btc.png')} />
      <Predict coin="eth" name={require('./images/eth.png')} />
      <Predict coin="sol" name={require('./images/sol.png')} />
      <hr />
      <div className="footer-div">
        <p>DSS TimeSeries Forecasting test nav FOOTER</p>
      </div>
    </div>
  )
};

export default App;
