package com.side.cooktime.domain.member.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.side.cooktime.domain.member.model.Member;
import com.side.cooktime.domain.member.model.dto.GoogleUserInfo;
import com.side.cooktime.domain.member.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("/api/v1")
public class GoogleLoginController {

    private final String GRANT_TYPE = "authorization_code";
    private final String REDIRECT_URI = "http://localhost/api/v1/callback";
    private final String ACCESS_TOKEN_URL = "https://oauth2.googleapis.com/token";
    private final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo";

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String CLIENT_SECRET;

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String CLIENT_ID;

    private final MemberRepository memberRepository;

    public GoogleLoginController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //임시
    //https://accounts.google.com/o/oauth2/v2/auth?response_type=code&client_id=595159133596-ibjnkksdef8bumsndm9vjn0cd4790jtr.apps.googleusercontent.com&scope=email%20profile%20https://www.googleapis.com/auth/user.gender.read%20https://www.googleapis.com/auth/user.birthday.read&redirect_uri=http://localhost/api/v1/callback
    @GetMapping(value = "/callback")
    public String GoogleSignCallback(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String code = request.getParameter("code");
        log.info("## [REQUEST] code : {}", request.getParameter("code"));
        return code;
    }

    @PostMapping(value = "/google-login")
    public String googleLogin(@RequestBody Map<String, String> requestMap) throws Exception {
        log.info("## [REQUEST] authorizationCode : {}", requestMap.get("authorizationCode"));
        String accessToken = getGoogleAccessToken(requestMap.get("authorizationCode"));
        GoogleUserInfo googleUserInfo = getUserInfo(accessToken);

        Optional<Member> optionalMember = memberRepository.findByEmail(googleUserInfo.getEmail());

        if(optionalMember.isEmpty()){
            //TODO
            log.info("회원가입 진행 및 JWT Response");
            String provider = "google";
            String providerId = googleUserInfo.getId();

        }else{
            //TODO
            log.info("JWT Response");
        }

        return googleUserInfo.getEmail();
    }

    private GoogleUserInfo getUserInfo(String accessToken) {
        URI uri = URI.create(USER_INFO_URL+"?access_token="+ accessToken);
        RestTemplate restTemplate = new RestTemplate();
        GoogleUserInfo googleUserInfo = null;
        try {
            googleUserInfo = restTemplate.getForObject(uri, GoogleUserInfo.class);
        } catch (HttpClientErrorException e) {
            //TODO: 예외처리
            log.error("API 요청 실패 / URI : {} / StatusCode : {} / ResponseBody : {}", USER_INFO_URL, e.getStatusCode(), e.getResponseBodyAsString());
        }
        log.info("GoogleUserInfo : {}", googleUserInfo);
        return googleUserInfo;
    }


    /**
     * Access Token 처리 (+획득)
     *
     * @param authorizationCode
     * @return Access Token 값
     * @throws Exception
     */
    private String getGoogleAccessToken(String authorizationCode) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("code", authorizationCode);
        requestBody.add("client_id", CLIENT_ID);
        requestBody.add("client_secret", CLIENT_SECRET);
        requestBody.add("redirect_uri", REDIRECT_URI);
        requestBody.add("grant_type", GRANT_TYPE);

        HttpEntity<MultiValueMap<String, String>> restRequest = new HttpEntity<>(requestBody, headers);

        URI uri = URI.create(ACCESS_TOKEN_URL);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity;

        try {
            responseEntity = restTemplate.postForEntity(uri, restRequest, String.class);
        } catch (HttpClientErrorException e) {
            //TODO: 예외처리
            log.error("API 요청 실패 / URI : {} / StatusCode : {} / ResponseBody : {}", ACCESS_TOKEN_URL, e.getStatusCode(), e.getResponseBodyAsString());
            return e.getResponseBodyAsString();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseEntity.getBody());
        String accessToken = jsonNode.get("access_token").asText();
        log.info("Access Token : {}", accessToken);
        return accessToken;
    }


}
