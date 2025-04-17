package com.yourssu.signal.domain.profile.application

import com.yourssu.signal.domain.common.business.dto.Response
import com.yourssu.signal.domain.profile.application.dto.*
import com.yourssu.signal.domain.profile.business.ProfilesCountResponse
import com.yourssu.signal.domain.profile.business.ProfileService
import com.yourssu.signal.domain.profile.business.dto.ProfileContactResponse
import com.yourssu.signal.domain.profile.business.dto.ProfileResponse
import com.yourssu.signal.domain.viewer.application.dto.RandomProfileRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/profiles")
class ProfileController(
    private val profileService: ProfileService,
) {
    @PostMapping
    fun createProfile(@Valid @RequestBody request: ProfileCreatedRequest): ResponseEntity<Response<ProfileContactResponse>> {
        val response = profileService.createProfile(request.toCommand())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(Response(result = response))
    }

    @GetMapping("/uuid")
    fun getProfile(@Valid @ModelAttribute request: ProfileFoundRequest): ResponseEntity<Response<ProfileContactResponse>> {
        val response = profileService.getProfile(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }

    @GetMapping
    fun getAllProfiles(@Valid @ModelAttribute request: ProfilesFoundRequest): ResponseEntity<Response<List<ProfileResponse>>> {
        val response = profileService.getAllProfiles(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }

    @GetMapping("/count")
    fun countAllProfiles(): ResponseEntity<Response<ProfilesCountResponse>> {
        val response = profileService.countAllProfiles()
        return ResponseEntity.ok(Response(result = response))
    }

    @GetMapping("/random")
    fun getRandomProfile(@Valid @ModelAttribute request: RandomProfileRequest): ResponseEntity<Response<ProfileResponse>> {
        val response = profileService.getRandomProfile(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }

    @PostMapping("/contact")
    fun consumeTicket(@Valid @RequestBody request: TicketConsumedRequest): ResponseEntity<Response<ProfileContactResponse>> {
        val response = profileService.consumeTicket(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }
}
