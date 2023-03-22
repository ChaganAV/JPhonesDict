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
                //add();
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
    public void delete(){
        select();
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Record> mapRecord = new HashMap<>();
        System.out.println("Выберите номер записи для удаления: ");
        int count = 1;
        for(Record record: repository.records){
            mapRecord.put(count,record);
            System.out.println(String.format("%d, %s",count,mapRecord.get(count)));
            count++;
        }
        String input = scanner.nextLine();
        mapRecord.remove(Integer.parseInt(input));
        List<Record> records = new ArrayList<>();
        for(Record record: mapRecord.values()){
            records.add(record);
        }
        repository.records = records;
        System.out.println("Если такая запись есть, она будет удалена");
        saveData();
    }
    public void select(){
        if(provider == Provider.TXT) {
            TxtRepository txtRepo = new TxtRepository();
            repository = new Repository(txtRepo);
        }else {
            XmlRepository xmlRepo = new XmlRepository();
            repository = new Repository(xmlRepo);
        }
    }
    public void printRepository(){
        for(Record rec: repository.records){
            System.out.println(String.format("%s, %s",rec.getPhone(),rec.getPerson().toString()));
        }
    }
    public void sort(List<Record> records,Comparator<Record> comparator){
        Collections.sort(records, comparator);
        //printRepository2(records);
        printRepository();
    }
    public void saveData(){
        if(provider == Provider.TXT) {
            TxtRepository txtRepo = new TxtRepository();
            txtRepo.setRecords(repository.records);
            txtRepo.setData();
        }else {
            XmlRepository xmlRepository = new XmlRepository();
            xmlRepository.setRecords(repository.records);
            xmlRepository.setData();
        }
    }
}
