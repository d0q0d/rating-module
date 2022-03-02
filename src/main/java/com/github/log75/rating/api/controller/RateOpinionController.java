package com.github.log75.rating.api.controller;

import com.github.log75.rating.api.adapter.RateOpinionAdapter;
import com.github.log75.rating.api.dto.CreateRateOpinionDto;
import com.github.log75.rating.api.dto.GetRateOpinionDto;
import com.github.log75.rating.api.dto.UpdateRateOpinionDto;
import com.vasl.ario.crudutil.service.model.PageQueryParams;
import com.github.log75.rating.model.KeyQueryParam;
import com.github.log75.rating.model.RateValueEnum;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.github.log75.rating.util.Constants.RATE_OPINION_ENDPOINT;

/**
 * The Rate opinion controller.
 */
@RequiredArgsConstructor
@RequestMapping(RATE_OPINION_ENDPOINT)
@RestController
public class RateOpinionController {

    private final RateOpinionAdapter adapter;

    /**
     * Create.
     *
     * @param rateOpinionDto the rate opinion dto
     */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('api.v1.rating.opinion.create')")
    public void create(@RequestBody @Valid CreateRateOpinionDto rateOpinionDto) {
        adapter.create(rateOpinionDto);
    }

    /**
     * Get get rate opinion dto.
     *
     * @param valueEnum the value enum
     * @return the get rate opinion dto
     */
    @GetMapping("/{value-enum}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('api.v1.rating.opinion.get')")
    public GetRateOpinionDto get(@PathVariable("value-enum") RateValueEnum valueEnum) {
        return adapter.get(valueEnum);
    }

    /**
     * Get all.
     *
     * @param queryParams the query params
     * @return the all
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", example = "0", value = "starts from 0"),
            @ApiImplicitParam(name = "pageSize", example = "10", value = "must be greater than 0"),
            @ApiImplicitParam(name = "sort", example = "ASC", value = "ASC=ascending ,DESC=descending"),
            @ApiImplicitParam(name = "sortKey", example = "[key1,key2]", type = "List", allowMultiple = true, value = "sort will be based on these words"),})
    @PreAuthorize("hasAuthority('api.v1.rating.opinion.getAll')")
    public Page<GetRateOpinionDto> getAll(PageQueryParams queryParams) {
        return adapter.getAll(queryParams);
    }

    /**
     * Update.
     *
     * @param rateOpinionDto the rate opinion dto
     * @param valueEnum      the value enum
     */
    @PutMapping("/{value-enum}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('api.v1.rating.opinion.update')")
    public void update(@RequestBody @Valid UpdateRateOpinionDto rateOpinionDto, @PathVariable("value-enum") RateValueEnum valueEnum) {
        adapter.update(rateOpinionDto, valueEnum);
    }

    /**
     * Delete.
     *
     * @param valueEnum the value enum
     */
    @DeleteMapping("/{value-enum}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('api.v1.rating.opinion.delete')")
    public void delete(@PathVariable("value-enum") RateValueEnum valueEnum) {
        adapter.delete(valueEnum);
    }

    /**
     * Add key to opinion list.
     *
     * @param queryParam the query param
     */
    @PatchMapping("/keys/add")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('api.v1.rating.opinion.addKey')")
    public void addKey(@RequestBody @Valid KeyQueryParam queryParam) {
        adapter.addKey(queryParam);
    }

    /**
     * Remove key from opinion list.
     *
     * @param queryParam the query param
     */
    @PatchMapping("/keys/remove")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('api.v1.rating.opinion.removeKey')")
    public void removeKey(@RequestBody @Valid KeyQueryParam queryParam) {
        adapter.removeKey(queryParam);
    }

}
