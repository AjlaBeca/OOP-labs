package Week8;
import java.lang.annotation.*;

//annotation CanSendMessage
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface CanSendMessage {}

//annotation RequiresPermission
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@interface RequiresPermission {
    PermissionLevel value();
}

//annotation UserPermission
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface UserPermission {
    PermissionLevel value();
}

enum PermissionLevel {
    USER,
    ADMIN
}

class User {
    String username;

    User(String username) {
        this.username = username;
    }
}
@UserPermission(PermissionLevel.ADMIN)
class Admin extends User {
    Admin(String username) {
        super(username);
    }
}
public class MessagingSystem {
    @CanSendMessage
    @RequiresPermission(PermissionLevel.USER)
    void sendMessage(User user, String message) {
        if (user instanceof Admin) {
            System.out.println("[" + user.username + "]:" +message);
        } else {
            System.out.println(user.username + " is restricted from sending messages.");
        }
    }

    public static void main(String[] args) {
        MessagingSystem messagingSystem = new MessagingSystem();

        User regularUser = new User("Your Average Joe");
        Admin adminUser = new Admin("CEO");

        messagingSystem.sendMessage(regularUser, "Hello, regular user!");
        messagingSystem.sendMessage(adminUser, "Hello, admin user!");
    }
}
