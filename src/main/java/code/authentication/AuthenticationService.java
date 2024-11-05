package code.authentication;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    // Example credentials (In a real application, use a secure storage or database)
    private Map<String, String> userDatabase;

    public AuthenticationService() {
        userDatabase = new HashMap<>();
        // Adding some example users
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    // Method to check username and password
    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}
