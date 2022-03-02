package com.github.log75.rating.service.mapper;

import com.github.log75.rating.model.Rate;
import com.github.log75.rating.model.RateOpinion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

/**
 * The Rate service mapper interface.
 *
 */
@Mapper
public interface RateServiceMapper {

    /**
     * Update rate.
     *
     * @param newRate      the new rate
     * @param existingRate the existing rate
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "subscriberId", ignore = true)
    void updateRate(Rate newRate, @MappingTarget Rate existingRate);

    /**
     * Update rate opinion.
     *
     * @param newRate      the new rate
     * @param existingRate the existing rate
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(target = "rateValueEnum", ignore = true)
    void updateRateOpinion(RateOpinion newRate, @MappingTarget RateOpinion existingRate);

}
