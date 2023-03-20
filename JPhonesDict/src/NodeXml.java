public class NodeXml extends Node{
    private String text;
    public NodeXml(String name) {
        super(name);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
