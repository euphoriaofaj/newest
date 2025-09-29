package com.morago.backend.dto.tokens;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request containing a refresh token to generate a new access token")
public class RefreshTokenRequest {

    @Schema(description = "Valid refresh token", example = "dGhpc2lzYXJlZnJlc2h0b2tlbg==", requiredMode = Schema.RequiredMode.REQUIRED)
    private String refreshToken;
}
