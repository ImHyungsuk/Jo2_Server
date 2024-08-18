package com.jo2.server.auth.service;

import com.jo2.server.auth.dto.request.UserSignInRequest;
import com.jo2.server.auth.dto.response.ReissueGetResponse;
import com.jo2.server.auth.dto.response.SignInGetResponse;
import com.jo2.server.auth.jwt.JwtTokenProvider;
import com.jo2.server.auth.jwt.service.TokenService;
import com.jo2.server.auth.social.SocialType;
import com.jo2.server.auth.strategy.SignInStrategyManager;
import com.jo2.server.auth.strategy.dto.UserInfoResponse;
import com.jo2.server.member.adapter.MemberCreator;
import com.jo2.server.member.adapter.MemberFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final SignInStrategyManager loginStrategyManager;
    private final MemberFinder memberFinder;
    private final MemberCreator memberCreator;
    private final JwtTokenProvider jwtTokenProvider;
    private final TokenService tokenService;

    public SignInGetResponse create(
            final String authorizationCode,
            final UserSignInRequest signInRequest
    ){
        return getTokenDto(getUserInfoResponse(authorizationCode, signInRequest));
    }
    public ReissueGetResponse refreshToken(
            final String refreshToken
    ) {
        final Long userId = tokenService.findIdByRefreshToken(refreshToken);

        return ReissueGetResponse.from(
                jwtTokenProvider.issueAccessToken(userId)
        );
    }

    public UserInfoResponse getUserInfoResponse(
            final String authorizationCode,
            final UserSignInRequest signInRequest
    ) {
        return switch (signInRequest.socialType()) {
            case KAKAO ->
                    loginStrategyManager.getLoginStrategy(SocialType.KAKAO).login(authorizationCode, signInRequest);
            case GOOGLE ->
                    loginStrategyManager.getLoginStrategy(SocialType.GOOGLE).login(authorizationCode, signInRequest);
        };
    }

    private SignInGetResponse getTokenDto(
            final UserInfoResponse userResponse
    ) {
        try {
            if (memberFinder.isExistingUser(userResponse.socialId(), userResponse.socialType())) {
                return getTokenByUserId(memberFinder.getBySocialId(userResponse.socialId(), userResponse.socialType()).getId());
            } else {
                Long id = memberCreator.createMember(userResponse.socialId(), userResponse.socialType(), userResponse.email());
                return getTokenByUserId(id);
            }
        } catch (DataIntegrityViolationException e) {
            return getTokenByUserId(memberFinder.getBySocialId(userResponse.socialId(), userResponse.socialType()).getId());
        }
    }

    public SignInGetResponse getTokenByUserId(
            final Long id
    ) {
        String refreshToken = jwtTokenProvider.issueRefreshToken(id);
        tokenService.saveRefreshToken(id, refreshToken);
        return SignInGetResponse.of(
                jwtTokenProvider.issueAccessToken(id),
                refreshToken
        );
    }
}