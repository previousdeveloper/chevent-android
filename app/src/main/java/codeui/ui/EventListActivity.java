package codeui.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import codeui.adapter.EventListAdapter;
import codeui.chevent.R;
import codeui.http.EventService;
import codeui.model.EventListResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by previousdeveloper on 11.10.2015.
 */

public class EventListActivity extends AppCompatActivity {

    private ListView eventListView;
    private EventListAdapter customPhotosAdapter;
    private EventListResponse eventListResponse = new EventListResponse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);

        getEventList();
        eventListView = (ListView) findViewById(R.id.event_listview);

    }

    private void getEventList() {
        EventService eventService = new EventService();

        eventService.eventServiceAdapter().getDetails(new Callback<EventListResponse>() {
            @Override
            public void success(EventListResponse eventResponse, Response response) {

                eventListResponse.setItem(eventResponse.getItem());

                customPhotosAdapter = new EventListAdapter(getApplicationContext(),
                        R.layout.custom_eventlist_adapter, eventListResponse.getItem());

                eventListView.setAdapter(customPhotosAdapter);


            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
