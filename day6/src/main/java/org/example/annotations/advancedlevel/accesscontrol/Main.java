package org.example.annotations.advancedlevel.accesscontrol;


public class Main {
    public static void main(String[] args) {
        SecureService service = new SecureService();

        AccessControl adminAccess = new AccessControl("ADMIN");
        AccessControl userAccess = new AccessControl("USER");

        System.out.println("Admin trying to execute methods:");
        adminAccess.invokeMethod(service, "adminTask");
        adminAccess.invokeMethod(service, "userTask");

        System.out.println("\nUser trying to execute methods:");
        userAccess.invokeMethod(service, "adminTask");
        userAccess.invokeMethod(service, "userTask");
    }
}
