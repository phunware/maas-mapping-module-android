# Phunware Mapping

[![Nexus](https://img.shields.io/nexus/r/com.phunware.smartapp/smartmap-library-android?color=brightgreen&server=https%3A%2F%2Fnexus.phunware.com)](https://nexus.phunware.com/content/groups/public/com/phunware/smartapp/smartmap-library-android/)

Phunware Mapping is a module that provides mapping and routing functionalities. Visit https://www.phunware.com/ for more information or [sign into the MaaS Portal](http://maas.phunware.com/) to set up your venue.

|Blue Dot|Route Builder|Route Directions|POI Categories|POI Search|
|:-:|:-:|:-:|:-:|:-:|
|![Blue Dot](https://raw.githubusercontent.com/phunware/maas-mapping-module-android/master/Resources/blue-dot.jpg)|![Route Builder](https://raw.githubusercontent.com/phunware/maas-mapping-module-android/master/Resources/route-builder.jpg)|![Blue Dot](https://raw.githubusercontent.com/phunware/maas-mapping-module-android/master/Resources/route-directions.jpg)|![POI Categories](https://raw.githubusercontent.com/phunware/maas-mapping-module-android/master/Resources/poi-categories.jpg)|![Blue Dot](https://raw.githubusercontent.com/phunware/maas-mapping-module-android/master/Resources/poi-search.jpg)|

## Requirements

- minSdk 23
- targetSdk 33
- AndroidX

## Download
Add the following repository to your top level `build.gradle` file:

```groovy
repositories {
    maven {
        url "https://nexus.phunware.com/content/groups/public/"
    }
}
```

Add the following dependency to your app level `build.gradle` file:

```groovy
dependencies {
    implementation "com.phunware.smartapp:smartmap-library-android:1.7.0-beta04"
}
```

## Setup

### Keys

To use any Phunware SDKs or Modules, you'll need to add the following entries to your `AndroidManifest.xml`, making sure to replace the `value` properties with your App ID and Access Key:

```xml
<meta-data
    android:name="com.phunware.maas.APPLICATION_ID"
    android:value="YOUR_APP_ID"/>

<meta-data
    android:name="com.phunware.maas.ACCESS_KEY"
    android:value="YOUR_ACCESS_KEY"/>
```

### Permissions

Precise Location and Bluetooth Scan permissions are required for real-time location updates and blue dot tracking on the map:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
<uses-permission
    android:name="android.permission.BLUETOOTH"
    android:maxSdkVersion="30" />
<uses-permission
    android:name="android.permission.BLUETOOTH_ADMIN"
    android:maxSdkVersion="30" />
<!-- Optional: Derive physical location updates when app is not visible -->
<uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />
<!-- Optional: Cache floor map tiles to external cache if internal cache is unavailable -->
<uses-permission
    android:name="android.permission.WRITE_EXTERNAL_STORAGE"
    android:maxSdkVersion="28" />
```

## Usage

### Permission Priming

Priming the user for and requesting permissions is achieved by using the `MappingPermissionsHelper` utility class:

```kotlin
val supportsLocation = packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS)
if (supportsLocation) {
    MappingPermissionsHelper.handleLocationPermissions(applicationContext, this) {
        // Handle completion of requested location permissions
    }
}
```

### Routing

After precise location and bluetooth scan permissions have been granted, launching the mapping experience is achieved by first configuring both a `MapConfigurationProvider` and `MeetingRoomStatusProvider`, and then finally requesting a `SmartMapActivity`: 

```
MapConfigurationProvider.setInstance(mapConfigurationProvider)
MapsStringProvider.setInstance(stringProvider)
MeetingRoomStatusProvider.setInstance(meetingRoomStatusProvider)
...

val intent = SmartMapActivity.SmartMapIntentBuilder(mapName).build(this@MainActivity)
startActivity(intent)
```

## Privacy
You understand and consent to Phunware’s Privacy Policy located at www.phunware.com/privacy. If your use of Phunware’s software requires a Privacy Policy of your own, you also agree to include the terms of Phunware’s Privacy Policy in your Privacy Policy to your end users.

## Terms
Use of this software requires review and acceptance of our terms and conditions for developer use located at http://www.phunware.com/terms/
