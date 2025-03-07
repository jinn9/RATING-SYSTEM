package com.github.jinn9.rating_system.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
public class Business {

    @Id @GeneratedValue
    @Column(name = "business_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // todo: validate
    private String phoneNumber;

    private String description;

}
