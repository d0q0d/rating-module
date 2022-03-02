package com.github.log75.rating.model;

import com.vasl.ario.crudutil.entity.Entity;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document("rating.opinion")
public class RateOpinion extends Entity {
    @Indexed(unique = true)
    private RateValueEnum rateValueEnum;
    private String title;
    private String description;
    private Set<String> positiveOpinions;
    private Set<String> negativeOpinions;
}
