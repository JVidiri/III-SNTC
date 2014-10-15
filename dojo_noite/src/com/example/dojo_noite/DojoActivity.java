package com.example.dojo_noite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DojoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dojo);
		LocationManager location = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);	
		LocationListener listener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				
				TextView latitude = (TextView) findViewById(R.id.txt_Lat);
				latitude.setText(location.getLatitude()+"");
				TextView longitude = (TextView) findViewById(R.id.txt_Longi);
				longitude.setText(location.getLongitude()+"");
			}
		};
		location.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				1000, 5, listener);
		Button btn_mapa =(Button) findViewById(R.id.btn_mapa);
		btn_mapa.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String geoUri = "http://maps.google.com/maps?q=loc:"
						+ ((TextView) findViewById(R.id.txt_Lat)).getText() + ","
						+ ((TextView) findViewById(R.id.txt_Longi)).getText()+ " ( Pos. "
						+ 1 + ")";
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
						Uri.parse(geoUri));
				v.getContext().startActivity(intent);
			}
			
		});
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dojo, menu);
		return true;
	}

}
