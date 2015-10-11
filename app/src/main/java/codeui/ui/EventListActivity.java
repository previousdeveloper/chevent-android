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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_list);
        eventListView = (ListView) findViewById(R.id.event_listview);
        getEventList();

    }

    private void getEventList() {
        EventService eventService = new EventService();

        eventService.getEventList().getDetails(new Callback<EventListResponse>() {
            @Override
            public void success(EventListResponse eventResponse, Response response) {

                customPhotosAdapter = new EventListAdapter(getApplicationContext(),
                        R.layout.custom_eventlist_adapter, eventResponse.getItem());
                eventListView.setAdapter(customPhotosAdapter);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }
}
