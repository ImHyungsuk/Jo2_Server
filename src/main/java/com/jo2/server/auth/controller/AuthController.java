package com.jo2.server.auth.controller;

import static com.jo2.server.auth.message.SuccessMessage.SUCCESS_SIGN_IN_INFOR;
import static com.jo2.server.common.dto.SuccessResponse.success;
import com.jo2.server.auth.dto.request.UserSignInRequest;
import com.jo2.server.auth.dto.response.ReissueGetResponse;
import com.jo2.server.auth.dto.response.SignInGetResponse;
import com.jo2.server.auth.service.AuthService;
import com.jo2.server.common.dto.SuccessResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/sign-in")
    public ResponseEntity<SuccessResponse<SignInGetResponse>> signIn(
            @RequestParam final String authorizationCode,
            @RequestBody final UserSignInRequest signInRequest
    ){
        SignInGetResponse response = authService.create(authorizationCode,signInRequest);
        return ResponseEntity.ok().body(success(SUCCESS_SIGN_IN_INFOR.getMessage(), response));
    }

    @GetMapping("/refresh-token")
    public ResponseEntity<SuccessResponse<ReissueGetResponse>> refreshToken(
            @RequestHeader final String refreshToken
    ) {
        ReissueGetResponse response = authService.refreshToken(refreshToken);
        return ResponseEntity.ok().body(success(SUCCESS_SIGN_IN_INFOR.getMessage(), response));
    }
}
