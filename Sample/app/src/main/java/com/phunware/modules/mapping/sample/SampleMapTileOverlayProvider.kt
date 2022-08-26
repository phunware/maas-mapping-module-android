package com.phunware.modules.mapping.sample

import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng
import com.phunware.smartmap.provider.MapTileOverlayProvider

class SampleMapTileOverlayProvider : MapTileOverlayProvider {

    override fun provideBuildingTileOverlayMap(): Map<Long, GroundOverlayOptions> {
        val overviewGroundOverlayOptions = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.blue))
            .position(LatLng(33.02225779181489, -117.08291014479568), 1600f, 1600f)
            .zIndex(-3.0F)

        val building1GroundOverlayOptions = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.red))
            .position(LatLng(33.022030039392945, -117.08260007450397), 1600f, 1600f)
            .zIndex(-3.0F)

        val singleBuildingGroundOverlayOptions = GroundOverlayOptions()
            .image(BitmapDescriptorFactory.fromResource(R.drawable.blue))
            .position(LatLng(33.02225779181489, -117.08291014479568), 1600f, 1600f)
            .zIndex(-3.0F)

        return mapOf(
            Pair(116767L, overviewGroundOverlayOptions),
            Pair(116773L, building1GroundOverlayOptions),
            Pair(43762L, singleBuildingGroundOverlayOptions)
        )
    }
}