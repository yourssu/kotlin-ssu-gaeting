package com.yourssu.ssugaeting.domain.profile.application.dto

import com.yourssu.ssugaeting.domain.profile.business.dto.ProfileCreatedCommand
import jakarta.validation.constraints.NotBlank

class ProfileCreatedRequest(
    @field:NotBlank
    val gender: String,

    @field:NotBlank
    val animal: String,

    @field:NotBlank
    val contact: String,

    @field:NotBlank
    val mbti: String,

    @field:NotBlank
    val nickname: String,
) {
    fun toCommand(): ProfileCreatedCommand {
        return ProfileCreatedCommand(
            gender = gender,
            animal = animal,
            contact = contact,
            mbti = mbti,
            nickname = nickname,
        )
    }

}
