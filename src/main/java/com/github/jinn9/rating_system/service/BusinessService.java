package com.github.jinn9.rating_system.service;

import com.github.jinn9.rating_system.domain.Business;
import com.github.jinn9.rating_system.repository.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public Page<Business> findBusinesses(Pageable pageable) {
        return businessRepository.findAll(pageable);
    }
}
