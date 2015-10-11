package codeui.model;

/**
 * Created by previousdeveloper on 11.10.2015.
 */
public class EventResponse {

    private String event_class;
    private String event_cost;
    private String event_cost_boolean;
    private String event_date;
    private String event_date_ddmmyyyy;
    private String event_image;
    private String event_name;
    private String event_url;

    public String getEvent_class() {
        return event_class;
    }

    public void setEvent_class(String event_class) {
        this.event_class = event_class;
    }

    public String getEvent_cost() {
        return event_cost;
    }

    public void setEvent_cost(String event_cost) {
        this.event_cost = event_cost;
    }

    public String getEvent_cost_boolean() {
        return event_cost_boolean;
    }

    public void setEvent_cost_boolean(String event_cost_boolean) {
        this.event_cost_boolean = event_cost_boolean;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_date_ddmmyyyy() {
        return event_date_ddmmyyyy;
    }

    public void setEvent_date_ddmmyyyy(String event_date_ddmmyyyy) {
        this.event_date_ddmmyyyy = event_date_ddmmyyyy;
    }

    public String getEvent_image() {
        return event_image;
    }

    public void setEvent_image(String event_image) {
        this.event_image = event_image;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getEvent_url() {
        return event_url;
    }

    public void setEvent_url(String event_url) {
        this.event_url = event_url;
    }

    @Override
    public String toString() {
        return "EventResponse{" +
                "event_class='" + event_class + '\'' +
                ", event_cost='" + event_cost + '\'' +
                ", event_cost_boolean='" + event_cost_boolean + '\'' +
                ", event_date='" + event_date + '\'' +
                ", event_date_ddmmyyyy='" + event_date_ddmmyyyy + '\'' +
                ", event_image='" + event_image + '\'' +
                ", event_name='" + event_name + '\'' +
                ", event_url='" + event_url + '\'' +
                '}';
    }
}
