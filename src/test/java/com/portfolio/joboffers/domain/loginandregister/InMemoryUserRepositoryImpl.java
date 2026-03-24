package com.portfolio.joboffers.domain.loginandregister;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryUserRepositoryImpl implements UserRepository {
    private final Map<String, User> db = new HashMap<>();

    @Override
    public User save(final User user) {
        String uuid = UUID.randomUUID().toString();

        var newUser = User.builder()
                .id(uuid)
                .username(user.username())
                .password(user.password())
                .build();

        db.put(uuid, newUser);

        return newUser;
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return db.values().stream()
                .filter(u -> u.username().equals(username))
                .findFirst();
    }
}
