package com.phunware.modules.mapping.sample

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.phunware.modules.mapping.sample.model.MapConfigResponse
import com.phunware.smartmap.core.LocalizedString
import com.phunware.smartmap.core.MapConfig
import com.phunware.smartmap.provider.BUILDING_CONFIG_BUILDING_ID_DEFAULT
import com.phunware.smartmap.provider.MAP_STRING_KEY_BOTTOM_VIEW_TITLE
import com.phunware.smartmap.provider.MapConfigurationProvider
import com.phunware.smartmap.util.readFile
import timber.log.Timber

/**
 * Implementation of [MapConfigurationProvider].
 * @param context [Context] used to access resources such as dimensions
 */
class MyMapConfigurationProvider(private val context: Context) : MapConfigurationProvider() {

    init {
        val config = readFile(context, R.raw.mapconfig)
        parseConfig(config)
    }

    private fun parseConfig(config: String) {
        val gson: Gson = GsonBuilder().create()
        try {
            val mapConfigResponse = gson.fromJson(config, MapConfigResponse::class.java)
            val features = mutableMapOf<String, MapConfig.FeatureConfig>()
            mapConfigResponse.features?.forEach { featureConfigResponse ->
                val featureConfig = MapConfig.FeatureConfig(
                    roles = featureConfigResponse.value.roles.orEmpty(),
                    config = featureConfigResponse.value.config.orEmpty()
                )
                features[featureConfigResponse.key] = featureConfig
            }

            val languages = mutableListOf<MapConfig.LanguageConfig>()
            mapConfigResponse.languages?.forEach { languageConfigResponse ->
                val newConfig = MapConfig.LanguageConfig(
                    code = languageConfigResponse.code.orEmpty(),
                    displayText = languageConfigResponse.displayText.orEmpty(),
                    stringsFile = languageConfigResponse.stringsFile.orEmpty()
                )
                languages.add(newConfig)
            }

            val maps = mutableListOf<MapConfig.MapData>()
            mapConfigResponse.mapSettings?.maps?.forEach { mapDataResponse ->

                val buildingConfigsList = mutableListOf<MapConfig.BuildingConfigs>()
                val campusConfigsList = mutableListOf<MapConfig.CampusConfigs>()
                if (mapDataResponse.campusConfigs != null && mapDataResponse.campusConfigs.isNotEmpty()) {
                    mapDataResponse.campusConfigs.forEach { campusConfigResponse ->
                        val newCampusConfig = MapConfig.CampusConfigs(
                            campusId = campusConfigResponse.campusId,
                            languageCode = campusConfigResponse.languageCode.orEmpty(),
                            onCampusGeoZoneIds = campusConfigResponse.onCampusGeoZoneIds.orEmpty()
                        )
                        campusConfigsList.add(newCampusConfig)
                    }
                } else {
                    mapDataResponse.buildingConfigs?.forEach { buildingConfigsResponse ->
                        val newBuildingConfigs = MapConfig.BuildingConfigs(
                            buildingID = buildingConfigsResponse.buildingID ?: BUILDING_CONFIG_BUILDING_ID_DEFAULT,
                            languageCode = buildingConfigsResponse.languageCode.orEmpty(),
                            onCampusGeoZoneIds = buildingConfigsResponse.onCampusGeoZoneIds.orEmpty()
                        )
                        buildingConfigsList.add(newBuildingConfigs)
                    }
                }

                val newMap = MapConfig.MapData(
                    mapName = mapDataResponse.mapName.orEmpty(),
                    buildingConfigs = buildingConfigsList,
                    campusConfigs = campusConfigsList,
                    offCampusGeofenceMeters = mapDataResponse.offCampusGeofenceMeters ?: 0,
                    latitude = mapDataResponse.latitude ?: 0.0,
                    longitude = mapDataResponse.longitude ?: 0.0,
                    zoomLevel = mapDataResponse.zoomLevel ?: 0.0f,
                    poiZoomLevel = mapDataResponse.poiZoomLevel ?: 0.0f,
                    routeSnappingTolerance = mapDataResponse.routeSnappingTolerance,
                    enableHomeToVenue = mapDataResponse.enableHomeToVenue,
                    enableMeetingRoomStatus = mapDataResponse.enableMeetingRoomStatus,
                    meetingRoomStatusRefreshIntervalMilli = mapDataResponse.meetingRoomStatusRefreshIntervalMilli,
                    enableBlueDotLocation = mapDataResponse.enableBlueDotLocation,
                    enableAccessibleRoutesByDefault = mapDataResponse.enableAccessibleRoutesByDefault ?: true
                )
                maps.add(newMap)
            }
            val mapSettings = MapConfig.MapSettings(maps)

            val categories = mutableListOf<MapConfig.PoiCategory>()
            mapConfigResponse.categories?.forEach { poiCategoryResponse ->
                val newConfig = MapConfig.PoiCategory(
                    title = LocalizedString(poiCategoryResponse.title.orEmpty()),
                    poiTypes = poiCategoryResponse.poiTypes.orEmpty(),
                    iconUrl = poiCategoryResponse.iconUrl.orEmpty()
                )
                categories.add(newConfig)
            }

            val otherCategory = MapConfig.PoiCategory(
                title = LocalizedString(mapConfigResponse.otherCategory?.title.orEmpty()),
                poiTypes = emptyList(),
                iconUrl = mapConfigResponse.otherCategory?.iconUrl.orEmpty()
            )

            val routeUiConfig = MapConfig.RouteUiConfig(
                maneuverColor = R.color.cod_gray,
                maneuverDirectionColor = R.color.ocean_green,
                routeColor = R.color.fun_green,
                maneuverStrokeWidth = mapConfigResponse.routeUiConfig.maneuverStrokeWidth,
                maneuverDirectionStrokeWidth = mapConfigResponse.routeUiConfig.maneuverDirectionStrokeWidth,
                routeStrokeWidth = mapConfigResponse.routeUiConfig.routeStrokeWidth
            )

            val offRouteConfig = mapConfigResponse.offRouteConfig?.let {
                MapConfig.OffRouteConfig(
                    minOffRouteDistanceThresholdMeters = it.minOffRouteDistanceThresholdMeters,
                    maxOffRouteDistanceThresholdMeters = it.maxOffRouteDistanceThresholdMeters,
                    offRouteTimeThresholdMilliseconds = it.offRouteTimeThresholdMilliseconds,
                    offRouteIdleTimeThresholdMilliseconds = it.offRouteIdleTimeThresholdMilliseconds ?: 0,
                    alertGracePeriodMilliSeconds = it.alertGracePeriodMilliSeconds
                )
            }

            mapConfig = MapConfig(
                features = features,
                languages = languages,
                mapSettings = mapSettings,
                categories = categories,
                otherCategory = otherCategory,
                routeUiConfig = routeUiConfig,
                offRouteConfig = offRouteConfig
            )

        } catch (jse: JsonSyntaxException) {
            Timber.e(jse)
        }
    }

    override fun loadLanguageStringsFile(stringsFile: String): Map<String, String> =
        when (stringsFile) {
            "strings_localization_es" ->
                mapOf(
                    MAP_STRING_KEY_BOTTOM_VIEW_TITLE to "Estoy buscando...",
                )
            "strings_localization_en" ->
                mapOf(
                    MAP_STRING_KEY_BOTTOM_VIEW_TITLE to "I'm Looking For…",
                )
            else -> emptyMap()
        }
}
