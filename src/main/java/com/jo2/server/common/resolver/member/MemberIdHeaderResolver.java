package com.jo2.server.common.resolver.member;

import com.jo2.server.auth.exception.AuthException;
import com.jo2.server.auth.jwt.JwtTokenProvider;
import com.jo2.server.auth.jwt.JwtValidationType;
import com.jo2.server.auth.message.ErrorCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@RequiredArgsConstructor
@Component
public class MemberIdHeaderResolver implements HandlerMethodArgumentResolver {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(MemberId.class) && Long.class.equals(parameter.getParameterType());
    }

    @Override
    public Long resolveArgument(@NotNull MethodParameter parameter, ModelAndViewContainer modelAndViewContainer, @NotNull NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

        if (request.getMethod().equals("OPTIONS")) {
            return null;
        }

        final String token = request.getHeader("Authorization");

        if (!jwtTokenProvider.validateToken(token).equals(JwtValidationType.VALID_JWT)) {
            throw new AuthException(ErrorCode.AUTHENTICATION_CODE_EXPIRED);
        }

        return jwtTokenProvider.getUserFromJwt(token);
    }

}