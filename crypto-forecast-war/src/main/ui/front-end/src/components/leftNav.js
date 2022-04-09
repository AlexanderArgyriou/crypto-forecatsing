const LeftNav = (props) => {
    return (
        <div className="border-div">
            <img className="bot-marg images" src={props.name} alt="bitcoin-img"/>
            <select className="bot-marg block-disp">
                <option selected="">TimeSeries in minutes</option>
                <option>500</option>
                <option>1000</option>
                <option>2000</option>
            </select>

            <select className="bot-marg block-disp">
                <option selected="">Number of future points in minutes</option>
                <option>30</option>
                <option>60</option>
                <option>90</option>
            </select>
            <button className="block-disp">
                Run Prediction
            </button>
        </div>
    )
};

export default LeftNav;