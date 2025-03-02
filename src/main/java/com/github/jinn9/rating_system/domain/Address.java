package com.github.jinn9.rating_system.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Address {
    private String addressLine;
    private String city;
    // todo: use enum
    private String province;
    // todo: validate
    private String postalCode;
    // todo: use enum
    private String country;
}
