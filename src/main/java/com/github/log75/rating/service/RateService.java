package com.github.log75.rating.service;

import com.github.log75.rating.model.Rate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * The Rate service interface.
 *
 */
public interface RateService {
    /**
     * Get rate.
     *
     * @param id the rate-id
     * @return the rate
     */
    Rate get(String id);

    /**
     * Get all.
     *
     * @param pageable the pageable
     * @return the rate-page
     */
    Page<Rate> getAll(Pageable pageable);

    /**
     * Create.
     *
     * @param rate the rate
     */
    void create(Rate rate);

    /**
     * Update.
     *
     * @param rate the rate
     * @param id   the rate-id
     */
    void update(Rate rate, String id);


    /**
     * Delete.
     *
     * @param id the rate-id
     */
    void delete(String id);

    /**
     * Find by related id and subscriber id.
     *
     * @param relatedId    the related id
     * @param subscriberId the subscriber id
     * @return the rate
     */
    Rate findByRelatedIdAndSubscriberId(String relatedId, String subscriberId);
}
