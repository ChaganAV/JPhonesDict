import java.util.List;

public abstract class TextFile {
    private String dir;
    private String filename;
    List<Record> records;

    public TextFile(String filename) {
        this.dir = System.getProperty("user.dir");
        this.filename = filename;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
