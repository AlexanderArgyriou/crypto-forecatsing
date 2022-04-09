import Predict from "./components/predict";
import './App.css';
import LeftNav from "./components/leftNav";

const App = () => {
  return (
    <div>
      <div className='nav-bar-div'>
        <p>DSS TimeSeries Forecasting test nav</p>
      </div>

      <div className='graph-container-btc'>
        <div className='inline-div'>
          <LeftNav name={require('./images/btc.png')} />
        </div>
        <div>
          <Predict coin="btc" />
        </div>
      </div>

      <div className='graph-container-btc'>
        <div className='inline-div'>
          <LeftNav name={require('./images/eth.png')} />
        </div>
        <div>
          <Predict coin="eth" />
        </div>
      </div>

      <div className='graph-container-btc'>
        <div className='inline-div'>
          <LeftNav name={require('./images/sol.png')} />
        </div>
        <div>
          <Predict coin="sol" />
        </div>
      </div>
    </div>
  )
};

export default App;
