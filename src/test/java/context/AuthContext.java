package context;

import models.AuthResponse;

public class AuthContext {
    private static final ThreadLocal<AuthResponse> authData = new ThreadLocal<>();

    public static void setAuthResponse(AuthResponse response) {
        authData.set(response);
    }

    public static AuthResponse getAuthResponse() {
        return authData.get();
    }
}
