package code.authentication;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private Map<String, String> userDatabase;

    public AuthenticationService() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }
    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}
