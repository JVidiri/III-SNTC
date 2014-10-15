package com.dojo;

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

	LocationManager locationManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dojo);
		
		// Pegando instancia do location manager do sistema
		this.locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 1000, new LocationListener() {
			
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
				
				TextView textView=(TextView)findViewById(R.id.textView1);
				textView.setText(location.getLatitude()+"");
				TextView textView2=(TextView)findViewById(R.id.textView2);
				textView2.setText(location.getLongitude()+"");
				
			}
		});
		Button botao=(Button)findViewById(R.id.button1);
		botao.setOnClickListener(new OnClickListener() {
		
			
			@Override
			public void onClick(View v) {
				String geoUri = "http://maps.google.com/maps?q=loc:"
						+((TextView)findViewById(R.id.textView1)).getText()+ ","
						+ ((TextView)findViewById(R.id.textView2)).getText() + " ( Pos. "
						+ 1 + ")";
				Intent intente= new Intent(Intent.ACTION_VIEW,Uri.parse(geoUri));
				
				v.getContext().startActivity(intente);
				
				
				
				
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
