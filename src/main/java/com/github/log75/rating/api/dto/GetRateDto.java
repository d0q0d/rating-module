package com.github.log75.rating.api.dto;

import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class GetRateDto {
    private String id;
    private Integer value;
    private String relatedId;
    private String comment;
    private Set<String> positiveOpinions;
    private Set<String> negativeOpinions;
    private Map<String, Object> metaData;
}
