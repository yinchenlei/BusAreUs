package ca.ubc.cs.cpsc210.translink.providers;

import ca.ubc.cs.cpsc210.translink.auth.TranslinkToken;
import ca.ubc.cs.cpsc210.translink.model.Stop;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Wrapper for Translink Arrival Data Provider
 */
public class HttpArrivalDataProvider extends AbstractHttpDataProvider {
    private Stop stop;

    public HttpArrivalDataProvider(Stop stop) {
        super();
        this.stop = stop;
    }

    @Override
    /**
     * Produces URL used to query Translink web service for expected arrivals at
     * the stop specified in call to constructor.
     *
     * @returns URL to query Translink web service for arrival data
     */
    protected URL getUrl() throws MalformedURLException {
        return new URL("http://b210.herokuapp.com/rttiapi/v1/stops/" + Integer.toString(stop.getNumber()) + "/estimates?apikey=AyFlSt5B2KvfV53nELMX");
        //return new URL( "https://rtdsapi.translink.ca/rtdsapi/v1/LiveDataTimestampUtc?apikey=" + TranslinkToken.TRANSLINK_API_KEY);
    }

    @Override
    public byte[] dataSourceToBytes() throws IOException {
        return new byte[0];
    }
}
