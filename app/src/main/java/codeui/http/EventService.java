package codeui.http;

import retrofit.RestAdapter;

/**
 * Created by previousdeveloper on 11.10.2015.
 */
public class EventService {

    private IEventClient _eventClient;

    public final static String URL = "http://apifn.com/api/v1/events";

    public IEventClient eventServiceAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(URL)
                .build();
        _eventClient = restAdapter.create(IEventClient.class);


        return _eventClient;
    }

}
