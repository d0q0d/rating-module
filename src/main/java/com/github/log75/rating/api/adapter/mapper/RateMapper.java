package com.github.log75.rating.api.adapter.mapper;

import com.github.log75.rating.api.dto.CreateRateDto;
import com.github.log75.rating.api.dto.GetRateDto;
import com.github.log75.rating.api.dto.UpdateRateDto;
import com.github.log75.rating.model.Rate;
import com.vasl.ario.subscriber.service.SubscriberService;
import org.mapstruct.Mapper;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * The Rate mapper interface.
 *
 */
@Mapper
public interface RateMapper {
    /**
     * Rate dto to rate.
     *
     * @param dto the dto
     * @return the rate
     */
    Rate createRateToRate(CreateRateDto dto);

    /**
     * Rate to rate dto.
     *
     * @param rate the rate
     * @return the get rate dto
     */
    GetRateDto rateToGetRateDto(Rate rate);

    /**
     * Rate dto to rate..
     *
     * @param dto the dto
     * @return the rate
     */
    Rate updateRateDtoToRate(UpdateRateDto dto);

    /**
     * Get user id from context.
     *
     * @param subscriberService the subscriber service
     * @return the user id from context
     */
    default String getUserIdFromContext(SubscriberService subscriberService) {
        var userCredentialId = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return subscriberService.getByCredentialId(userCredentialId).getId();
    }

    /**
     * rete dto to rate.
     *
     * @param subscriberService the subscriber service
     * @param rateDto           the rate dto
     * @return the rate
     */
    default Rate createReteDtoToRate(SubscriberService subscriberService, CreateRateDto rateDto) {
        var rate = createRateToRate(rateDto);
        rate.setSubscriberId(getUserIdFromContext(subscriberService));
        return rate;
    }
}
