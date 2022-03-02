package com.github.log75.rating.api.adapter;

import com.github.log75.rating.api.dto.CreateRateOpinionDto;
import com.github.log75.rating.api.dto.GetRateOpinionDto;
import com.github.log75.rating.api.dto.UpdateRateOpinionDto;
import com.vasl.ario.crudutil.repository.RepositoryUtils;
import com.vasl.ario.crudutil.service.model.PageQueryParams;
import com.github.log75.rating.api.adapter.mapper.RateOpinionMapper;
import com.github.log75.rating.model.KeyQueryParam;
import com.github.log75.rating.model.RateValueEnum;
import com.github.log75.rating.service.RateOpinionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * The type Rate opinion adapter.
 *
 */
@Component
@RequiredArgsConstructor
public class RateOpinionAdapter {

    private final RateOpinionMapper mapper;
    private final RateOpinionService service;

    /**
     * Create.
     *
     * @param rateOpinionDto the rate opinion dto
     */
    public void create(CreateRateOpinionDto rateOpinionDto) {
        service.create(mapper.createRateOpinionDtoToRateOpinion(rateOpinionDto));
    }

    /**
     * Get get rate opinion dto.
     *
     * @param valueEnum the value enum
     * @return the get rate opinion dto
     */
    public GetRateOpinionDto get(RateValueEnum valueEnum) {
        return mapper.rateOpinionToGetRateOpinionDto(service.get(valueEnum));
    }

    /**
     * Get all.
     *
     * @param queryParams the query params
     * @return the all
     */
    public Page<GetRateOpinionDto> getAll(PageQueryParams queryParams) {
        return service.getAll(RepositoryUtils.getPageableFromPageQueryParams(queryParams)).map(mapper::rateOpinionToGetRateOpinionDto);
    }

    /**
     * Update.
     *
     * @param rateOpinionDto the rate opinion dto
     * @param valueEnum      the value enum
     */
    public void update(UpdateRateOpinionDto rateOpinionDto, RateValueEnum valueEnum) {
        service.update(mapper.updateRateOpinionDtoToRateOpinion(rateOpinionDto), valueEnum);
    }

    /**
     * Delete.
     *
     * @param valueEnum the value enum
     */
    public void delete(RateValueEnum valueEnum) {
        service.delete(valueEnum);
    }

    /**
     * Add key.
     *
     * @param queryParam the query param
     */
    public void addKey(KeyQueryParam queryParam) {service.addKey(queryParam);}

    /**
     * Remove key.
     *
     * @param queryParam the query param
     */
    public void removeKey(KeyQueryParam queryParam) {
        service.removeKey(queryParam);
    }

}
