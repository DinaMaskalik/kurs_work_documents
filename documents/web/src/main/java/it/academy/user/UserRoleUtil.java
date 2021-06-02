package it.academy.user;

public class UserRoleUtil {
    private static String role;

    private static Long id;

    private UserRoleUtil() {
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        UserRoleUtil.role = role;
    }

    public static Long getId() {
        return id;
    }

    public static void setId(Long id) {
        UserRoleUtil.id = id;
    }
}
