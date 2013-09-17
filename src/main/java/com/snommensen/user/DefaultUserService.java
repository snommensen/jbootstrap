package com.snommensen.user;

import com.snommensen.annotation.TransactionalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.util.Assert.notNull;

@TransactionalService
public class DefaultUserService implements UserService {

    final static Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);
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
