package designPatterns.Factory;

public class Guest implements User {
    @Override
    public void displayRole() {
        System.out.println("Guest: Read-Only access");
    }
}
