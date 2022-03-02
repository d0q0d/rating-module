package com.github.log75.rating.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class KeyQueryParam {
    @NotNull
    private RateValueEnum valueEnum;
    @NotNull
    private RateStatusEnum statusEnum;
    @NotBlank
    private String key;
}
