package repository.implementations;

import utils.database.JdbcConnection;

import java.sql.Connection;
import java.util.Optional;

abstract public class Repository {
    protected Optional<Connection> connection;

    public Repository() {
        this.connection = JdbcConnection.getConnection();
    }
}
