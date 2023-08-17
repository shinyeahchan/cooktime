package com.side.cooktime.domain.member;

import com.side.cooktime.domain.member.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/v1")
public class GoogleLoginController {

    private final MemberRepository memberRepository;

    public GoogleLoginController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //임시
    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String GoogleSignCallback(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String code = request.getParameter("code");

        log.info("## [REQUEST] code ={}", request.getParameter("code"));
        try {
            /* Access Token 얻기 */
//            String accessToken = getGoogleAccessToken(request, response);
            /* 사용자 정보 얻기 */
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
        /* 임시 - 로그인 성공 창 */
        return code;
    }

}
