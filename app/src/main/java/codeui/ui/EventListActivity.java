package codeui.ui;

import android.os.Bundle;
import android.widget.ListView;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

import codeui.adapter.EventListAdapter;
import codeui.chevent.R;
import codeui.helper.ProgressBarHandler;
import codeui.http.EventService;
import codeui.model.EventListResponse;
import codeui.model.EventResponse;
import codeui.presenter.EventListPresenter;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by previousdeveloper on 11.10.2015.
 */

@ContentView(R.layout.event_list)
public class EventListActivity extends RoboActivity {


    @InjectView(R.id.event_listview)
    ListView mEventListView;

    private EventListAdapter mCustomPhotosAdapter;

    @Inject
    private EventService mEventService;


    private EventListPresenter mEventListPresenter;

    @Inject
    private ProgressBarHandler mProgressBarHandler;

    private List<EventResponse> mEventResponse = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        mCustomPhotosAdapter = new EventListAdapter(getApplicationContext(),
                R.layout.custom_eventlist_adapter, mEventResponse);

        mEventListView.setAdapter(mCustomPhotosAdapter);


        mEventListPresenter = new EventListPresenter(this, mEventService);
        mProgressBarHandler.show();
        mEventListPresenter.getEventList();


    }

    public void displayData(EventListResponse eventListResponse) throws InterruptedException {

        mCustomPhotosAdapter.clear();
        mCustomPhotosAdapter.addAll(eventListResponse.getItem());
        mCustomPhotosAdapter.notifyDataSetInvalidated();

        mProgressBarHandler.hide();


    }


}
