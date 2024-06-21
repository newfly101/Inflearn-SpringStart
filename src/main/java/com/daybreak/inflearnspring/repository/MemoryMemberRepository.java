package com.daybreak.inflearnspring.repository;

import com.daybreak.inflearnspring.model.Member;

import java.util.List;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository {



    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }
}
