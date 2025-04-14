package com.yourssu.ssugaeting.domain.viewer.application.dto

import com.yourssu.ssugaeting.domain.profile.business.RandomProfileFoundCommand
import jakarta.validation.constraints.NotBlank

class RandomProfileRequest(
    @field:NotBlank
    val uuid: String,

    val excludeProfiles: List<Long> = emptyList(),
) {
    fun toCommand(): RandomProfileFoundCommand {
        return RandomProfileFoundCommand(
            uuid = uuid,
            excludeProfiles = excludeProfiles
        )
    }
}
