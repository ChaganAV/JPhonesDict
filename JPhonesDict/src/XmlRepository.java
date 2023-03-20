import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlRepository extends TextFile implements Repositable{
    public XmlRepository() {
        super("Phone.xml");
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
            String xmlzag = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
            NodeXml root = new NodeXml("records");
            bw.write(xmlzag);
            bw.newLine();
            bw.write(root.getTagBegin());
            for(Record record: records){
                NodeXml node = (NodeXml) record;
                String rec = String.format("%s;%s;",node.getPhone().getNumber(),node.getPerson().toString());
                bw.write(rec);
                bw.newLine();
            }
            bw.write(root.getTagEnd());
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
