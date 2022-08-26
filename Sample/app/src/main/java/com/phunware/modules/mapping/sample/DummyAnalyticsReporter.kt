package com.phunware.modules.mapping.sample

import com.phunware.smartmap.provider.MapAnalyticsProvider
import timber.log.Timber

class DummyAnalyticsReporter : MapAnalyticsProvider {
    override fun onPoiSearched(keyword: String) {
        Timber.d("Analytics onPoiSearched: $keyword")
    }

    override fun onRouteStarted(poiName: String) {
        Timber.d("Analytics onRouteStarted: $poiName")
    }
}