package com.github.log75.rating.api.adapter.mapper;

import com.github.log75.rating.api.dto.CreateRateOpinionDto;
import com.github.log75.rating.api.dto.GetRateOpinionDto;
import com.github.log75.rating.api.dto.UpdateRateOpinionDto;
import com.github.log75.rating.model.RateOpinion;
import org.mapstruct.Mapper;


/**
 * The Rate-opinion mapper interface.
 */
@Mapper
public interface RateOpinionMapper {
    /**
     * Rate opinion dto to rate opinion.
     *
     * @param dto the dto
     * @return the rate opinion
     */
    RateOpinion createRateOpinionDtoToRateOpinion(CreateRateOpinionDto dto);

    /**
     * Rate opinion to rate opinion dto.
     *
     * @param rateOpinion the rate opinion
     * @return the get rate opinion dto
     */
    GetRateOpinionDto rateOpinionToGetRateOpinionDto(RateOpinion rateOpinion);

    /**
     * Rate opinion dto to rate opinion.
     *
     * @param dto the dto
     * @return the rate opinion
     */
    RateOpinion updateRateOpinionDtoToRateOpinion(UpdateRateOpinionDto dto);
}
