package com.github.jinn9.rating_system.dto;

import com.github.jinn9.rating_system.domain.Address;
import com.github.jinn9.rating_system.domain.Business;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class BusinessDto {

    @Builder
    @AllArgsConstructor
    @Data
    public static class Response {
        private Long id;
        private String name;
        private Address address;
        private String phoneNumber;
        private String description;

        public static Response of(Business business) {
            return Response.builder()
                    .id(business.getId())
                    .name(business.getName())
                    .address(business.getAddress())
                    .phoneNumber(business.getPhoneNumber())
                    .description(business.getDescription())
                    .build();
        }

    }
}
