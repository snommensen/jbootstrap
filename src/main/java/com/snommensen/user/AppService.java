package com.snommensen.user;

public interface AppService {
    User find(long id);

    User save(User user);
}
