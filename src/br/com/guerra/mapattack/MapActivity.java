package br.com.guerra.mapattack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class MapActivity extends FragmentActivity implements OnMapClickListener{
	
	private GoogleMap map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		android.support.v4.app.FragmentManager myFragmentManager = getSupportFragmentManager();
		SupportMapFragment mySupportMapFragment = (SupportMapFragment)myFragmentManager.findFragmentById(R.id.mapFragment);
		map = mySupportMapFragment.getMap();
		
		map.setOnMapClickListener(this);
//		Marker marker = map.addMarker(new MarkerOptions()
//										.position(new LatLng(-22.952861,-43.192247))
//										.title("Teste"));
//		map.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.getPosition(), 10));
//		
//		Intent intent= new Intent(this, DataActivity.class);
//		intent.putExtra("Lat", -22.952861);
//		intent.putExtra("Lon", -43.192247);
//		startActivity(intent);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	@Override
	public void onMapClick(LatLng latLng) {
		Toast.makeText(this, latLng.toString(), Toast.LENGTH_SHORT).show();
		Intent intent= new Intent(this, DataActivity.class);
		intent.putExtra("Lat", latLng.latitude);
		intent.putExtra("Lon", latLng.longitude);
		startActivity(intent);
	}

}
