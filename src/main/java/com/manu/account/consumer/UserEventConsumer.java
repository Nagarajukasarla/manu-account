package com.manu.account.consumer;

import com.manu.account.record.UserCreatedEvent;
import com.manu.account.record.response.AccountCreationResponse;
import com.manu.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventConsumer {
    private final AccountService accountService;

    @KafkaListener(topics = "user-cerated-event", groupId = "account-group")
    public void consume(UserCreatedEvent event) {
        log.info("Received event for user: {}", event.userId());

        AccountCreationResponse response = accountService.createDefaultAccount(event);

        log.info("Account creation result: {}", response);
    }
}
