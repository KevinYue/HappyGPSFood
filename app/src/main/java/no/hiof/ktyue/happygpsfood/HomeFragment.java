package no.hiof.ktyue.happygpsfood;


import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    //private static final String TAG = "HomeFragment";
    private Location location;
    private GoogleMap gMap;
    private View view;
    private MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View of the inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = view.findViewById(R.id.map);

        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
        else {
            Log.d(TAG, "error create a map");
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        //MapsInitializer.initialize(getContext());

        gMap = googleMap;

        gMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Position here");
        gMap.addMarker(new MarkerOptions().position(latLng).title("Position Here"));

        CameraPosition cameraPosition = CameraPosition.builder()
                .target(latLng)
                .zoom(16)
                .bearing(0)
                .tilt(45)
                .build();

        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, 15, 0, 0)));

    }
}
