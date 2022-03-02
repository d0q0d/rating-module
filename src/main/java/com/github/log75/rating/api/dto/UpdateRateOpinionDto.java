package com.github.log75.rating.api.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UpdateRateOpinionDto {
    private String title;
    private String description;
    private Set<String> positiveOpinions;
    private Set<String> negativeOpinions;
}
