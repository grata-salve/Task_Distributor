package com.taskDistributor.security.oauth2;

import com.taskDistributor.util.CookieUtils;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final HttpCookieOAuth2AuthorizationRequestRepository httpCookieOAuth2AuthorizationRequestRepository;

    @Value("${app.cookie.redirectUriParamCookieName}")
    private String redirectUriParamCookieName;

    @Override
    public void onAuthenticationFailure(
        HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
        throws IOException {
        String targetUrl = CookieUtils.getCookie(request, redirectUriParamCookieName)
            .map(Cookie::getValue)
            .orElse(("/"));

        targetUrl = UriComponentsBuilder.fromUriString(targetUrl)
            .queryParam("error", exception.getLocalizedMessage())
            .build().toUriString();

        httpCookieOAuth2AuthorizationRequestRepository.removeAuthorizationRequestCookies(request,
            response);

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
