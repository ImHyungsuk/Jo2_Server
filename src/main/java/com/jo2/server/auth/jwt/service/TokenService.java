package com.jo2.server.auth.jwt.service;

import com.jo2.server.auth.exception.AuthException;
import com.jo2.server.auth.jwt.domain.Token;
import com.jo2.server.auth.jwt.repository.TokenRepository;
import com.jo2.server.auth.message.ErrorCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenRepository tokenRepository;

    @Transactional
    public void saveRefreshToken(
            final Long userId,
            final String refreshToken
    ) {
        tokenRepository.save(
                Token.of(
                        userId,
                        refreshToken
                )
        );
    }

    public Long findIdByRefreshToken(
            final String refreshToken
    ) {
        Token token = tokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(
                        () -> new AuthException(ErrorCode.REFRESH_TOKEN_NOT_FOUND)
                );
        return token.getId();
    }

    @Transactional
    public void deleteRefreshToken(
            final Long userId
    ) {
        Token token = tokenRepository.findById(userId).orElseThrow(
                () -> new AuthException(ErrorCode.REFRESH_TOKEN_NOT_FOUND)
        );
        tokenRepository.delete(token);
    }
}
