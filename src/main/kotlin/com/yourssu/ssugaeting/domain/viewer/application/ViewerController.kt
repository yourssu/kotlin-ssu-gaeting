package com.yourssu.ssugaeting.domain.viewer.application

import com.yourssu.ssugaeting.domain.common.business.Response
import com.yourssu.ssugaeting.domain.viewer.application.dto.TicketIssuedRequest
import com.yourssu.ssugaeting.domain.viewer.application.dto.VerificationRequest
import com.yourssu.ssugaeting.domain.viewer.application.dto.ViewFoundRequest
import com.yourssu.ssugaeting.domain.viewer.application.dto.ViewersFoundRequest
import com.yourssu.ssugaeting.domain.viewer.business.ViewerService
import com.yourssu.ssugaeting.domain.viewer.business.dto.VerificationResponse
import com.yourssu.ssugaeting.domain.viewer.business.dto.ViewerResponse
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/viewers")
class ViewerController(
    private val viewerService: ViewerService,
) {
    @PostMapping("/verification")
    fun issueVerification(@Valid @RequestBody request: VerificationRequest) : ResponseEntity<Response<VerificationResponse>> {
        val response = viewerService.issueVerificationCode(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }

    @PostMapping
    fun issueTicket(@Valid @RequestBody request: TicketIssuedRequest) : ResponseEntity<Response<ViewerResponse>> {
        val response = viewerService.issueTicket(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }

    @GetMapping("/uuid")
    fun getProfile(@Valid @ModelAttribute request: ViewFoundRequest): ResponseEntity<Response<ViewerResponse>> {
        val response = viewerService.getViewer(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }

    @GetMapping
    fun findAllViewers(@Valid @ModelAttribute request: ViewersFoundRequest) : ResponseEntity<Response<List<ViewerResponse>>> {
        val response = viewerService.findAllViewers(request.toCommand())
        return ResponseEntity.ok(Response(result = response))
    }
}
