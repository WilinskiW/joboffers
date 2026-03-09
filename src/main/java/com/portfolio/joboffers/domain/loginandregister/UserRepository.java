package com.portfolio.joboffers.domain.loginandregister;

import java.util.Optional;

interface UserRepository {
    Long save(User user);

    Optional<User> findByUsername(String username);
}
