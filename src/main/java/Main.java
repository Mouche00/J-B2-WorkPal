import controller.AdditionalServiceController;
import controller.AuthentificationController;
import controller.WorkspaceController;
import model.Manager;
import model.Member;
import repository.implementations.AdditionalServiceRepository;
import repository.implementations.MemberRepository;
import repository.implementations.UserRepository;
import repository.implementations.WorkspaceRepository;
import service.implementations.AdditionalServiceService;
import service.implementations.AuthentificationService;
import service.implementations.WorkspaceService;
import service.interfaces.WorkspaceServiceInterface;
import utils.Session;

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


//        AdditionalServiceRepository additionalServiceRepository = new AdditionalServiceRepository();
//        AdditionalServiceService additionalServiceService = new AdditionalServiceService(additionalServiceRepository);
//        AdditionalServiceController additionalServiceController = new AdditionalServiceController(additionalServiceService);
//        additionalServiceController.create();

        UserRepository<Manager> userRepository = new UserRepository<>();
        AuthentificationService<Manager> authentificationService = new AuthentificationService<>(userRepository);
        AuthentificationController<Manager> authentificationController = new AuthentificationController<>(authentificationService, Manager.class);
        authentificationController.login();
//        System.out.println(Session.getLoggedUser());

        WorkspaceRepository workspaceRepository = new WorkspaceRepository();
        WorkspaceService workspaceService = new WorkspaceService(workspaceRepository);
        WorkspaceController workspaceController = new WorkspaceController(workspaceService);
        workspaceController.create();
//        workspaceController.getAll();
    }
}