package com.phunware.modules.mapping.sample

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.phunware.modules.mapping.sample.databinding.ActivityMainBinding
import com.phunware.modules.mapping.sample.util.MapNameProvider
import com.phunware.modules.mapping.sample.util.MapNameProvider.Companion.SINGLE_BUILDING_MAP_NAME
import com.phunware.permissions.Permissions
import com.phunware.permissions.fragment.PermissionFragment
import com.phunware.permissions.util.getPermissions
import com.phunware.smartmap.SmartMapActivity
import timber.log.Timber

private const val TAG_PERMISSION_FRAGMENT = "TAG_PERMISSION_FRAGMENT"

class MainActivity : AppCompatActivity(), PermissionFragment.Listener {
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
            val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                listOf(
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } else {
                listOf(
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            }
            if (Permissions.checkPermissions(this, permissions)) {
                Toast.makeText(this, getString(R.string.location_permission_granted), Toast.LENGTH_SHORT).show()
            } else {
                val builder = PermissionFragment.Builder(
                    permissions = permissions,
                    iconRes = com.phunware.permissions.R.drawable.ic_location_dialog,
                    title = getString(R.string.location_permission_title),
                    text = getString(R.string.location_permission_html),
                    okLabel = getString(android.R.string.ok),
                ).apply {
                    noLabel = getString(R.string.location_permission_no)
                    isFullscreen = true
                }

                getPermissions(builder) { permissionResults ->
                    permissionResults.forEach { (permission, granted) ->
                        Timber.d("$permission " + if (granted) "granted" else "denied")
                    }
                    if (permissionResults.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false)) {
                        Toast.makeText(this, getString(R.string.location_permission_granted), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onPermissionResult(permission: String, granted: Boolean) {
        // remove the fragment instance once done attempting to request a permission
        // pop it off the backstack
        supportFragmentManager.popBackStack(
            TAG_PERMISSION_FRAGMENT,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )

        val msg = if (granted)
            getString(R.string.location_permission_granted)
        else
            getString(R.string.location_permission_denied)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}