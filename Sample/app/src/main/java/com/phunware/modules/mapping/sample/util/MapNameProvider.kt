package com.phunware.modules.mapping.sample.util

private const val SINGLE_BUILDING_DISPLAY_NAME = "Single Building Display Name"
private const val MULTI_BUILDING_DISPLAY_NAME = "Multi-Building Display Name"

class MapNameProvider {

    companion object {
        const val SINGLE_BUILDING_MAP_NAME = "Single Building"
        const val MULTI_BUILDING_MAP_NAME = "Multi-Building"
    }

    fun getMapNameFromString(building: String): String {
        return when (building) {
            SINGLE_BUILDING_DISPLAY_NAME -> SINGLE_BUILDING_MAP_NAME
            MULTI_BUILDING_DISPLAY_NAME -> MULTI_BUILDING_MAP_NAME
            else -> SINGLE_BUILDING_DISPLAY_NAME
        }
    }
}