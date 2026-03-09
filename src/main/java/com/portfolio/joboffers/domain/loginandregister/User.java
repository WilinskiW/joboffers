package com.portfolio.joboffers.domain.loginandregister;

import lombok.Builder;

@Builder
record User(String username, String password) {
}
