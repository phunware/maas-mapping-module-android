package com.phunware.modules.mapping.sample.model

import com.google.gson.annotations.SerializedName
import com.phunware.smartmap.core.MapConfig
import com.phunware.smartmap.core.MapConfig.RouteSnappingTolerance

data class MapConfigResponse(
    @SerializedName("features")
    val features: Map<String, FeatureConfigResponse>?,
    @SerializedName("languages")
    val languages: List<LanguageConfigResponse>?,
    @SerializedName("mapSettings")
    val mapSettings: MapSettingsResponse?,
    @SerializedName("categories")
    val categories: List<PoiCategoryResponse>?,
    @SerializedName("otherCategory")
    val otherCategory: PoiCategoryResponse?,
    @SerializedName("routeUiConfig")
    val routeUiConfig: MapConfig.RouteUiConfig,
    @SerializedName("androidOffRouteConfig")
    val offRouteConfig: OffRouteConfigResponse?
) {
    data class FeatureConfigResponse(
        @SerializedName("roles")
        val roles: List<String>?,
        @SerializedName("config")
        val config: String?
    )

    data class LanguageConfigResponse(
        @SerializedName("code")
        val code: String?,
        @SerializedName("displayText")
        val displayText: String?,
        @SerializedName("stringsFile")
        val stringsFile: String?
    )

    data class MapSettingsResponse(
        @SerializedName("maps")
        val maps: List<MapDataResponse>?,
    )

    data class MapDataResponse(
        @SerializedName("mapName")
        val mapName: String?,
        @SerializedName("buildingConfigs")
        val buildingConfigs: List<BuildingConfigsResponse>?,
        @SerializedName("campusConfigs")
        val campusConfigs: List<CampusConfigResponse>?,
        @SerializedName("offCampusGeofenceMeters")
        val offCampusGeofenceMeters: Int?,
        @SerializedName("lat")
        val latitude: Double?,
        @SerializedName("long")
        val longitude: Double?,
        @SerializedName("androidInitialZoomLevel")
        val zoomLevel: Float?,
        @SerializedName("androidPOIZoomLevel")
        val poiZoomLevel: Float?,
        @SerializedName("routeSnappingTolerance")
        val routeSnappingTolerance: RouteSnappingTolerance = RouteSnappingTolerance.TOLERANCE_OFF,
        @SerializedName("enableHomeToVenue")
        val enableHomeToVenue: Boolean,
        @SerializedName("enableMeetingRoomStatus")
        val enableMeetingRoomStatus: Boolean,
        @SerializedName("meetingRoomStatusRefreshIntervalMilliSeconds")
        val meetingRoomStatusRefreshIntervalMilli: Long,
        @SerializedName("enableBlueDotLocation")
        val enableBlueDotLocation: Boolean,
        @SerializedName("enableAccessibleRoutesByDefault")
        val enableAccessibleRoutesByDefault: Boolean?
    )

    data class CampusConfigResponse(
        @SerializedName("campusID")
        val campusId: Int,
        @SerializedName("languageCode")
        val languageCode: String?,
        @SerializedName("onCampusGeozoneIds")
        val onCampusGeoZoneIds: List<Int>?
    )

    data class BuildingConfigsResponse(
        @SerializedName("buildingID")
        val buildingID: Int?,
        @SerializedName("languageCode")
        val languageCode: String?,
        @SerializedName("onCampusGeozoneIds")
        val onCampusGeoZoneIds: List<Int>?
    )

    data class PoiCategoryResponse(
        @SerializedName("title")
        val title: String?,
        @SerializedName("poiTypes")
        val poiTypes: List<String>?,
        @SerializedName("iconURL")
        val iconUrl: String?,
    )

    data class OffRouteConfigResponse(
        @SerializedName("minOffRouteDistanceThreshold")
        val minOffRouteDistanceThresholdMeters: Float,
        @SerializedName("maxOffRouteDistanceThreshold")
        val maxOffRouteDistanceThresholdMeters: Float,
        @SerializedName("offRouteTimeThresholdMilliseconds")
        val offRouteTimeThresholdMilliseconds: Int,
        @SerializedName("offRouteIdleTimeThresholdMilliseconds")
        val offRouteIdleTimeThresholdMilliseconds: Int?,
        @SerializedName("alertGracePeriodMilliSeconds")
        val alertGracePeriodMilliSeconds: Int,
    )
}

