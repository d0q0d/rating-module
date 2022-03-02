package com.github.log75.rating.repository;

import com.github.log75.rating.model.Rate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * The Rate repository interface.
 *
 */
public interface RateRepository extends MongoRepository<Rate, String> {
    Rate findByRelatedIdAndSubscriberId(String relatedId, String subscriberId);
}
