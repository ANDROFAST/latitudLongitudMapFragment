package com.androidmorefast.pc.appcoordenadafragmentmap;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity
        implements GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    private GoogleMap mMap;
    private TextView mTapTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpMapIfNeeded();
        mTapTextView = (TextView) findViewById(R.id.tap_text);
    }

    private void setUpMap()
    {
        mMap.setOnMapClickListener(this);
        mMap.setOnMapLongClickListener(this);
    }

    @Override
    public void onMapClick(LatLng point) {
        mTapTextView.setText("Punto marcado=" + point);
    }

    @Override
    public void onMapLongClick(LatLng point) {
        mTapTextView.setText("Punto, presionado=" + point);
    }

    private void setUpMapIfNeeded() {
       // Hacer una comprobación nula para confirmar que ya no hemos instanciado el mapa.
        if (mMap == null) {
        // Intenta obtener el mapa desde el SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
           // Comprueba si hemos tenido éxito en la obtención del mapa.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

}
