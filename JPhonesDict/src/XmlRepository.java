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
                String s;
                String firstname = "";
                String secondname = "";
                String lastname = "";
                NodeXml first = new NodeXml("firstname");
                NodeXml second = new NodeXml("secondname");
                NodeXml last = new NodeXml("lastname");
                NodeXml contact = new NodeXml("contact");
                String phoneString = "";
                NodeXml nodePhone = new NodeXml("phone");
                while(br.ready()) {
                    s = br.readLine();
                    if(s.contains(first.getTagBegin())){
                        firstname = s.substring(s.indexOf(first.getTagBegin())+first.getTagBegin().length(),s.indexOf(first.getTagEnd()));
                    }
                    if(s.contains(second.getTagBegin())){
                        secondname = s.substring(s.indexOf(second.getTagBegin())+second.getTagBegin().length(),s.indexOf(second.getTagEnd()));
                    }
                    if(s.contains(last.getTagBegin())){
                        lastname = s.substring(s.indexOf(last.getTagBegin())+last.getTagBegin().length(),s.indexOf(last.getTagEnd()));
                    }
                    if(s.contains(nodePhone.getTagBegin())){
                        phoneString = s.substring(s.indexOf(nodePhone.getTagBegin())+nodePhone.getTagBegin().length(),s.indexOf(nodePhone.getTagEnd()));
                    }
                    if(s.contains(contact.getTagEnd())){
                        Phone phone = new Phone(phoneString);
                        Person person = new Person(firstname,secondname,lastname);
                        Record record = new Record(phone,person);
                        records.add(record);
                    }
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
            String tab = "    ";
            String xmlzag = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
            NodeXml root = new NodeXml("records");
            bw.write(xmlzag);
            bw.newLine();
            bw.write(root.getTagBegin());
            bw.newLine();
            for(Record record: records){
                NodeXml nodeRecord = new NodeXml("record");
                bw.write(nodeRecord.getTagBegin());

                NodeXml nodeContact = new NodeXml("contact");
                bw.newLine();
                bw.write(nodeContact.getTagBegin());

                NodeXml nodePerson = new NodeXml("person");
                bw.newLine();
                bw.write(nodePerson.getTagBegin());

                NodeXml elFirstname = new NodeXml("firstname");
                bw.newLine();
                bw.write(elFirstname.getTagBegin());
                bw.write(record.getPerson().getFirstname());
                bw.write(elFirstname.getTagEnd());
                NodeXml elSecondname = new NodeXml("secondname");
                bw.newLine();
                bw.write(elSecondname.getTagBegin());
                bw.write(record.getPerson().getSecondname());
                bw.write(elSecondname.getTagEnd());
                NodeXml elLastname = new NodeXml("lastname");
                bw.newLine();

                bw.write(elLastname.getTagBegin());
                bw.write(record.getPerson().getLastname());
                bw.write(elLastname.getTagEnd());
                bw.newLine();
                bw.write(nodePerson.getTagEnd());

                NodeXml nodePhone = new NodeXml("phone");
                bw.newLine();
                bw.write(nodePhone.getTagBegin());
                bw.write(record.getPhone().getNumber());
                bw.write(nodePhone.getTagEnd());

                bw.newLine();
                bw.write(nodeContact.getTagEnd());
                bw.newLine();
                bw.write(nodeRecord.getTagEnd());
            }
            bw.newLine();
            bw.write(root.getTagEnd());
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
