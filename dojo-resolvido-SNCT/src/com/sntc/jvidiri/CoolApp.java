package com.sntc.jvidiri;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

/**
 * Aplicativo desenvolvido para DOJO na III semana nacional da ciência e
 * tecnologia.
 * 
 * objetivos: -Utilizar listviews do android, com custon adapter. -Monitorar a
 * localização atrávés de serviços do android. -Popular a listview com as novas
 * localizações.
 * 
 * @author jvidiri
 * 
 */
public class CoolApp extends Activity {

	ArrayList<Location> locations = new ArrayList<Location>(); // array com as
																// localizações
	LocationManager locationManager; // instacia do manager do sistema

	/**
	 * Função "construtor" para a Activity.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setando o layout utilizado pela activity
		setContentView(R.layout.activity_cool_app);

	}

	@Override
	protected void onStart() {
		super.onStart();
		// content adapter.
		final MyContentAdapter locationsAdapter = new MyContentAdapter(this,
				locations);
		// referenciando o listview criado no xml.
		final ListView listLocalizacao = (ListView) findViewById(R.id.list_localizacao);

		// Pegando instancia do location manager do sistema
		this.locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);

		// Escutando por mudanças na localização.
		LocationListener locationListener = new LocationListener() {
			/**
			 * Será chamado quando a localização mudar.
			 */
			public void onLocationChanged(Location location) {
				locationsAdapter.add(location);
				locationsAdapter.notifyDataSetChanged();
			}

			public void onStatusChanged(String provider, int status,
					Bundle extras) {
			}

			public void onProviderEnabled(String provider) {
			}

			public void onProviderDisabled(String provider) {
			}
		};
		// Registrando que estamos ouvindo pela localização.
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				1000, 5, locationListener);
		// setando adapter na lista.
		listLocalizacao.setAdapter(locationsAdapter);
	}

	/**
	 * 
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.cool_app, menu);
		return true;
	}

}
