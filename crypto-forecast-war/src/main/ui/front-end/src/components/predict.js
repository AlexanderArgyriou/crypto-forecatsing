import React, { useEffect, useState, useRef } from 'react';
import "bootstrap/dist/css/bootstrap.css";
import '../App.css';

import {
        LineChart,
        Line,
        XAxis,
        YAxis,
        CartesianGrid,
        Tooltip,
        Legend,
} from 'recharts';


const Predict = (props) => {
        let numberOfPredictions = '10';
        let numberOfMinutesInPastTimeSeries = '100';
        let apiUrlPredict = '/crypto-forecast-war-1/resources/predict/' + props.coin + '/' + numberOfMinutesInPastTimeSeries + '/' + numberOfPredictions;
        const exportURL = '/crypto-forecast-war-1/resources/export';
        const saveURL = '/crypto-forecast-war-1/resources/save';
        const fileName = 'export';
        const apiUrlRealTimeValueForCoin = '/crypto-forecast-war-1/resources/timeseries/' + props.coin + '/1';
        const MINUTE_MS = 60000;
        const [data, setData] = useState([]);
        const [fetchPredictionInterval, setFetchPredictionInterval] = useState(null);
        const refresh = parseInt(numberOfPredictions) * MINUTE_MS + (2 * MINUTE_MS);

        const saveDataInDB = () => {
                fetch(saveURL, {
                        method: 'PUT',
                        headers: {
                                'content-type': 'application/json',
                        },
                        body: JSON.stringify(data)
                })
        }

        const exportData = () => {
                fetch(exportURL, {
                        method: 'POST',
                        headers: {
                                'Content-Type': 'application/json',
                                'Accept': '*/*'
                        },
                        body: JSON.stringify(data)
                }).then((response) => (response.blob()))
                        .then((blob) => {
                                var a = document.createElement("a");
                                a.href = URL.createObjectURL(blob);
                                a.setAttribute("download", fileName);
                                a.click();
                        })
        }

        function changeTimeSeries(event) {
                if (!isNaN(event.target.value)) {
                        numberOfMinutesInPastTimeSeries = event.target.value;
                        apiUrlPredict = '/crypto-forecast-war-1/resources/predict/' + props.coin + '/' + numberOfMinutesInPastTimeSeries + '/' + numberOfPredictions;
                        console.log(numberOfMinutesInPastTimeSeries);
                        console.log(apiUrlPredict);
                }
        }

        function changePredictions(event) {
                if (!isNaN(event.target.value)) {
                        numberOfPredictions = event.target.value;
                        apiUrlPredict = '/crypto-forecast-war-1/resources/predict/' + props.coin + '/' + numberOfMinutesInPastTimeSeries + '/' + numberOfPredictions;
                        console.log(numberOfPredictions);
                        console.log(apiUrlPredict);
                }
        }

        const stop = () => {
                if (fetchPredictionInterval != null) {
                        clearInterval(fetchPredictionInterval);
                }
                setData([]);
        }

        const start = () => {
                console.log("Calling Prediction API " + apiUrlPredict);
                if (data.length > 0) {
                        saveDataInDB();
                }
                stop();
                fetch(apiUrlPredict).then((response) => {
                        response.json().then((json) => {
                                let dataTemp = [];
                                let futureMin = 1;
                                json.result.data.forecast.forEach((element) => {
                                        let today = new Date();
                                        let plus1Min = new Date(today);
                                        plus1Min.setMinutes(today.getMinutes() + futureMin++);
                                        let time = plus1Min.getHours() + ':' + plus1Min.getMinutes();
                                        dataTemp.push({ name: time, low: element.lower, high: element.upper, mean: element.mean, real: null });
                                })
                                setData(dataTemp);
                        })
                })
                apiFetch();
        }

        const apiFetch = () => {
                setFetchPredictionInterval(setInterval(() => {
                        console.log("Calling Prediction API " + apiUrlPredict);
                        fetch(apiUrlPredict).then((response) => {
                                response.json().then((json) => {
                                        let dataTemp = [];
                                        let futureMin = 1;
                                        json.result.data.forecast.forEach((element) => {
                                                let today = new Date();
                                                let plus1Min = new Date(today);
                                                plus1Min.setMinutes(today.getMinutes() + futureMin++);
                                                let time = plus1Min.getHours() + ':' + plus1Min.getMinutes();
                                                dataTemp.push({ name: time, low: element.lower, high: element.upper, mean: element.mean, real: null });
                                        })
                                        setData(dataTemp);
                                })
                        })
                }, refresh));
                return () => clearInterval(fetchPredictionInterval);
        }

        const minuteApiFetch = () => {
                console.log("Calling Minute/value API");
                fetch(apiUrlRealTimeValueForCoin).then((response) => {
                        response.json().then((json) => {
                                let valueNow;
                                json.Data.Data.forEach((element) => {
                                        valueNow = element.close;
                                })
                                console.log(valueNow);

                                for (const element of data) {
                                        if (element.real == null) {
                                                element.real = valueNow;
                                                let tempArray = [];
                                                tempArray.push(...data);
                                                setData(tempArray);
                                                break;
                                        }
                                }
                                console.log(json);
                        })
                })
        }

        useEffect(() => {
                const interval = setInterval(() => {
                        minuteApiFetch();
                }, MINUTE_MS)
                return () => clearInterval(interval);
        })

        return (
                <div className='main-container'>
                        <hr />
                        <div className='graph-container'>
                                <div className='block-disp'>
                                        <div className="border-div">
                                                <div>
                                                        <img className="bot-marg images" src={props.name} alt="bitcoin-img" />
                                                </div>
                                                <div>
                                                        <select className="bot-marg form-select form-select-sm mb-3" aria-label=".form-select-sm example"
                                                                onChange={changeTimeSeries}>
                                                                <option selected="">past timeseries/minutes</option>
                                                                <option>100</option>
                                                                <option>500</option>
                                                                <option>1000</option>
                                                                <option>2000</option>
                                                        </select>
                                                </div>
                                                <div>
                                                        <select className="bot-marg form-select form-select-sm mb-3" aria-label=".form-select-sm example"
                                                                onChange={changePredictions}>
                                                                <option selected="">number of predictions/minutes</option>
                                                                <option>10</option>
                                                                <option>30</option>
                                                                <option>60</option>
                                                                <option>90</option>
                                                        </select>
                                                </div>
                                                <div>
                                                        <button className='btn2' onClick={start}>
                                                                Run/Rerun
                                                        </button>
                                                        <button className='button-left-marg btn2' onClick={stop}>
                                                                Stop
                                                        </button>
                                                        <button className='button-left-marg btn2' onClick={exportData}>
                                                                Export
                                                        </button>
                                                </div>
                                        </div>
                                </div>
                                <div>
                                        <LineChart
                                                // width={1300}
                                                // height={300}
                                                width={1300}
                                                height={300}
                                                data={data}
                                                margin={{
                                                        top: 5,
                                                        right: 30,
                                                        left: 20,
                                                        bottom: 5
                                                }}
                                        >
                                                <CartesianGrid strokeDasharray="5 5" />
                                                <XAxis dataKey="name" />
                                                <YAxis type="number" domain={['dataMin', 'dataMax']} />
                                                <Tooltip />
                                                <Legend />
                                                <Line
                                                        type="monotone"
                                                        dataKey="low"
                                                        stroke="#000000"
                                                // activeDot={{ r: 8 }}
                                                />
                                                <Line
                                                        type="monotone"
                                                        dataKey="mean"
                                                        stroke="#8884d8"
                                                        activeDot={{ r: 8 }}
                                                />
                                                <Line
                                                        type="monotone"
                                                        dataKey="high"
                                                        stroke="#ff0000"
                                                // activeDot={{ r: 8 }}
                                                />
                                                <Line
                                                        type="monotone"
                                                        dataKey="real"
                                                        stroke="#228B22"
                                                // activeDot={{ r: 8 }}
                                                />
                                                {/* <Line type="monotone" dataKey="pv" stroke="#82ca9d" /> */}
                                        </LineChart>
                                        <p className='info-div'><b>Y [value : euro] / X [time : minutes]</b></p>
                                </div>
                        </div >
                </div>
        )
};

export default Predict;
