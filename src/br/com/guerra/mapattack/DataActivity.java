package br.com.guerra.mapattack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DataActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_data);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Intent intent = getIntent();
		double latitude = intent.getDoubleExtra("Lat", 0);
		double longitude = intent.getDoubleExtra("Lon", 0);
		
		Geocoder gcd = new Geocoder(this, Locale.getDefault());
		List<Address> addresses = new ArrayList<Address>();
		try {
			addresses = gcd.getFromLocation(latitude, longitude, 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(addresses.size() == 0){
			finish();
			
		}else{
			Address ad = addresses.get(0);
			TextView textView = (TextView) findViewById(R.id.textCountryName);
			textView.setText(ad.getCountryName());
			
			textView = (TextView) findViewById(R.id.textAdminArea);
			textView.setText(ad.getAdminArea());
			
			textView = (TextView) findViewById(R.id.textSubAdminArea);
			textView.setText(ad.getSubAdminArea());
			
			textView = (TextView) findViewById(R.id.textLocality);
			textView.setText(ad.getLocality());
			
			textView = (TextView) findViewById(R.id.textSubLocality);
			textView.setText(ad.getSubLocality());
			
			textView = (TextView) findViewById(R.id.textThoroughfare);
			textView.setText(ad.getThoroughfare());
			
			textView = (TextView) findViewById(R.id.textSubThoroughFare);
			textView.setText(ad.getSubThoroughfare());
			
		}
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.data, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
