import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TxtProvider extends TextFile implements Repositable {
    public TxtProvider() {
        super("Phone.txt");
    }
    @Override
    public List<Record> getData() {
        List<Record> records = new ArrayList<>();
        File file = new File(super.getDir(),super.getFilename());
        try {
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()){
                    String[] line = br.readLine().split(";");
                    List<Phone> phones = new ArrayList<>();
                    String[] linePhones = line[0].split(",");
                    for(String l: linePhones)
                        phones.add(new Phone(l.trim()));
                    Person person = new Person();
                    String[] fio = line[1].split(" ");
                    person.setFirstname(fio[0]);
                    person.setSecondname(fio[1]);
                    person.setLastname(fio[2]);
                    Record record = new Record(phones,person);
                    records.add(record);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return records;
    }

    @Override
    public void setData() {
        File file = new File(super.getDir(),super.getFilename());
        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for(Record record: records){
                String phone = record.getPhones().toString().replace("[","");
                phone = phone.replace("]","");
                String rec = String.format("%s;%s;",phone,record.getPerson().toString());
                bw.write(rec);
                bw.newLine();
            }
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
