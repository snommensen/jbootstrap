package com.snommensen.user

import com.snommensen.AppConfig
import com.snommensen.user.User
import com.snommensen.user.AppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@ContextConfiguration(classes = [AppConfig.class])
@Transactional
class AppServiceSpecification extends Specification {

    @Autowired
    AppService appService
    User user

    def setup() {
        user = User.make("Peter", "Fox", "peterfox@bla.com")
    }

    def "when saving a user then the same user can be found again by its id"() {
        when:
        def savedUser = appService.save(user)
        def foundUser = appService.find(savedUser.getId())

        then:
        foundUser != null
        foundUser.firstName == savedUser.firstName
        foundUser.lastName == savedUser.lastName
        foundUser.emailAddress == savedUser.emailAddress
    }
}