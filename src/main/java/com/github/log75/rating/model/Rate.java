package com.github.log75.rating.model;

import com.vasl.ario.crudutil.entity.Entity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;

@Data
@Document("rating.rate")
public class Rate extends Entity {
    private Integer value;
    private String relatedId;
    private String subscriberId;
    private String comment;
    private Set<String> positiveOpinions;
    private Set<String> negativeOpinions;
    private Map<String, Object> metaData;
}
