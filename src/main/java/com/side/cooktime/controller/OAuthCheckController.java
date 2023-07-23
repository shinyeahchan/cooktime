package com.side.cooktime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class OAuthCheckController {

//    @Autowired
//    private OAuth2AuthorizedClientService authorizedClientService;

//    @GetMapping("/user")
//    public String getUserInfo(OAuth2AuthenticationToken authenticationToken) {
//        OAuth2AuthorizedClient client = authorizedClientService
//                .loadAuthorizedClient(
//                        authenticationToken.getAuthorizedClientRegistrationId(),
//                        authenticationToken.getName());
//
//        // 사용자의 프로필 정보를 가져오기 위해 Google의 UserInfo 엔드포인트에 요청을 보냅니다.
//        ResponseEntity<Map> response = new RestTemplate()
//                .exchange(client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri(),
//                        HttpMethod.GET,
//                        new HttpEntity<>(createHeaders(client.getAccessToken().getTokenValue())),
//                        Map.class);
//
//        System.out.println("uri : "+client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri());
//
//        // 응답에서 성별과 생일 정보 추출
//        String gender = (String) response.getBody().get("gender");
//        String birthday = (String) response.getBody().get("birthday");
//
//        // 성별과 생일 정보를 사용하여 처리하는 작업을 수행합니다.
//        return "성별: " + gender + ", 생일: " + birthday;
//    }

//    private HttpHeaders createHeaders(String accessToken) {
//        HttpHeaders headers = new HttpHeaders();
//
//        System.out.println("accessToken : "+accessToken);
//
//        headers.setBearerAuth(accessToken);
//        return headers;
//    }

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String loginRequest() {
        return "login";
    }

    @GetMapping("/user/main")
    public String userMain(Model model, OAuth2AuthenticationToken authentication) {
        System.out.println("/user/main");
        OAuth2User principal = authentication.getPrincipal();
        System.out.println(principal.getAttributes());
        model.addAttribute("userName", principal.getAttribute("name"));
        model.addAttribute("userEmail", principal.getAttributes().get("email"));
        model.addAttribute("userImageUrl", principal.getAttributes().get("picture"));
        model.addAttribute("userName", authentication.getName());
        return "main";
    }
}
