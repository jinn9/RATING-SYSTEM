package com.github.jinn9.rating_system.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(exclude = {"member", "business"})
@Entity
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    private Business business;

    private String comment;
}
