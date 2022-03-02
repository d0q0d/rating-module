package com.github.log75.rating.api.adapter;

import com.github.log75.rating.api.dto.CreateRateDto;
import com.github.log75.rating.api.dto.GetRateDto;
import com.github.log75.rating.api.dto.UpdateRateDto;
import com.vasl.ario.crudutil.repository.RepositoryUtils;
import com.vasl.ario.crudutil.service.model.PageQueryParams;
import com.github.log75.rating.api.adapter.mapper.RateMapper;
import com.github.log75.rating.service.RateService;
import com.vasl.ario.subscriber.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * The Rate adapter.
 *
 *
 */
@Component
@RequiredArgsConstructor
public class RateAdapter {

    private final RateService rateService;
    private final SubscriberService subscriberService;
    private final RateMapper mapper;

    /**
     * Create.
     *
     * @param rateDto the rate dto
     */
    public void create(CreateRateDto rateDto) {
        rateService.create(mapper.createReteDtoToRate(subscriberService, rateDto));
    }

    /**
     * Get rate dto.
     *
     * @param id the rate-id
     * @return the rate dto
     */
    public GetRateDto get(String id) {
        return mapper.rateToGetRateDto(rateService.get(id));
    }

    /**
     * Get all.
     *
     * @param queryParams the page query params
     * @return the all
     */
    public Page<GetRateDto> getAll(PageQueryParams queryParams) {
        return rateService.getAll(RepositoryUtils.getPageableFromPageQueryParams(queryParams)).map(mapper::rateToGetRateDto);
    }

    /**
     * Update.
     *
     * @param rateDto the rate dto
     * @param id      the rate-id
     */
    public void update(UpdateRateDto rateDto, String id) {
        rateService.update(mapper.updateRateDtoToRate(rateDto), id);
    }

    /**
     * Delete.
     *
     * @param id the rate-id
     */
    public void delete(String id) {
        rateService.delete(id);
    }
}
