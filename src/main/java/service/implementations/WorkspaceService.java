package service.implementations;

import model.Workspace;
import repository.implementations.WorkspaceRepository;
import service.interfaces.WorkspaceServiceInterface;

import java.sql.SQLException;
import java.util.HashMap;

public class WorkspaceService implements WorkspaceServiceInterface {

    private final WorkspaceRepository repository;
    public WorkspaceService(WorkspaceRepository repository) {
        this.repository = repository;
    }

    public void save(Workspace workspace) throws SQLException, IllegalAccessException {
        repository.save(workspace);
    }

    public HashMap<String, Workspace> getAll() throws SQLException {
        return repository.getAll();
    }
}
