package codeui.http;

import codeui.model.EventListResponse;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by previousdeveloper on 11.10.2015.
 */

public interface IEventClient {

    @GET("/")
    Observable<EventListResponse> getDetails();
}
