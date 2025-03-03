package com.github.jinn9.rating_system.repository;

import com.github.jinn9.rating_system.domain.Business;
import com.github.jinn9.rating_system.dto.BusinessDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.github.jinn9.rating_system.domain.QBusiness.*;

public class BusinessCustomRepositoryImpl implements BusinessCustomRepository {

    private final JPAQueryFactory queryFactory;

    public BusinessCustomRepositoryImpl(EntityManager em) {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<BusinessDto.Response> findAll(Pageable pageable, BusinessDto.Request filterParams) {
        List<Business> content = queryFactory
                .selectFrom(business)
                .where(
                        nameEq(filterParams.getName()),
                        cityEq(filterParams.getCity()),
                        countryEq(filterParams.getCountry()),
                        descriptionLike(filterParams.getDescription())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<BusinessDto.Response> dtoContent = content.stream()
                .map(BusinessDto.Response::of)
                .toList();

        JPAQuery<Long> countQuery = queryFactory
                .select(business.count())
                .from(business)
                .where(
                        nameEq(filterParams.getName()),
                        cityEq(filterParams.getCity()),
                        countryEq(filterParams.getCountry()),
                        descriptionLike(filterParams.getDescription())
                )
                .where();

        return PageableExecutionUtils.getPage(dtoContent, pageable, countQuery::fetchOne);
    }

    public BooleanExpression nameEq(String name) {
        return StringUtils.hasText(name) ? business.name.equalsIgnoreCase(name) : null;
    }

    public BooleanExpression cityEq(String city) {
        return StringUtils.hasText(city) ? business.address.city.equalsIgnoreCase(city) : null;
    }

    public BooleanExpression countryEq(String country) {
        return StringUtils.hasText(country) ? business.address.country.equalsIgnoreCase(country) : null;
    }

    public BooleanExpression descriptionLike(String description) {
        return StringUtils.hasText(description) ? business.description.like('%' + description + '%') : null;
    }
}
