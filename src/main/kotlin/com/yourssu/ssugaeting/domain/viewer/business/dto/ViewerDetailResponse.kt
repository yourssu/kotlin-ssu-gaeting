package com.yourssu.ssugaeting.domain.viewer.business.dto

import com.yourssu.ssugaeting.domain.profile.business.dto.PurchasedProfileResponse
import com.yourssu.ssugaeting.domain.viewer.implement.domain.Viewer
import java.time.format.DateTimeFormatter

data class ViewerDetailResponse(
    val id: Long? = null,
    val uuid: String,
    val ticket: Int,
    val gender: String,
    val usedTicket: Int,
    val updatedTime: String,
    val purchasedProfiles: List<PurchasedProfileResponse>,
) {
    companion object {
        fun from(
            viewer: Viewer,
            purchasedProfiles: List<PurchasedProfileResponse>,
        ): ViewerDetailResponse {
            return ViewerDetailResponse(
                id = viewer.id,
                uuid = viewer.uuid.value,
                gender = viewer.gender.name,
                ticket = viewer.ticket,
                usedTicket = viewer.usedTicket,
                updatedTime = viewer.updatedTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                purchasedProfiles = purchasedProfiles,
            )
        }
    }
}
