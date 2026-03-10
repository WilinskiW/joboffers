package com.portfolio.joboffers.domain.loginandregister;

import lombok.AllArgsConstructor;
import static com.portfolio.joboffers.domain.loginandregister.UserMapper.*;

@AllArgsConstructor
public class LoginAndRegisterFacade {
    private final UserRepository userRepository;

    public Long register(final UserDto userDto) {
        if(userDto.username().isEmpty() || userDto.password().isEmpty()) {
            throw new UserRegistrationException("Failed to register user");
        }

        var user = mapUserDtoToUser(userDto);
        return userRepository.save(user);
    }

    public UserDto findByUsername(final String username){
        var user = userRepository.findByUsername(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }

        return mapUserToUserDto(user.get());
    }
}
