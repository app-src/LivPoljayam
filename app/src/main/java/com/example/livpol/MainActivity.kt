package com.example.livpol

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livpol.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mMap: GoogleMap
    private var allPoints: ArrayList<LatLng> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        binding.designBar.setOnClickListener {
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onMapReady(mMap: GoogleMap) {
        this.mMap = mMap
        val cameraPosition = CameraPosition.Builder()
            .target(
                LatLng(29.210496, 77.018802)
            )
            .zoom(15f)
            .bearing(90f)
            .tilt(40f)
            .build()
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        mMap.setOnMapClickListener {
            allPoints.add(it)
//            mMap.clear()
            mMap.addMarker(
                MarkerOptions()
                .position(it)
            )
        }
        mMap.setOnMarkerClickListener { marker ->
            startActivity(Intent(this, DataActivity::class.java))
            true
        }
    }

    override fun onBackPressed() {
        mMap.clear()
        super.onBackPressed()

    }
}