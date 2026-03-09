package com.portfolio.joboffers.domain.loginandregister;

import lombok.Builder;

@Builder
public record UserDto(String username, String password) {
}
