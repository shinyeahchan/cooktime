package com.side.cooktime.domain.member.controller;

import com.side.cooktime.domain.member.model.Admin;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.model.Role;
import com.side.cooktime.domain.member.model.User;
import com.side.cooktime.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {
    private final MemberService memberService;

    @ResponseBody
    @GetMapping(value = "/member/role")
    public String getMemberRole(@RequestParam("memberEmail") String memberEmail) {
        log.info("getMemberRole");
        Member member = memberService.findByEmail(memberEmail);

        if (member instanceof User) {
            return Role.USER.name();
        }
        if (member instanceof Admin) {
            return Role.ADMIN.name();
        }

        return "Not Member ("+memberEmail+")";
    }
}
