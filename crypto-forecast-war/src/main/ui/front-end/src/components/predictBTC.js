import React, { useEffect, useState } from 'react';
import {
        LineChart,
        Line,
        XAxis,
        YAxis,
        CartesianGrid,
        Tooltip,
        Legend,
} from 'recharts';

const PredictBTC = (coin) => {
        const apiUrl = '/crypto-forecast-war-1/resources/predict/' + coin;
        const [data, setData] = useState([]);

        useEffect(() => {
                setTimeout(() => {
                        const apiFetch = () => {
                                fetch(apiUrl).then((response) => {
                                        response.json().then((json) => {
                                                let dataTemp = [];
                                                let futureMin = 1;
                                                json.result.data.forecast.forEach((element) => {
                                                        let today = new Date();
                                                        let plus1Min = new Date(today);
                                                        plus1Min.setMinutes(today.getMinutes() + futureMin++);
                                                        let time = plus1Min.getHours() + ':' + plus1Min.getMinutes() + ':' + plus1Min.getSeconds();
                                                        dataTemp.push({ name: time, low: element.lower, high: element.upper, mean: element.mean });
                                                })
                                                setData(dataTemp);
                                        })
                                })
                        }
                        apiFetch();
                        const interval = setInterval(() => {
                                apiFetch();
                        }, 600000);
                        return () => clearInterval(interval);
                }, 0)
        }, [])
        return (
                <div>
                <LineChart
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
                        {/* <Line type="monotone" dataKey="pv" stroke="#82ca9d" /> */}
                </LineChart>
                </div>
        )
};

export default PredictBTC;
