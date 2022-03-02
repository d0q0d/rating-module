package com.github.log75.rating.api.dto;

import com.github.log75.rating.model.RateValueEnum;
import lombok.Data;

import java.util.Set;

@Data
public class GetRateOpinionDto {
    private RateValueEnum rateValueEnum;
    private String title;
    private String description;
    private Set<String> positiveOpinions;
    private Set<String> negativeOpinions;
}
