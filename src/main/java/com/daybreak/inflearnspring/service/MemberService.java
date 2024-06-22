package com.daybreak.inflearnspring.service;

import com.daybreak.inflearnspring.model.Member;
import com.daybreak.inflearnspring.repository.MemberRepository;
import com.daybreak.inflearnspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     **/
    public long join(Member member) {
        // 같은 이름이 있는 중복 회원x
//        Optional<Member> result = memberRepository.findByName(member.getName()); // Optional을 꺼낼때 다음과 같이 진행
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /** 전체 회원 조회 **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(long memberId) {
        return memberRepository.findById(memberId);
    }
}
