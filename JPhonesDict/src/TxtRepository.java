import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TxtRepository implements Repositable{
    private String dir;
    private String filename;
    List<Record> list;

    public TxtRepository(String dir, String filename) {
        this.dir = dir;
        this.filename = filename;
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
}
