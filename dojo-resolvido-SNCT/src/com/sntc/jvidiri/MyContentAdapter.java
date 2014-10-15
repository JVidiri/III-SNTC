package com.sntc.jvidiri;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyContentAdapter extends ArrayAdapter<Location> {

	private final Context context;
	private final List<Location> values;

	public MyContentAdapter(Context context, List<Location> values) {
		super(context, R.layout.lat_long_item, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.lat_long_item, parent, false);
		TextView lat = (TextView) rowView.findViewById(R.id.lat_cont);
		TextView longi = (TextView) rowView.findViewById(R.id.long_cont);
		if (position % 2 == 0) {
			rowView.setBackgroundColor(Color.LTGRAY);
		} else {
			rowView.setBackgroundColor(Color.WHITE);
		}
		lat.setText(String.format("%.4f", values.get(position).getLatitude()));
		longi.setText(String
				.format("%.4f", values.get(position).getLongitude()));
		rowView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String geoUri = "http://maps.google.com/maps?q=loc:"
						+ values.get(position).getLatitude() + ","
						+ values.get(position).getLongitude() + " ( Pos. "
						+ position + ")";
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
						Uri.parse(geoUri));
				v.getContext().startActivity(intent);
			}
		});
		return rowView;
	}
}
