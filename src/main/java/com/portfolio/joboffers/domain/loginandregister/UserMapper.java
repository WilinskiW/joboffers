package com.portfolio.joboffers.domain.loginandregister;

import com.portfolio.joboffers.domain.loginandregister.dto.RegisterUserDto;
import com.portfolio.joboffers.domain.loginandregister.dto.UserDto;

class UserMapper {
    static User mapUserDtoToUser(final RegisterUserDto userDto){
        return User.builder()
                .username(userDto.username())
                .password(userDto.password())
                .build();
    }

    static UserDto mapUserToUserDto(final User user){
        return UserDto.builder()
                .id(user.id())
                .username(user.username())
                .password(user.password())
                .build();
    }
}
