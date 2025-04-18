package com.yourssu.signal.domain.profile.storage

import com.yourssu.signal.domain.profile.implement.domain.PurchasedProfile
import com.yourssu.signal.domain.profile.implement.PurchasedProfileRepository
import com.yourssu.signal.domain.profile.storage.domain.PurchasedProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class PurchasedProfileRepositoryImpl(
    private val purchasedProfileJpaRepository: PurchasedProfileJpaRepository,
): PurchasedProfileRepository {
    override fun save(purchasedProfile: PurchasedProfile): PurchasedProfile {
        return purchasedProfileJpaRepository.save(PurchasedProfileEntity.from(purchasedProfile))
            .toDomain()
    }

    override fun exists(purchasedProfile: PurchasedProfile): Boolean {
        return purchasedProfileJpaRepository.existsByProfileIdAndViewerId(
            profileId = purchasedProfile.profileId,
            viewerId = purchasedProfile.viewerId,
        )
    }

    override fun findByViewerId(viewerId: Long): List<PurchasedProfile> {
        return purchasedProfileJpaRepository.findByViewerId(viewerId)
            .map { it.toDomain() }
    }
}

interface PurchasedProfileJpaRepository : JpaRepository<PurchasedProfileEntity, Long> {
    fun existsByProfileIdAndViewerId(profileId: Long, viewerId: Long): Boolean
    fun findByViewerId(viewerId: Long): List<PurchasedProfileEntity>
}
