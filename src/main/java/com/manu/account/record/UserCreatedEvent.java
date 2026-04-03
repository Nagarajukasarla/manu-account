package com.manu.account.record;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserCreatedEvent(
        String userId,
        String email,
        String name
//        LocalDateTime createdAt
) {}