package codeui.presenter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import codeui.http.EventService;
import codeui.model.EventListResponse;
import codeui.ui.EventListActivity;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by previousdeveloper on 12.10.2015.
 */

@Singleton
public class EventListPresenter {

    private EventListActivity mEventActivity;
    private EventService mEventService;


    @Inject
    public EventListPresenter(EventListActivity mEventActivity, EventService mEventService) {
        this.mEventActivity = mEventActivity;
        this.mEventService = mEventService;
    }

    public void getEventList() {


        mEventService.eventServiceAdapter()
                .getDetails()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EventListResponse>() {
                    @Override
                    public void onCompleted() {


                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(EventListResponse eventListResponse) {


                        mEventActivity.displayData(eventListResponse);


                    }
                });
    }

}
