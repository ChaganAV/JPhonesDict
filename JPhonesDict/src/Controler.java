import java.util.*;

public class Controler {
    private String item;
    private Provider provider;
    Repository repository;
    public Controler(String item) {
        this.item = item;
    }
    public Boolean run(){
        Boolean result = true;
        switch (item){
            case "1":
                select();
                add();
                break;
            case "2":
                select();
                addPhone();
                break;
            case "3":
                select();
                printRepository();
                break;
            case "4":
                select();
                sort(repository.records,new FioComparator());
                break;
            case "5":
                delete();
                break;
            case "6":
                result = false;
        }
        return result;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void add(){
        PostViewable view = new ViewAdd();
        Record record = (Record) view.post();
        repository.add(record);
        saveData();
    }
    public void addPhone(){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Record> mapRecord = new HashMap<>();
        System.out.println("Выберите номер контакта: ");
        int count = 1;
        for(Record record: repository.records){
            mapRecord.put(count,record);
            System.out.println(String.format("%d, %s",count,mapRecord.get(count)));
            count++;
        }
        String input = scanner.nextLine();
        Record record = mapRecord.remove(Integer.parseInt(input));
        //mapRecord.remove(Integer.parseInt(input));
        if(record != null){
            PostViewable view = new ViewAddPhone(record);
            record = view.post();

            mapRecord.put(Integer.parseInt(input),record);
            List<Record> records = new ArrayList<>();
            for(Record rec: mapRecord.values()){
                records.add(rec);
            }
            repository.records = records;
            //repository.add(record);
            saveData();
        }else {
            System.out.println(String.format("Извините, записи c номером %s нет",input));
        }
    }
    public void delete(){
        select();
        Scanner scanner = new Scanner(System.in);
        Map<Integer,RecordOne> mapRecord = new HashMap<>();
        System.out.println("Выберите номер записи для удаления: ");
        int count = 1;
        for(Record record: repository.records){
            List<Phone> phones = record.getPhones();
            for(Phone phone: phones) {
                System.out.println(phone);
                RecordOne recordOne = new RecordOne();
                recordOne.setPerson(record.getPerson());
                recordOne.setPhone(phone);
                mapRecord.put(count, recordOne);
                System.out.println(String.format("%d, %s", count, mapRecord.get(count)));
                count++;
            }
        }
        String input = scanner.nextLine();
        mapRecord.remove(Integer.parseInt(input));
        List<Record> records = new ArrayList<>();
        Set<RecordOne> setOne = new HashSet<>();
        for(RecordOne recordOne: setOne){
            Record record = new Record();
            record.setPerson(recordOne.getPerson());
            List<Phone> phones = new ArrayList<>();
            for(RecordOne mapRec: mapRecord.values()){
                if(mapRec.getPerson().equals(recordOne.getPerson())){
                    phones.add(mapRec.getPhone());
                }
            }
            record.setPhones(phones);
            records.add(record);
        }
        repository.records = records;
        System.out.println("Если такая запись есть, она будет удалена");
        saveData();
    }
    public void select(){
        if(provider == Provider.TXT) {
            TxtProvider txtRepo = new TxtProvider();
            repository = new Repository(txtRepo);
        }
        if(provider == Provider.XML){
            XmlProvider xmlRepo = new XmlProvider();
            repository = new Repository(xmlRepo);
        }
        if(provider == Provider.STRUCT){
            StructProvider structProvider = new StructProvider();
            repository = new Repository(structProvider);
        }
    }
    public void printRepository(){
        for(Record rec: repository.records){
            System.out.println(String.format("%s, %s",rec.getPhones(),rec.getPerson().toString()));
        }
//        for(Record record: repository.records){
//            System.out.println(record.getPerson());
//            for(Phone phone: record.getPhone()){
//                System.out.println(phone);
//            }
//        }
    }
    public void sort(List<Record> records,Comparator<Record> comparator){
        Collections.sort(records, comparator);
        //printRepository2(records);
        printRepository();
    }
    public void saveData(){
        if(provider == Provider.TXT) {
            TxtProvider txtRepo = new TxtProvider();
            txtRepo.setRecords(repository.records);
            txtRepo.setData();
        }
        if(provider == Provider.XML){
            XmlProvider xmlProvider = new XmlProvider();
            xmlProvider.setRecords(repository.records);
            xmlProvider.setData();
        }
        if(provider == Provider.STRUCT){
            StructProvider structProvider = new StructProvider();
            structProvider.setRecords(repository.records);
            structProvider.setData();
        }
    }
}
