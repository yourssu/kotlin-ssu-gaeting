package com.yourssu.ssugaeting.domain.verification.implement

import com.yourssu.ssugaeting.domain.common.implement.Uuid
import com.yourssu.ssugaeting.domain.verification.implement.domain.Verification
import com.yourssu.ssugaeting.domain.verification.implement.domain.VerificationCode

interface VerificationRepository {
    fun issueVerificationCode(verification: Verification): VerificationCode
    fun existsByUuid(uuid: Uuid): Boolean
    fun getVerificationCode(uuid: Uuid): VerificationCode
    fun getByCode(verificationCode: VerificationCode): Verification
    fun existsByCode(code: VerificationCode): Boolean
    fun removeByUuid(uuid: Uuid)
    fun clear()
    fun findAllVerificationCodes(): List<Int>
}
