import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtRepository implements Repositable{
    private String dir;
    private String filename;
    List<Record> records;

    public TxtRepository() {
        this.dir = System.getProperty("user.dir");
        this.filename = "Phone.ph";
    }
    @Override
    public List<Record> getData() {
        List<Record> records = new ArrayList<>();
        File file = new File(this.dir,this.filename);
        try {
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()){
                    String[] line = br.readLine().split(";");
                    Phone phone = new Phone(line[0]);
                    Person person = new Person();
                    String[] fio = line[1].split(" ");
                    person.setFirstname(fio[0]);
                    person.setSecondname(fio[1]);
                    person.setLastname(fio[2]);
                    Record record = new Record(phone,person);
                    records.add(record);
                }
            }else{
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return records;
    }

    @Override
    public void setData() {

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

    public void setRecords(List<Record> list) {
        this.records = list;
    }
}
