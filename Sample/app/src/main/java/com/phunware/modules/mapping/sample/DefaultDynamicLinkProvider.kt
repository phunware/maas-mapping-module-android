package com.phunware.modules.mapping.sample

import com.phunware.smartmap.provider.DynamicLinkProvider

class DefaultDynamicLinkProvider : DynamicLinkProvider() {

    override suspend fun provideDynamicLink(dynamicLinkData: DynamicLinkData): String {
        return "[INSERT DYNAMIC LINK HERE]"
    }
}