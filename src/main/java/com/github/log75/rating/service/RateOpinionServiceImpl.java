package com.github.log75.rating.service;

import com.github.log75.rating.model.KeyQueryParam;
import com.github.log75.rating.model.RateOpinion;
import com.github.log75.rating.model.RateValueEnum;
import com.vasl.ario.crudutil.service.exception.NotFoundException;
import com.github.log75.rating.repository.RateOpinionRepository;
import com.github.log75.rating.service.mapper.RateServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 */
@Service
@RequiredArgsConstructor
public class RateOpinionServiceImpl implements RateOpinionService {

    private final RateOpinionRepository repository;
    private final RateServiceMapper mapper;

    @Override
    public void create(RateOpinion rateOpinion) {
        repository.save(rateOpinion);
    }

    @Override
    public RateOpinion get(RateValueEnum valueEnum) {
        return repository.findByRateValueEnum(valueEnum).orElseThrow(NotFoundException::new);
    }

    @Override
    public Page<RateOpinion> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void update(RateOpinion rateOpinion, RateValueEnum valueEnum) {
        var existingRate = repository.findByRateValueEnum(valueEnum).orElseThrow(NotFoundException::new);
        mapper.updateRateOpinion(rateOpinion, existingRate);
        repository.save(existingRate);
    }

    @Override
    public void delete(RateValueEnum valueEnum) {
        repository.deleteByRateValueEnum(valueEnum);
    }

    @Override
    public void addKey(KeyQueryParam queryParam) { repository.addKey(queryParam);}

    @Override
    public void removeKey(KeyQueryParam queryParam) {
        repository.removeKey(queryParam);
    }

}
