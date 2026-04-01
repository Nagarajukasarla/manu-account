package com.manu.account.service;

import com.manu.account.record.UserCreatedEvent;
import com.manu.account.record.response.AccountCreationResponse;

public interface AccountService {
    AccountCreationResponse createDefaultAccount(UserCreatedEvent event);
}
