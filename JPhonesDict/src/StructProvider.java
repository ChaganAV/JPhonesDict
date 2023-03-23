import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StructProvider extends TextFile implements Repositable {
    public StructProvider() {
        super("PhoneStruct.txt");
    }

    @Override
    public List<Record> getData() {
        List<Record> records = new ArrayList<>();
        File file = new File(super.getDir(),super.getFilename());
        try {
            if (file.exists()) {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                Person person = new Person();
                List<Phone> phones = new ArrayList<>();
                //Record record = new Record();
                while (br.ready()){
                    String[] line = br.readLine().split(";");
                    if(line[0].equals("person")){
                        if(phones.size()>0){
                            Record record = new Record();
                            record.setPerson(person);
                            record.setPhone(phones);
                            records.add(record);
                            phones = new ArrayList<>();
                        }
                        String[] fio = line[1].split(" ");
                        person = new Person();
                        person.setFirstname(fio[0]);
                        person.setSecondname(fio[1]);
                        person.setLastname(fio[2]);
                        //record.setPerson(person);
                    }else {
                        phones.add(new Phone(line[1]));
                    }
                    //Record record = new Record();
                    //records.add(record);
                }
                Record record = new Record(phones,person);
                //record.setPhone(phones);
                records.add(record);
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
            //Collections.sort(records,new FioComparator());
            //Person person = new Person();
            //String rec = "";
            for(Record record: records){
//                if(person != record.getPerson()){
//                    person = record.getPerson();
                    //rec = String.format("person;%s;",record.getPerson().toString());
                    bw.write(String.format("person;%s;",record.getPerson().toString()));
                    bw.newLine();
                    for(Phone phone: record.getPhones()) {
                        bw.write(String.format("phone;%s;", phone.getNumber()));
                        bw.newLine();
                    }
//                }else {
//                    //rec = String.format("%s;%s;",record.getPhone().getNumber(),record.getPerson().toString());
//                    for(Phone phone: record.getPhone()) {
//                        bw.write(String.format("phone;%s;", phone.getNumber()));
//                        bw.newLine();
//                    }
//                }
            }
            bw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
