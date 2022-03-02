package com.github.log75.rating.api.controller;

import com.github.log75.rating.api.adapter.RateAdapter;
import com.github.log75.rating.api.dto.CreateRateDto;
import com.github.log75.rating.api.dto.GetRateDto;
import com.github.log75.rating.api.dto.UpdateRateDto;
import com.vasl.ario.crudutil.service.model.PageQueryParams;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.github.log75.rating.util.Constants.RATE_ENDPOINT;

/**
 * The Rate controller.
 *
 */
@RequiredArgsConstructor
@RequestMapping(RATE_ENDPOINT)
@RestController
public class RateController {

    private final RateAdapter adapter;

    /**
     * Create.
     *
     * @param rateDto the rate dto
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('api.v1.rating.create')")
    public void create(@RequestBody @Valid CreateRateDto rateDto) {
        adapter.create(rateDto);
    }

    /**
     * Get rate dto.
     *
     * @param id the rate-id
     * @return the get rate dto
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('api.v1.rating.get')")
    public GetRateDto get(@PathVariable String id) {
        return adapter.get(id);
    }

    /**
     * Get all.
     *
     * @param queryParams the query params
     * @return the page
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNumber", example = "0", value = "starts from 0"),
            @ApiImplicitParam(name = "pageSize", example = "10", value = "must be greater than 0"),
            @ApiImplicitParam(name = "sort", example = "ASC", value = "ASC=ascending ,DESC=descending"),
            @ApiImplicitParam(name = "sortKey", example = "[key1,key2]", type = "List", allowMultiple = true, value = "sort will be based on these words"),})
    @PreAuthorize("hasAuthority('api.v1.rating.getAll')")
    public Page<GetRateDto> getAll(PageQueryParams queryParams) {
        return adapter.getAll(queryParams);
    }

    /**
     * Update.
     *
     * @param rateDto the rate dto
     * @param id      the rate-id
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('api.v1.rating.update')")
    public void update(@RequestBody @Valid UpdateRateDto rateDto, @PathVariable String id) {
        adapter.update(rateDto, id);
    }

    /**
     * Delete.
     *
     * @param id the rate-id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasAuthority('api.v1.rating.delete')")
    public void delete(@PathVariable String id) {
        adapter.delete(id);
    }
}
