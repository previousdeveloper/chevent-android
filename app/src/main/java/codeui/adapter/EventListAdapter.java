package codeui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.inject.Singleton;
import com.joanzapata.android.iconify.Iconify;
import com.squareup.picasso.Picasso;

import java.util.List;

import codeui.chevent.R;
import codeui.model.EventResponse;

/**
 * Created by previousdeveloper on 11.10.2015.
 */

/**
 * Updated by coskudemirhan on 11.10.2015.
 */

@Singleton
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

        View view = inflater.inflate(R.layout.custom_eventlist_adapter, parent, false);


        photoHolder = new PhotoHolder();

        photoHolder.imageIcon = (ImageView) view.findViewById(R.id.event_image);
        photoHolder.resource = (TextView) view.findViewById(R.id.event_title);
        photoHolder.eventTime = (TextView) view.findViewById(R.id.event_time_txtView);
        photoHolder.eventPrice = (TextView) view.findViewById(R.id.event_price_txtView);
        photoHolder.eventDetailsBtn = (TextView) view.findViewById(R.id.event_details_textView);

        Iconify.setIcon((TextView) view.findViewById(R.id.event_time_txtView), Iconify.IconValue.fa_clock_o);
        Iconify.setIcon((TextView) view.findViewById(R.id.event_price_txtView), Iconify.IconValue.fa_try);

        String url = events.get(position).getEvent_image();
        photoHolder.resource.setText(events.get(position).getEvent_name());
        photoHolder.eventTime.append(" " + events.get(position).getEvent_date());
        photoHolder.eventPrice.append(" " + events.get(position).getEvent_cost());

        String detailUrl = events.get(position).getEvent_url();

        if (!detailUrl.startsWith("http://") && !detailUrl.startsWith("https://")) {
            photoHolder.eventDetailsBtn.setVisibility(View.INVISIBLE);
        } else {
            photoHolder.eventDetailsBtn.setOnClickListener(new OpenBrowserClick((String) detailUrl) {
                @Override
                public void onClick(View v) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(this.url)).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(browser);
                }
            });
        }

        if (url != null) {

            Picasso
                    .with(context)
                    .load(url)
                    .into(photoHolder.imageIcon);
        }

        return view;
    }


    static class PhotoHolder {
        ImageView imageIcon;
        TextView resource;
        TextView eventTime;
        TextView eventPrice;
        TextView eventDetailsBtn;
    }

    public class OpenBrowserClick implements View.OnClickListener {
        String url;

        public OpenBrowserClick(String url) {
            this.url = url;
        }

        @Override
        public void onClick(View v) {

        }
    }
}
