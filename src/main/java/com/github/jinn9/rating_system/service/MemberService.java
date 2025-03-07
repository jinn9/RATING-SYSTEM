package com.github.jinn9.rating_system.service;

import com.github.jinn9.rating_system.domain.Member;
import com.github.jinn9.rating_system.exception.DuplicateUserException;
import com.github.jinn9.rating_system.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(Member member) {
        Optional<Member> optional = memberRepository.findByEmail(member.getEmail());
        if (optional.isPresent()) {
            String exMsg = "Email already exists";
            throw new DuplicateUserException(exMsg);
        }

        String hashPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(hashPassword);
        memberRepository.save(member);
    }
}
