package com.portfolio.joboffers.domain.loginandregister;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LoginAndRegisterFacadeTest {
    @Test
    public void should_add_new_user_when_registration_is_success() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("testuser", "12345");
        //when
        Long added_user_id = loginAndRegisterFacade.register(testUser);
        //then
        assertThat(added_user_id).isEqualTo(1);
    }

    @Test
    public void should_throw_exception_when_registration_failed() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("", "");
        //when
        //then
        assertThrows(RuntimeException.class, () -> loginAndRegisterFacade.register(testUser));

    }

    @Test
    public void should_be_success_when_user_exist_in_database() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("testuser", "12345");
        loginAndRegisterFacade.register(testUser);
        //when
        String outcome = loginAndRegisterFacade.login(testUser);
        //then
        assertThat(outcome).isEqualTo("success");
    }

    @Test
    public void should_throw_exception_when_user_doesnt_exist_in_database() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("testuser", "12345");
        //when
        //then
        assertThrows(UsernameNotFoundException.class, () -> loginAndRegisterFacade.login(testUser));

    }
}