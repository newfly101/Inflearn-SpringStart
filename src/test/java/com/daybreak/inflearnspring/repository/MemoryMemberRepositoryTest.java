package com.daybreak.inflearnspring.repository;

import com.daybreak.inflearnspring.model.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("kimJaeHong");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = {}"+ (result == member)); // true

        assertEquals(member, result); // true 시 결과물 출력x
        assertThat(member).isEqualTo(result); // check하는 방식3
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("KimDawn");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("KimSpace");
        repository.save(member2);

        Member result = repository.findByName("KimDawn").get();

        assertThat(result).isSameAs(member1);
    }
}
