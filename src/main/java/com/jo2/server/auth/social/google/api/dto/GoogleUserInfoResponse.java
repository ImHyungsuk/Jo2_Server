package com.jo2.server.auth.social.google.api.dto;

public record GoogleUserInfoResponse(
        String id,
        String email,
        String picture
) {
}