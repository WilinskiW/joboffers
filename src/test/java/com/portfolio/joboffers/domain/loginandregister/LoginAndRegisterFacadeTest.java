package com.portfolio.joboffers.domain.loginandregister;

import com.portfolio.joboffers.domain.loginandregister.dto.RegisterUserDto;
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
        RegisterUserDto testUser = new RegisterUserDto("testuser", "12345");
        //when
        var user = loginAndRegisterFacade.register(testUser);
        //then
        assertThat(user.id()).isNotNull();
        assertThat(user.username()).isEqualTo("testuser");
    }

    @Test
    @DisplayName("Should find user by user name")
    public void should_find_user_by_user_name() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        RegisterUserDto testUser = new RegisterUserDto("testuser", "12345");
        loginAndRegisterFacade.register(testUser);
        //when
        var userDto = loginAndRegisterFacade.findByUsername(testUser.username());
        //then
        assertThat(userDto.id()).isNotNull();
        assertThat(userDto.username()).isEqualTo("testuser");
        assertThat(userDto.password()).isEqualTo("12345");
    }

    @Test
    @DisplayName("Should throw exception when user not found")
    public void should_throw_exception_when_user_not_found() {
        //given
        LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(new InMemoryUserRepositoryImpl());
        RegisterUserDto testUser = new RegisterUserDto("testuser", "12345");
        //when & then
        assertThatThrownBy(() -> loginAndRegisterFacade.findByUsername(testUser.username()))
                .isInstanceOf(UsernameNotFoundException.class)
                .hasMessage("Username not found");
    }
}