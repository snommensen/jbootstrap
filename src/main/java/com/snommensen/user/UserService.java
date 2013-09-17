package com.snommensen.user;

public interface UserService {
    User find(long id);

    User save(User user);
}
