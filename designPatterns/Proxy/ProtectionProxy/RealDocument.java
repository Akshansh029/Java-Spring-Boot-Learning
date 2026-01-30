package designPatterns.Proxy.ProtectionProxy;

public class RealDocument implements Document {
    private String content;

    public RealDocument(String content) {
        this.content = content;
    }

    @Override
    public void displayContent() {
        System.out.println("Document content: " + content);
    }

    @Override
    public void edit(String newContent) {
        this.content = newContent;
        System.out.println("Document edited successfully");
    }
}
