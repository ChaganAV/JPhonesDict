import java.util.List;

public class Node extends Record {
    private String name;
    private final String BEGIN = "<";
    private final String END = ">";
    private final String FIN = "</";
    private String tagBegin;
    private String tagEnd;

    public Node(String name, List<Phone> phones, Person person) {
        super(phones, person);
        this.name = name;
        this.tagBegin = String.format("%s%s%s",BEGIN,name,END);
        this.tagEnd = String.format("%s%s%s",FIN,name,END);
    }
    public Node(String name) {
        super();
        this.name = name;
        this.tagBegin = String.format("%s%s%s",BEGIN,name,END);
        this.tagEnd = String.format("%s%s%s",FIN,name,END);
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
        this.tagEnd = String.format("%s%s%s",FIN,tagEnd,END);
    }
}
