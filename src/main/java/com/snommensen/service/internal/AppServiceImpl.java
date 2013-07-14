package com.snommensen.service.internal;

import com.snommensen.annotation.ApplicationService;
import com.snommensen.domain.User;
import com.snommensen.repository.UserRepository;
import com.snommensen.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.util.Assert.notNull;

@ApplicationService
public class AppServiceImpl implements AppService {

    final static Logger LOG = LoggerFactory.getLogger(AppServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    @Override
    public User find(long id) {
        LOG.info("find( id=" + id + " )");
        User user = userRepository.findOne(id);
        LOG.debug("found: " + user);
        return user;
    }

    @Override
    public User save(User user) {
        notNull(user, "Given user is null!");
        User savedUser = userRepository.save(user);
        LOG.debug("saved: " + savedUser);
        return savedUser;
    }
}
