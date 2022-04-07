import React from 'react';
import PredictBTC from "./components/predictBTC";
import './App.css';

const App = () => {
  return (
    <div>
      <div className='graph-container-btc'>
      <PredictBTC coin="btc" />
      </div>
      
      <div className='graph-container-eth'>
      <PredictBTC coin="eth" />
      </div>

      <div className='graph-container-usdt'>
      <PredictBTC coin="usdt" />
      </div>
    </div>
  )
};

export default App;
