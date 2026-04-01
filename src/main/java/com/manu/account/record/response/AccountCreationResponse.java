package com.manu.account.record.response;

import lombok.Builder;

import java.util.Optional;

@Builder
public record AccountCreationResponse(String userId, Optional<String> error) {}
