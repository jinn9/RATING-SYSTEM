package com.github.jinn9.rating_system.controller;

import com.github.jinn9.rating_system.domain.Business;
import com.github.jinn9.rating_system.dto.BusinessDto;
import com.github.jinn9.rating_system.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/businesses")
@RestController
public class BusinessController {

    private final BusinessService businessService;

    @GetMapping
    public Page<BusinessDto.Response> findBusiness(Pageable pageable) {
        Page<Business> page = businessService.findBusinesses(pageable);
        return page.map(BusinessDto.Response::of);
    }

}
