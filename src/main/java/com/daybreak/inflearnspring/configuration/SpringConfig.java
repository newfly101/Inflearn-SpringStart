package com.daybreak.inflearnspring.configuration;

import com.daybreak.inflearnspring.repository.MemberRepository;
import com.daybreak.inflearnspring.repository.MemoryMemberRepository;
import com.daybreak.inflearnspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
