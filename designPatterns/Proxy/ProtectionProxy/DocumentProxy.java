package designPatterns.Proxy.ProtectionProxy;

public class DocumentProxy implements Document {
    private RealDocument realDocument;
    private String userRole; // ADMIN, USER, GUEST

    public DocumentProxy(String content, String userRole) {
        this.realDocument = new RealDocument(content);
        this.userRole = userRole;
    }

    @Override
    public void displayContent() {
        // Everyone can view
        realDocument.displayContent();
    }

    @Override
    public void edit(String newContent) {
        // Only admins can edit
        if ("ADMIN".equals(userRole)) {
            realDocument.edit(newContent);
        } else {
            System.out.println("Access denied! Only admins can edit documents.");
        }
    }
}