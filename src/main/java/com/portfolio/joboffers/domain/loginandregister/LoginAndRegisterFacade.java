package com.portfolio.joboffers.domain.loginandregister;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginAndRegisterFacade {
    private final UserRepository userRepository;

    public Long register(final UserDto userDto) {
        if(userDto.username().isEmpty() || userDto.password().isEmpty()) {
            throw new UserRegistrationException("Failed to register user");
        }

        User user = UserMapper.mapUserDtoToUser(userDto);
        return userRepository.save(user);
    }

    public String login(final UserDto userDto){
        var user = userRepository.findByUsername(userDto.username());

        if(user.isEmpty()){
            throw new UsernameNotFoundException("Username not found");
        }

        if(!user.get().password().equals(userDto.password())){
            throw new IncorrectPasswordException("Bad password");
        }

        return "success";
    }
}
