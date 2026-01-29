package designPatterns.Factory;

public class Admin implements User {
    @Override
    public void displayRole() {
        System.out.println("Admin: Full system access");
    }
}