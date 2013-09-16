package com.snommensen.service

import com.snommensen.AppConfig
import com.snommensen.domain.User
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = [AppConfig.class])
@Transactional
class SecondAppServiceTest extends Specification {

    @Autowired
    AppService appService
    User user

    @Before
    public void makeUser() {
        user = User.make("Peter", "Fox", "peter@fox@googlemail.com")
    }

    @Test
    def "when saving a user then the same user can be retrieved"() {
        when:
        def savedUser = appService.save(user);
        def foundUser = appService.find(savedUser.getId());

        then:
        foundUser != null
        foundUser.firstName == savedUser.firstName
        foundUser.lastName == savedUser.lastName
        foundUser.emailAddress == savedUser.emailAddress
    }
}