package com.github.jinn9.rating_system.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = {"member", "business"})
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"member_id", "business_id"})})
@Entity
public class Rating {

    @Id @GeneratedValue
    @Column(name = "rating_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    private Business business;

    private double rating;
}
