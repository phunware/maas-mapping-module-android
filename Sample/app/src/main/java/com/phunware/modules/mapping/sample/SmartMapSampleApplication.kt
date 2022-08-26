package com.phunware.modules.mapping.sample

import android.app.Application
import com.phunware.smartmap.provider.MapConfigurationProvider
import com.phunware.smartmap.provider.MapsStringProvider
import com.phunware.smartmap.provider.MeetingRoomStatusProvider

class SmartMapSampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MapsStringProvider.setInstance(DefaultStringProvider)
        MyMapConfigurationProvider(this).also { provider ->
            require(provider.mapConfig.mapSettings.maps.any { mapData ->
                val hasValidBuildingId = mapData.buildingConfigs.firstOrNull { it.buildingID > 0 } != null
                val hasValidCampusId = mapData.campusConfigs.firstOrNull { it.campusId > 0 } != null
                hasValidBuildingId || hasValidCampusId
            }) {
                "A building Id or campus Id is required but missing. Please update `mapconfig.json` with a valid building Id or campus Id."
            }
            MapConfigurationProvider.setInstance(provider)
        }
        MeetingRoomStatusProvider.setInstance(DummyMeetingRoomStatusProvider)
    }
}