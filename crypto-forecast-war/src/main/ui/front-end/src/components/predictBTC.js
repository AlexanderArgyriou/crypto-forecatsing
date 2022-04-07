import React, { useEffect, useState } from 'react';
import {
        LineChart,
        Line,
        XAxis,
        YAxis,
        CartesianGrid,
        Tooltip,
        Legend,
        ResponsiveContainer
} from 'recharts';

const PredictBTC = (props) => {
        const numberOfPredictions = '20';
        const numberOfMinutesInPastTimeSeries = '2000';
        const apiUrlPredict = '/crypto-forecast-war-1/resources/predict/' + props.coin + '/' + numberOfMinutesInPastTimeSeries + '/' + numberOfPredictions;
        const apiUrlRealTimeValueForCoin = '/crypto-forecast-war-1/resources/timeseries/' + props.coin + '/1';
        const MINUTE_MS = 60000;
        const [data, setData] = useState([]);
        const refresh = parseInt(numberOfPredictions) * 60 * 1000 + 12000;

        useEffect(() => {
                setTimeout(() => {
                        const apiFetch = () => {
                                console.log("Calling Prediction API");
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
                        }
                        apiFetch();
                        const interval = setInterval(() => {
                                apiFetch();
                        }, refresh);
                        return () => clearInterval(interval);
                }, 0)
        }, [])

        useEffect(() => {
                const interval = setInterval(() => {
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
                }, MINUTE_MS);
                return () => clearInterval(interval);
        })

        return (
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
        )
};

export default PredictBTC;
