package com.snommensen.user;

import com.snommensen.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

    User user;

    @Before
    public void setUp() {
        user = User.make("Peter", "Fox", "peter.fox@bla.com");
    }

    @Test
    public void save_userIsSaved() throws Exception {
        User savedUser = userService.save(user);

        User foundUser = userService.find(savedUser.getId());

        assertThat(foundUser, notNullValue());
        assertThat(foundUser.getFirstName(), equalTo(user.getFirstName()));
        assertThat(foundUser.getLastName(), equalTo(user.getLastName()));
        assertThat(foundUser.getEmailAddress(), equalTo(user.getEmailAddress()));
    }

}
