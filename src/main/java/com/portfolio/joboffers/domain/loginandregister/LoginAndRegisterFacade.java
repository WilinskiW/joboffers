package com.portfolio.joboffers.domain.loginandregister;

import com.portfolio.joboffers.domain.loginandregister.dto.RegisterUserDto;
import com.portfolio.joboffers.domain.loginandregister.dto.RegistrationResultDto;
import com.portfolio.joboffers.domain.loginandregister.dto.UserDto;
import lombok.AllArgsConstructor;
import static com.portfolio.joboffers.domain.loginandregister.UserMapper.*;

@AllArgsConstructor
public class LoginAndRegisterFacade {
    private final static String USERNAME_NOT_FOUND_MESSAGE = "Username not found";

    private final UserRepository userRepository;

    public RegistrationResultDto register(final RegisterUserDto userDto) {
        User user = mapUserDtoToUser(userDto);
        var savedUser = userRepository.save(user);
        return RegistrationResultDto.builder()
                .id(savedUser.id())
                .username(savedUser.username())
                .build();
    }

    public UserDto findByUsername(final String username){
        return userRepository.findByUsername(username)
                .map(UserMapper::mapUserToUserDto)
                .orElseThrow(() -> new UsernameNotFoundException(USERNAME_NOT_FOUND_MESSAGE));
    }
}
