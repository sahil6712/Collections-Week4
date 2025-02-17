package org.example.annotations.advancedlevel.accesscontrol;


// Step 2: Create a Secure Service with Restricted Methods
class SecureService {

    @RoleAllowed({"ADMIN"}) // Only ADMIN can access
    public void adminTask() {
        System.out.println("Admin task executed successfully!");
    }

    @RoleAllowed({"USER", "ADMIN"}) // Both USER and ADMIN can access
    public void userTask() {
        System.out.println("User task executed successfully!");
    }
}