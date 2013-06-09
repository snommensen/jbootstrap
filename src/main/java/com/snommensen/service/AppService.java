package com.snommensen.service;

import com.snommensen.domain.User;

public interface AppService {
    User find(long id);

    User save(User user);
}
