package com.github.log75.rating.repository;

import com.github.log75.rating.model.RateOpinion;
import com.github.log75.rating.model.RateValueEnum;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * The Rate-opinion repository interface.
 *
 */
public interface RateOpinionRepository extends MongoRepository<RateOpinion, String> , CustomOpinionRepository{
    /**
     * Find by rate-value enum.
     *
     * @param valueEnum the value enum
     * @return the optional
     */
    Optional<RateOpinion> findByRateValueEnum(RateValueEnum valueEnum);

    /**
     * Delete by rate-value enum.
     *
     * @param valueEnum the value enum
     * @return the optional
     */
    Optional<RateOpinion> deleteByRateValueEnum(RateValueEnum valueEnum);
}
