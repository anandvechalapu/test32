
Spring Boot Application

Controller:

@RestController
public class PasswordController {
    
    @Autowired
    private PasswordService passwordService;

    @GetMapping("/forgotpassword")
    public String forgotPassword() {
        return passwordService.forgotPassword();
    }

    @PostMapping("/resetpassword")
    public String resetPassword(@RequestBody User user) {
        return passwordService.resetPassword(user);
    }
}

Service:

@Service
public class PasswordService {
    
    @Autowired
    private PasswordRepository passwordRepository;

    public String forgotPassword() {
        //Verify user has access to a registered email address
        //Send verification link to the user's email
        return "Verification link sent to user's email";
    }
    
    public String resetPassword(User user) {
        //Verify user clicked the correct link
        //Verify user has created a strong and unique new password
        //Save new password in the database
        passwordRepository.save(user);
        return "Password successfully reset";
    }
}

Repository:

@Repository
public interface PasswordRepository extends JpaRepository<User, Long> {

}