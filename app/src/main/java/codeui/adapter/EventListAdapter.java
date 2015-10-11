package codeui.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import codeui.chevent.R;
import codeui.model.EventResponse;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by previousdeveloper on 11.10.2015.
 */

public class EventListAdapter extends ArrayAdapter<EventResponse> {

    private List<EventResponse> events;
    private Context context;
    int layoutResId;

    public EventListAdapter(Context context, int layoutResId, List<EventResponse> events) {
        super(context, layoutResId, events);
        this.context = context;
        this.events = events;
        this.layoutResId = layoutResId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PhotoHolder photoHolder = null;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        @SuppressLint("ViewHolder") View view = inflater.inflate(R.layout.custom_eventlist_adapter, parent, false);


        photoHolder = new PhotoHolder();

        photoHolder.imageIcon = (CircleImageView) view.findViewById(R.id.event_image);
        photoHolder.resource = (TextView) view.findViewById(R.id.event_title);
        photoHolder.eventTime = (TextView) view.findViewById(R.id.event_time_txtView);

        String url = events.get(position).getEvent_image();
        photoHolder.resource.setText(events.get(position).getEvent_name());
        photoHolder.eventTime.setText(events.get(position).getEvent_date());

        if (url != null) {

            Picasso
                    .with(context)
                    .load(url)
                    .into(photoHolder.imageIcon);
        }

        return view;
    }


    static class PhotoHolder {
        CircleImageView imageIcon;
        TextView resource;
        TextView eventTime;
    }
}
