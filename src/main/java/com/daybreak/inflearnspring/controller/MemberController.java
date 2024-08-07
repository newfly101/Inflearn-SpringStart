package com.daybreak.inflearnspring.controller;

import com.daybreak.inflearnspring.model.Member;
import com.daybreak.inflearnspring.model.MemberForm;
import com.daybreak.inflearnspring.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public ResponseEntity<MemberForm> create(@RequestBody MemberForm form) {
        log.info("Create member: {}", form.getName());
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        // JSON 형태로 반환
        return new ResponseEntity<>(form, HttpStatus.OK);

    }
    @GetMapping("/members")
    public ResponseEntity<List<Member>> list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
