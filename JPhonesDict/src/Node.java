public class Node extends Record {
    private String name;
    private final String BEGIN = "<";
    private final String END = ">";
    private final String FIN = "</";
    private String tagBegin;
    private String tagEnd;

    public Node(String name,Phone phone, Person person) {
        super(phone, person);
        this.name = name;
        this.tagBegin = String.format("%s%s%s",BEGIN,name,END);
        this.tagEnd = String.format("%s%s%s",BEGIN,name,FIN);
    }
    public Node(String name) {
        super();
        this.name = name;
        this.tagBegin = String.format("%s%s%s",BEGIN,name,END);
        this.tagEnd = String.format("%s%s%s",BEGIN,name,FIN);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagBegin() {
        return tagBegin;
    }

    public String getTagEnd() {
        return tagEnd;
    }

    public void setTagBegin(String tagBegin) {
        this.tagBegin = String.format("%s%s%s",BEGIN,tagBegin,END);
    }

    public void setTagEnd(String tagEnd) {
        this.tagEnd = String.format("%s%s%s",BEGIN,tagEnd,FIN);
    }
}
