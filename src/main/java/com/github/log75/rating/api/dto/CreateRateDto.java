package com.github.log75.rating.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

import static com.github.log75.rating.util.Constants.*;

@Data
public class CreateRateDto {
    @ApiModelProperty(value = VALUE_MODEL_PROPERTY, example = VALUE_MODEL_PROPERTY_EXAMPLE, position = 0)
    @NotNull(message = RATE_VALUE_ERROR) @Min(1) @Max(5)
    private Integer value;

    @ApiModelProperty(value = RELATED_MODEL_PROPERTY, example = RELATED_MODEL_PROPERTY_EXAMPLE, position = 1)
    @NotNull(message = RELATED_ID_ERROR)
    private String relatedId;

    @ApiModelProperty(value = COMMENT_MODEL_PROPERTY, example = COMMENT_MODEL_PROPERTY_EXAMPLE, position = 2)
    private String comment;

    @ApiModelProperty(value = POSITIVE_OPINION_MODEL_PROPERTY, example = POSITIVE_OPINION_MODEL_PROPERTY_EXAMPLE, position = 3)
    private Set<String> positiveOpinions;

    @ApiModelProperty(value = NEGATIVE_OPINION_MODEL_PROPERTY, example = NEGATIVE_OPINION_MODEL_PROPERTY_EXAMPLE, position = 4)
    private Set<String> negativeOpinions;

    @ApiModelProperty(dataType = "java.util.HashMap")
    private Map<String, Object> metaData;
}
