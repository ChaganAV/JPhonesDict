import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtRepository implements Repositable {
    private String dir;
    private String filename;
    List<Record> records;

    public TxtRepository() {
        this.dir = System.getProperty("user.dir");
        this.filename = "Phone.txt";
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
            }
//            else{
//                file.createNewFile();
//            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return records;
    }

    @Override
    public void setData() {
        File file = new File(this.dir,this.filename);
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Record record: records){
                String rec = String.format("%s;%s;",record.getPhone().getNumber(),record.getPerson().toString());
                bw.write(rec);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
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
