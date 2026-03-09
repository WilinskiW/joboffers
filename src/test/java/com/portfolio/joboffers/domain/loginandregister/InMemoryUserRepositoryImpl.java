package com.portfolio.joboffers.domain.loginandregister;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

class InMemoryUserRepositoryImpl implements UserRepository{
    private final Map<Long, User> db = new HashMap<>();
    private final AtomicInteger sequence_pos = new AtomicInteger(1);

    @Override
    public Long save(final User user) {
        long id = sequence_pos.getAndIncrement();
        db.put(id, user);
        return id;
    }

    @Override
    public Optional<User> findByUsername(final String username) {
        return db.values().stream()
                .filter(u -> u.username().equals(username) )
                .findFirst();
    }
}
