package com.example.myapplication

import android.annotation.SuppressLint
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.myapplication.databinding.ActivityMapsBinding
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.CameraPosition
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    // 권한
    val permissions = arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION)
    val PERM_FLAG = 99

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(isPermitted()){
            // 권한 check
            startProcess()
        }else{
            // 권한 요청
            ActivityCompat.requestPermissions(this, permissions, PERM_FLAG)
        }

    }

    fun isPermitted(): Boolean{
        for(perm in permissions){
            if(ContextCompat.checkSelfPermission(this, perm) != PERMISSION_GRANTED){
                return false
            }
        }
        return true
    }

    fun startProcess(){
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        setupdateLocationListener()
    }

    // 내 위치 가져오기
    lateinit var fusedLocationClient: FusedLocationProviderClient
    lateinit var locationCallback: LocationCallback

    @SuppressLint("MissingPermission")
    fun setupdateLocationListener(){
        val locationRequest = LocationRequest.create()
        locationRequest.run {
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            interval = 1000
        }

        locationCallback = object : LocationCallback(){
            override fun onLocationResult(LocationResult: LocationResult?) {
                LocationResult?.let {
                    for((i, location) in it.locations.withIndex()){
                        Log.d("Location", "$i ${location.latitude}, ${location.longitude}")
                        setLastLocation(location)
                    }
                }
            }
        }

        // Location 요청 함수 호출출
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }

    fun setLastLocation(location: Location){
        val myLocation = LatLng(location.latitude, location.longitude)
        val marker = MarkerOptions()
            .position(myLocation)
            .title("here")

        val cameraOption = CameraPosition.Builder()
            .target(myLocation)
            .zoom(17.0f)
            .build()

        val camera = CameraUpdateFactory.newCameraPosition(cameraOption)

        mMap.clear() // 이전 마커 삭제

        mMap.addMarker(marker)
        mMap.moveCamera(camera)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            PERM_FLAG ->{
                var check = true
                for(grant in grantResults){
                    if(grant != PERMISSION_GRANTED){
                        check = false
                        break
                    }
                }
                if(check){
                    startProcess()
                }else{
                    Toast.makeText(this, "권한을 승인해야 합니다", Toast.LENGTH_LONG).show()
                    finish() // 종료
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

}