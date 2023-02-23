package com.phunware.modules.mapping.sample

import com.phunware.smartmap.core.LocalizedString
import com.phunware.smartmap.provider.MAP_STRING_KEY_ALL_LOCATIONS
import com.phunware.smartmap.provider.MAP_STRING_KEY_BOTTOM_VIEW_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_CANCEL_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_CONTINUE_STRAIGHT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_CURRENT_LOCATION
import com.phunware.smartmap.provider.MAP_STRING_KEY_DISTANCE_TEMPLATE
import com.phunware.smartmap.provider.MAP_STRING_KEY_EXIT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_FLOOR_CHANGE_DIRECTION_DOWN
import com.phunware.smartmap.provider.MAP_STRING_KEY_FLOOR_CHANGE_DIRECTION_UP
import com.phunware.smartmap.provider.MAP_STRING_KEY_FLOOR_CHANGE_TEMPLATE
import com.phunware.smartmap.provider.MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_NO
import com.phunware.smartmap.provider.MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_YES
import com.phunware.smartmap.provider.MAP_STRING_KEY_LAST_ROUTESTEP_FORMAT
import com.phunware.smartmap.provider.MAP_STRING_KEY_LEAVE_ROUTING_ALERT_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_MAPPING_NO_ROUTE_AVAILABLE_MESSAGE
import com.phunware.smartmap.provider.MAP_STRING_KEY_MAPPING_NO_ROUTE_AVAILABLE_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_MAP_CATEGORIES_HEADER
import com.phunware.smartmap.provider.MAP_STRING_KEY_NEAR_ME
import com.phunware.smartmap.provider.MAP_STRING_KEY_NO_RESULTS_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_OFF_ROUTE_DESCRIPTION
import com.phunware.smartmap.provider.MAP_STRING_KEY_OFF_ROUTE_DIALOG_DISMISS
import com.phunware.smartmap.provider.MAP_STRING_KEY_OFF_ROUTE_DIALOG_DONT_SHOW_AGAIN
import com.phunware.smartmap.provider.MAP_STRING_KEY_OFF_ROUTE_DIALOG_MESSAGE
import com.phunware.smartmap.provider.MAP_STRING_KEY_OFF_ROUTE_DIALOG_REROUTE
import com.phunware.smartmap.provider.MAP_STRING_KEY_OFF_ROUTE_DIALOG_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_OFF_ROUTE_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_OK
import com.phunware.smartmap.provider.MAP_STRING_KEY_OTHER_CATEGORIES_VIEW_TITLE
import com.phunware.smartmap.provider.MAP_STRING_KEY_POI_CARD_BTN_ABOUT
import com.phunware.smartmap.provider.MAP_STRING_KEY_POI_CARD_BTN_ROUTE
import com.phunware.smartmap.provider.MAP_STRING_KEY_POI_DETAIL_BTN_ROUTE
import com.phunware.smartmap.provider.MAP_STRING_KEY_POI_DETAIL_PHONE
import com.phunware.smartmap.provider.MAP_STRING_KEY_POI_DETAIL_WEBSITE
import com.phunware.smartmap.provider.MAP_STRING_KEY_POI_SEARCH_PLACEHOLDER
import com.phunware.smartmap.provider.MAP_STRING_KEY_RECENT_LOCATIONS
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_BUILDER_END_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_BUILDER_HANDICAP_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_BUILDER_START_ROUTE_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_BUILDER_START_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_BUILDER_TITLE_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_DIRECTIONS_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_EXIT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTE_LIST_TITLE_PREFIX
import com.phunware.smartmap.provider.MAP_STRING_KEY_ROUTING_EXIT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_SAMPLEFLOOR_CHANGE_TEMPLATE
import com.phunware.smartmap.provider.MAP_STRING_KEY_SEARCH_TRY_AGAIN
import com.phunware.smartmap.provider.MAP_STRING_KEY_STRAIGHT_TEMPLATE
import com.phunware.smartmap.provider.MAP_STRING_KEY_TURN_BEARLEFT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_TURN_BEARRIGHT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_TURN_LEFT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_TURN_RIGHT_TEXT
import com.phunware.smartmap.provider.MAP_STRING_KEY_TURN_TEMPLATE
import com.phunware.smartmap.provider.MAP_STRING_KEY_UPCOMINGFLOOR_CHANGE_TEMPALTE
import com.phunware.smartmap.provider.MapsStringProvider

/**
 * Implementation of the [MapsStringProvider]
 */
object DefaultStringProvider : MapsStringProvider {

