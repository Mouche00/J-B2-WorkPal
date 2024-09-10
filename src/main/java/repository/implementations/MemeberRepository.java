package repository.implementations;

import model.User;
import repository.interfaces.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MemeberRepository implements Repository<User, Integer> {

    @Override
    public Optional<User> get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<User> getAll() {
        return List.of();
    }

    @Override
    public Optional<Integer> save(User user) {

        return Optional.empty();
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }
}
