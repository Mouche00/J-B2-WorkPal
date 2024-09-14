package repository.implementations;

import model.Member;
import repository.interfaces.RepositoryInterface;
import utils.database.ORM;
import java.sql.SQLException;
import java.util.*;

public class MemberRepository extends Repository implements RepositoryInterface<Member> {

    @Override
    public Optional<Member> get(int id) {
        return Optional.empty();
    }

    @Override
    public HashMap<String, Member> getAll() {
        return null;
    }

    @Override
    public void save(Member member) throws SQLException, IllegalAccessException {
        ORM.save(member);
    }

    @Override
    public boolean update(Member member) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Member member) throws SQLException {
        return false;
    }

}
