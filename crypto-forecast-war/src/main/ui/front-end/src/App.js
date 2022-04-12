import Predict from "./components/predict";
import './App.css';
import "bootstrap/dist/css/bootstrap.css";

const App = () => {
  const time = new Date();
  time.setSeconds(time.getSeconds() + 600); // 10 minutes timer
  return (
    <div className="container-fluid">
      <div className='nav-bar-div rel-div'>
        <img className="img-header-left" src={require('./images/mine.png')} />
        {/* <img className="img-header-left" src={require('./images/mine.png')} />
        <img className="img-header-left" src={require('./images/mine.png')} /> */}
        <p className="title-header">DSS TimeSeries Forecasting</p>
        <img className="img-header-right" src={require('./images/mine.png')} />
        {/* <img className="img-header-right" src={require('./images/mine.png')} />
        <img className="img-header-right" src={require('./images/mine.png')} /> */}
      </div>
      <Predict coin="btc" name={require('./images/btc.png')} />
      <Predict coin="eth" name={require('./images/eth.png')} />
      <Predict coin="sol" name={require('./images/sol.png')} />
      <hr />
      <div className="footer-div">
        <img className="footer-img-left" src={require('./images/bit-cloud.png')} />
        <p className="small-p">(c) Alexandros Argyriou, all rights reserved.
          A master thesis approach on crypto time-series forecatsing.</p>
          <img className="footer-img-right" src={require('./images/bit-cloud.png')} />
      </div>
    </div>
  )
};

export default App;
