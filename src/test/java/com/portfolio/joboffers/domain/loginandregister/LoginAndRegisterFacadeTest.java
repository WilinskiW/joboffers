package com.portfolio.joboffers.domain.loginandregister;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LoginAndRegisterFacadeTest {
    @Test
    @DisplayName("Should register user")
    public void should_register_user() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("testuser", "12345");
        //when
        Long added_user_id = loginAndRegisterFacade.register(testUser);
        //then
        assertThat(added_user_id).isEqualTo(1);
    }

    @Test
    @DisplayName("Should throw exception when registration failed")
    public void should_throw_exception_when_registration_failed() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("", "");
        //when & then
        assertThatThrownBy(() -> loginAndRegisterFacade.register(testUser))
                .isInstanceOf(UserRegistrationException.class)
                .hasMessage("Failed to register user");
    }

    @Test
    @DisplayName("Should find user by user name")
    public void should_find_user_by_user_name() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("testuser", "12345");
        loginAndRegisterFacade.register(testUser);
        //when
        UserDto userDto = loginAndRegisterFacade.findByUsername(testUser.username());
        //then
        assertThat(userDto.username()).isEqualTo("testuser");
        assertThat(userDto.password()).isEqualTo("12345");
    }

    @Test
    @DisplayName("Should throw exception when user not found")
    public void should_throw_exception_when_user_not_found() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        UserDto testUser = new UserDto("testuser", "12345");
        //when & then
        assertThatThrownBy(() -> loginAndRegisterFacade.findByUsername(testUser.username()))
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessage("Username not found");
    }
}