package com.github.log75.rating.service;

import com.github.log75.rating.model.KeyQueryParam;
import com.github.log75.rating.model.RateOpinion;
import com.github.log75.rating.model.RateValueEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The rate-opinion service interface.
 *
 */
public interface RateOpinionService {
    /**
     * Create.
     *
     * @param rateOpinion the rate opinion
     */
    void create(RateOpinion rateOpinion);

    /**
     * Update.
     *
     * @param updateRateOpinionDtoToRateOpinion the update rate opinion dto to rate opinion
     * @param valueEnum                         the value enum
     */
    void update(RateOpinion updateRateOpinionDtoToRateOpinion, RateValueEnum valueEnum);

    /**
     * Delete.
     *
     * @param valueEnum the value enum
     */
    void delete(RateValueEnum valueEnum);

    /**
     * Remove key.
     *
     * @param queryParam the query param
     */
    void removeKey(KeyQueryParam queryParam);

    /**
     * Add key.
     *
     * @param queryParam the query param
     */
    void addKey(KeyQueryParam queryParam);

    /**
     * Get rate opinion.
     *
     * @param valueEnum the value enum
     * @return the rate opinion
     */
    RateOpinion get(RateValueEnum valueEnum);

    /**
     * Get all.
     *
     * @param pageable the pageable
     * @return the all
     */
    Page<RateOpinion> getAll(Pageable pageable);
}
