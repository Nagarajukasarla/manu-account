package com.manu.account.service.implementation;

import com.manu.account.enums.ACCOUNT_TYPE;
import com.manu.account.model.Account;
import com.manu.account.record.UserCreatedEvent;
import com.manu.account.record.response.AccountCreationResponse;
import com.manu.account.repository.AccountRepository;
import com.manu.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImplementation implements AccountService {

    private final AccountRepository repository;

    @Override
    public AccountCreationResponse createDefaultAccount(UserCreatedEvent event) {
        String userId = event.userId();

        try {
            if (repository.existsByUserId(userId)) {
                log.info("Account already exists for user {}", userId);
                return AccountCreationResponse.builder()
                        .userId(userId)
                        .error(Optional.of("User Already Exists"))
                        .build();
            }

            var account = Account.builder()
                    .userId(userId)
                    .balance(0.0)
                    .accountType(ACCOUNT_TYPE.SAVINGS)
                    .build();

            repository.save(account);
            log.info("Account created for user {}", userId);

            return AccountCreationResponse.builder()
                    .userId(userId)
                    .error(Optional.empty())
                    .build();
        }
        catch (DataIntegrityViolationException ex) {
            log.warn("Duplicate event received for user {}. Ignoring.", userId);
            return AccountCreationResponse.builder()
                    .userId(userId)
                    .error(Optional.of("User Already Exists"))
                    .build();
        }
    }
}
