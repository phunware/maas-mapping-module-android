package com.phunware.modules.mapping.sample

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.phunware.modules.mapping.sample.databinding.ActivityMainBinding
import com.phunware.modules.mapping.sample.util.MapNameProvider
import com.phunware.modules.mapping.sample.util.MapNameProvider.Companion.SINGLE_BUILDING_MAP_NAME
import com.phunware.smartmap.SmartMapActivity
import com.phunware.smartmap.util.MappingPermissionsHelper
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var buildingArray: Array<String>
    private lateinit var views: ActivityMainBinding
    private lateinit var selectedMapName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        views.startMapButton.setOnClickListener {
            val mapName = selectedMapName
            val intent = SmartMapActivity.SmartMapIntentBuilder(mapName).build(this@MainActivity)
            startActivity(intent)
        }

        views.shareLocationbutton.setOnClickListener {
            val mapName = selectedMapName
            val intent = SmartMapActivity.SmartMapIntentBuilder(mapName, SmartMapActivity.Mode.SHARE_LOCATION)
                .build(this@MainActivity)
            startActivity(intent)
        }

        views.sharedLocationDeeplinkbutton.setOnClickListener {
            val mapName = selectedMapName
            val intent =
                SmartMapActivity.SmartMapIntentBuilder(
                    mapName = mapName,
                    floorId = 207657,
                    // Front Lobby
                    lat = 33.02229802940561,
                    long = -117.08286857839228
                ).build(this)
            startActivity(intent)
        }

        buildingArray = resources.getStringArray(R.array.sample_buildings_array)
        views.buildingSelector.setOnItemClickListener { _, _, position, _ ->
            selectedMapName = MapNameProvider().getMapNameFromString(buildingArray[position])
            views.startMapButton.isEnabled = true
            views.shareLocationbutton.isEnabled = true
            views.sharedLocationDeeplinkbutton.isEnabled = selectedMapName == SINGLE_BUILDING_MAP_NAME
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        checkPermissions()
    }

    override fun onStart() {
        super.onStart()
        ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            buildingArray
        ).also {
            views.buildingSelector.setAdapter(it)
        }
    }

    private fun checkPermissions() {
        val supportsLocation = packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS)
        if (supportsLocation) {
            MappingPermissionsHelper.handleLocationPermissions(applicationContext, this) {
                // no-op
            }
        }
    }
}