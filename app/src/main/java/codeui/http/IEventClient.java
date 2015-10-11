package codeui.http;

import codeui.model.EventListResponse;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by previousdeveloper on 11.10.2015.
 */
public interface IEventClient {

    @GET("/")
    void getDetails(Callback<EventListResponse> response);
}
