package json.timeseries.beans;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import json.deserializer.TimeSeriesDeserializer;
import json.serializer.TimeSeriesSerializer;
import json.timeseries.TimeSeriesComponent;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("timeSeries")
@JsonDeserialize(using = TimeSeriesDeserializer.class)
@JsonSerialize(using = TimeSeriesSerializer.class)
public class TimeSeries {
    private final List<TimeSeriesComponent> timeSeriesList = new ArrayList<>();
    int predictionsNum = 10;

    public List<TimeSeriesComponent> getTimeSeriesList() {
        return timeSeriesList;
    }

    public void addValue(TimeSeriesComponent timeSeriesComponent) {
        timeSeriesList.add( timeSeriesComponent );
    }

    public int getPredictionsNum() {
        return predictionsNum;
    }

    public void setPredictionsNum(int predictionsNum) {
        if ( predictionsNum > 10 ) {
            this.predictionsNum = predictionsNum;
        }
    }
}
