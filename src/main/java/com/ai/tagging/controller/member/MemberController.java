package com.ai.tagging.controller.member;

import com.ai.tagging.entity.member.Member;
import com.ai.tagging.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/members")
    public String memberList(Model model) {
        List<Member> memberList = memberRepository.findAll();
        model.addAttribute("memberList", memberList);

        return null;
    }
}
