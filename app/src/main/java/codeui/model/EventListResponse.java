package codeui.model;

import java.util.List;

/**
 * Created by previousdeveloper on 11.10.2015.
 */
public class EventListResponse {

    private List<EventResponse> item;

    public List<EventResponse> getItem() {
        return item;
    }

    public void setItem(List<EventResponse> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "EventListResponse{" +
                "item=" + item +
                '}';
    }
}
