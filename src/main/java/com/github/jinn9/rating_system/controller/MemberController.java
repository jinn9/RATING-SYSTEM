package com.github.jinn9.rating_system.controller;

import com.github.jinn9.rating_system.domain.Member;
import com.github.jinn9.rating_system.dto.Response;
import com.github.jinn9.rating_system.dto.SignUpDto;
import com.github.jinn9.rating_system.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Response signUp(@RequestBody SignUpDto signUpDto) {
        Member member = new Member(signUpDto.getEmail(), signUpDto.getPassword());
        memberService.signUp(member);
        return new Response("User created");
    }
}
