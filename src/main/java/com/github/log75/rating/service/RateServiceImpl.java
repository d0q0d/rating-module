package com.github.log75.rating.service;

import com.github.log75.rating.model.Rate;
import com.github.log75.rating.repository.RateRepository;
import com.github.log75.rating.service.mapper.RateServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 */
@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {

    private final RateRepository repository;
    private final RateServiceMapper mapper;

    @Override
    public void create(Rate rate) {
        repository.save(rate);
    }

    @Override
    public Rate get(String id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public Page<Rate> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void update(Rate newRate, String id) {
        var existingRate = repository.findById(id).orElseThrow();
        mapper.updateRate(newRate, existingRate);
        repository.save(existingRate);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Rate findByRelatedIdAndSubscriberId(String relatedId, String subscriberId) {
        return repository.findByRelatedIdAndSubscriberId(relatedId, subscriberId);
    }

}
