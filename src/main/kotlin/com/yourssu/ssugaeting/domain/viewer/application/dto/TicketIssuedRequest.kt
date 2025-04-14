package com.yourssu.ssugaeting.domain.viewer.application.dto

import com.yourssu.ssugaeting.domain.viewer.business.dto.TicketIssuedCommand
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive

class TicketIssuedRequest(
    @field:NotBlank
    val secretKey: String,

    @field:NotNull
    val verificationCode: Int,

    @field:Positive
    val ticket: Int,
) {
    fun toCommand(): TicketIssuedCommand {
        return TicketIssuedCommand(
            secretKey = secretKey,
            verificationCode = verificationCode,
            ticket = ticket,
        )
    }
}
