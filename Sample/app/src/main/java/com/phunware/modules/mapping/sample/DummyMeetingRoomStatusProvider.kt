package com.phunware.modules.mapping.sample

import com.phunware.smartmap.model.MeetingRoomStatusData
import com.phunware.smartmap.model.RoomStatus
import com.phunware.smartmap.provider.MeetingRoomStatusProvider
import kotlinx.coroutines.delay
import kotlin.random.Random

object DummyMeetingRoomStatusProvider : MeetingRoomStatusProvider {


    override fun getListOfAllMeetingRoomPoiIds(): List<Long> {
        return listOf(12345678, 87654321)

    }

    override suspend fun getMeetingRoomStatusFor(id: Long): MeetingRoomStatusData {
        delay(1000L)
        return MeetingRoomStatusData(
            poiId = 123123L,
            status = generateRandomRoomStatus()
        )
    }

    override suspend fun getMeetingRoomStatusFor(ids: List<Long>): List<MeetingRoomStatusData> {
        delay(1000L)
        return ArrayList<MeetingRoomStatusData>().apply {
            add(
                MeetingRoomStatusData(
                    poiId = 12345678,
                    status = generateRandomRoomStatus()
                )
            )
            add(
                MeetingRoomStatusData(
                    poiId = 87654321,
                    status = generateRandomRoomStatus()
                )
            )
        }
    }

    override suspend fun getStatusForAllMeetingRooms(): List<MeetingRoomStatusData> {
        delay(1000L)
        return ArrayList<MeetingRoomStatusData>().apply {
            add(
                MeetingRoomStatusData(
                    poiId = 12345678,
                    status = generateRandomRoomStatus()
                )
            )
            add(
                MeetingRoomStatusData(
                    poiId = 87654321,
                    status = generateRandomRoomStatus()
                )
            )
        }
    }

    /***
     * Testing function to randomly set the [RoomStatus]. This will allow for the refresh to be visible within the sample app
     */
    private fun generateRandomRoomStatus(): RoomStatus {
        return RoomStatus.values().run {
            get(Random.nextInt(this.size))
        }
    }
}