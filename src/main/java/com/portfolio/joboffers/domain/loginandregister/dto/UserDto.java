package com.portfolio.joboffers.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserDto(String id, String username, String password) {
}
