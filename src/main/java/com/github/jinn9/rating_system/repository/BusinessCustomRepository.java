package com.github.jinn9.rating_system.repository;

import com.github.jinn9.rating_system.dto.BusinessDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BusinessCustomRepository {
    Page<BusinessDto.Response> findAll(Pageable pageable, BusinessDto.Request filterParams);
}
