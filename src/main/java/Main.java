import DTO.UserDTO;
import controller.implementations.WorkspaceController;
import controller.implementations.auth.LoginController;
import controller.implementations.auth.RegisterController;
import repository.implementations.MemberRepository;
import repository.implementations.UserRepository;
import repository.implementations.WorkspaceRepository;
import repository.interfaces.UserRepositoryInterface;
import repository.interfaces.WorkspaceRepositoryInterface;
import service.implementations.WorkspaceService;
import service.implementations.auth.LoginService;
import service.implementations.auth.RegisterService;
import service.interfaces.WorkspaceServiceInterface;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
//        MemberRepository memberRepository = new MemberRepository();
//        RegisterService registerService = new RegisterService(memberRepository);
//        RegisterController registerController = new RegisterController(registerService);
//        registerController.showRegister();

//        UserRepository userRepository = new UserRepository();
//        LoginService loginService = new LoginService(userRepository);
//        LoginController loginController = new LoginController(loginService);
//        loginController.showLogin();
//
        WorkspaceRepository workspaceRepository = new WorkspaceRepository();
        WorkspaceServiceInterface workspaceService = new WorkspaceService(workspaceRepository);
        WorkspaceController workspaceController = new WorkspaceController(workspaceService);
//        workspaceController.create();
        workspaceController.getAll();
    }
}