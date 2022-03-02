package com.github.log75.rating.api.dto;

import com.github.log75.rating.model.RateValueEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Set;

import static com.github.log75.rating.util.Constants.*;

@Data
public class CreateRateOpinionDto {
    @NotNull(message = RATE_VALUE_ENUM_ERROR)
    private RateValueEnum rateValueEnum;

    @ApiModelProperty(value = TITLE_MODEL_PROPERTY, example = TITLE_MODEL_PROPERTY_EXAMPLE)
    private String title;

    @ApiModelProperty(value = DESCRIPTION_MODEL_PROPERTY, example = DESCRIPTION_MODEL_PROPERTY_EXAMPLE)
    private String description;

    @ApiModelProperty(value = POSITIVE_OPINION_MODEL_PROPERTY, example = POSITIVE_OPINION_MODEL_PROPERTY_EXAMPLE, position = 3)
    private Set<String> positiveOpinions;

    @ApiModelProperty(value = NEGATIVE_OPINION_MODEL_PROPERTY, example = NEGATIVE_OPINION_MODEL_PROPERTY_EXAMPLE, position = 4)
    private Set<String> negativeOpinions;
}
