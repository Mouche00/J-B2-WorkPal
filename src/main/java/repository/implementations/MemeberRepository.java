package repository.implementations;

import utils.database.JdbcConnection;
import model.Member;
import repository.interfaces.MemberRepositoryInterface;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MemeberRepository extends Repository implements MemberRepositoryInterface {

    public MemeberRepository() {
        super();
    }

    @Override
    public Optional<Member> get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Member> getAll() {
        return List.of();
    }

    @Override
    public void save(Member member) {

    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(Member member) {

    }
}
