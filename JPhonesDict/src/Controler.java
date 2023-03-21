import java.util.*;

public class Controler {
    private String item;
    private Boolean provider;
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
                List<Record> records = select();
                printRepository(records);
                break;
            case "3":
                sort(select(),new FioComparator());
                break;
//            case "4":
//                delete();
//                break;
            case "4":
                result = false;
        }
        return result;
    }

    public Boolean getProvider() {
        return provider;
    }

    public void setProvider(Boolean provider) {
        this.provider = provider;
    }

    public void add(){
        Viewable view = new ViewAdd();
        Record record = (Record) view.post();
        if(provider) {
            TxtRepository txtRepo = new TxtRepository();
            repository = new Repository(txtRepo);
            repository.add(record);
            txtRepo.setRecords(repository.repository);
            txtRepo.setData();
        }else {
            XmlRepository xmlRepository = new XmlRepository();
            repository = new Repository(xmlRepository);
            repository.add((Record) record);
            xmlRepository.setRecords(repository.repository);
            xmlRepository.setData();
        }
    }
    public void delete(){
        System.out.println("Извините, у вас нет доступа, обратитесь к администратору вашей системы");
    }
    public List<Record> select(){
        List<Record> records;
        if(provider) {
            TxtRepository txtRepo = new TxtRepository();
            repository = new Repository(txtRepo);
            records = repository.repository;
        }else {
            XmlRepository xmlRepo = new XmlRepository();
            repository = new Repository(xmlRepo);
            records = repository.repository;
        }
        return records;
    }
    public void printRepository(List<Record> records){
        for(Record rec: records){
            System.out.println(String.format("%s, %s",rec.getPhone(),rec.getPerson().toString()));
        }
    }
    public void sort(List<Record> records,Comparator<Record> comparator){
        Collections.sort(records, comparator);
        printRepository(records);
    }
}
