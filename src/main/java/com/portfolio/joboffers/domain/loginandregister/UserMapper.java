package com.portfolio.joboffers.domain.loginandregister;

class UserMapper {
    static User mapUserDtoToUser(final UserDto userDto){
        return User.builder()
                .username(userDto.username())
                .password(userDto.password())
                .build();
    }

    static UserDto mapUserToUserDto(final User user){
        return UserDto.builder()
                .username(user.username())
                .password(user.password())
                .build();
    }
}