    private var keyMap = mutableMapOf(
        MAP_STRING_KEY_BOTTOM_VIEW_TITLE to "I'm Looking For…",
        MAP_STRING_KEY_POI_CARD_BTN_ROUTE to "Route",
        MAP_STRING_KEY_POI_CARD_BTN_ABOUT to "About",
        MAP_STRING_KEY_POI_DETAIL_PHONE to "Phone",
        MAP_STRING_KEY_POI_DETAIL_WEBSITE to "Website",
        MAP_STRING_KEY_POI_DETAIL_BTN_ROUTE to "Route",
        MAP_STRING_KEY_POI_SEARCH_PLACEHOLDER to "Search by keyword or category",
        MAP_STRING_KEY_ROUTE_BUILDER_TITLE_TEXT to "Route to...",
        MAP_STRING_KEY_ROUTE_BUILDER_START_TEXT to "Start",
        MAP_STRING_KEY_ROUTE_BUILDER_END_TEXT to "End",
        MAP_STRING_KEY_ROUTE_BUILDER_HANDICAP_TEXT to "Accessible Route",
        MAP_STRING_KEY_ROUTE_BUILDER_START_ROUTE_TEXT to "Start Route",
        MAP_STRING_KEY_OTHER_CATEGORIES_VIEW_TITLE to "Other Categories",
        MAP_STRING_KEY_NO_RESULTS_TITLE to "No Results Found.",
        MAP_STRING_KEY_SEARCH_TRY_AGAIN to "Please try your search again.",
        MAP_STRING_KEY_ROUTE_LIST_TITLE_PREFIX to "Routing to ",
        MAP_STRING_KEY_ROUTE_EXIT_TEXT to "Exit",
        MAP_STRING_KEY_ROUTE_DIRECTIONS_TEXT to "Directions",
        MAP_STRING_KEY_LEAVE_ROUTING_ALERT_TITLE to "Leave Routing?",
        MAP_STRING_KEY_ROUTING_EXIT_TEXT to "Are you sure you want exit your current route?",
        MAP_STRING_KEY_CANCEL_TEXT to "Cancel",
        MAP_STRING_KEY_EXIT_TEXT to "Exit",
        MAP_STRING_KEY_CURRENT_LOCATION to "Current Location",
        MAP_STRING_KEY_RECENT_LOCATIONS to "Recent Locations",
        MAP_STRING_KEY_ALL_LOCATIONS to "All Locations",
        MAP_STRING_KEY_NEAR_ME to "Near Me",
        MAP_STRING_KEY_TURN_TEMPLATE to " in %1\$s",
        MAP_STRING_KEY_TURN_LEFT_TEXT to "Turn left",
        MAP_STRING_KEY_TURN_RIGHT_TEXT to "Turn right",
        MAP_STRING_KEY_TURN_BEARLEFT_TEXT to "Bear Left",
        MAP_STRING_KEY_TURN_BEARRIGHT_TEXT to "Bear Right",
        MAP_STRING_KEY_DISTANCE_TEMPLATE to "%1\$s ft.",
        MAP_STRING_KEY_STRAIGHT_TEMPLATE to " for %1\$s",
        MAP_STRING_KEY_CONTINUE_STRAIGHT_TEXT to "Continue straight",
        MAP_STRING_KEY_UPCOMINGFLOOR_CHANGE_TEMPALTE to "%1\$s %2\$s towards %3\$s to %4\$s",
        MAP_STRING_KEY_FLOOR_CHANGE_DIRECTION_UP to "up",
        MAP_STRING_KEY_FLOOR_CHANGE_DIRECTION_DOWN to "down",
        MAP_STRING_KEY_SAMPLEFLOOR_CHANGE_TEMPLATE to "Take the %1\$s to %1\$s",
        MAP_STRING_KEY_FLOOR_CHANGE_TEMPLATE to "Take the %1\$s %2\$s to %3\$s",
        MAP_STRING_KEY_LAST_ROUTESTEP_FORMAT to "to arrive at %1\$s",
        MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_TITLE to "We noticed you are not on campus",
        MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_TEXT to "Would you like to have driving directions to the campus?",
        MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_YES to "Yes",
        MAP_STRING_KEY_HOME_TO_VENUE_PROMPT_NO to "No",
        MAP_STRING_KEY_MAP_CATEGORIES_HEADER to "Categories",
        MAP_STRING_KEY_MAPPING_NO_ROUTE_AVAILABLE_TITLE to "No Route Available",
        MAP_STRING_KEY_MAPPING_NO_ROUTE_AVAILABLE_MESSAGE to "Please try routing to another location",
        MAP_STRING_KEY_OK to "OK",
        "restroom" to "Restrooms",
        "dining" to "Dining",
        "pharmacy" to "Pharmacy",
        "patient_rooms" to "Patient Rooms",
        "doctor_offices" to "Doctor Offices",
        "parking" to "Parking",
        "other" to "Other",
        "entrances" to "Entrances",
        "elevators" to "Elevators",
        MAP_STRING_KEY_OFF_ROUTE_TITLE to "Off Route Scenario",
        MAP_STRING_KEY_OFF_ROUTE_DESCRIPTION to "Shows an alert when the user goes too far off route",
        MAP_STRING_KEY_OFF_ROUTE_DIALOG_TITLE to "You Are No Longer\nOn Route",
        MAP_STRING_KEY_OFF_ROUTE_DIALOG_MESSAGE to "Please return to the route or re-route from your current location.",
        MAP_STRING_KEY_OFF_ROUTE_DIALOG_DISMISS to "Dismiss",
        MAP_STRING_KEY_OFF_ROUTE_DIALOG_REROUTE to "Re-route",
        MAP_STRING_KEY_OFF_ROUTE_DIALOG_DONT_SHOW_AGAIN to "Don't Show Again",
    )

    override fun getString(key: String): String? {
        val stringKey = if (LocalizedString.isLocalizeKey(key))
            key.substring(1)
        else
            key

        return if (keyMap.contains(stringKey))
            keyMap[stringKey]
        else
            null
    }

    override fun provideLocalizedStrings(language: String, strings: Map<String, String>) {
        keyMap.putAll(strings)
    }
}