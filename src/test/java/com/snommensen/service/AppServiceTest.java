package com.snommensen.service;

import com.snommensen.AppConfig;
import com.snommensen.domain.User;
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
public class AppServiceTest {

    @Autowired
    AppService appService;

    @Test
    public void find() throws Exception {
        User user = new User("Peter", "Fox", "peter.fox@bla.com");
        User savedUser = appService.save(user);
        User foundUser = appService.find(savedUser.getId());
        assertThat(foundUser, notNullValue());
        assertThat(foundUser.getFirstName(), equalTo(user.getFirstName()));
        assertThat(foundUser.getLastName(), equalTo(user.getLastName()));
        assertThat(foundUser.getEmailAddress(), equalTo(user.getEmailAddress()));
    }

}
