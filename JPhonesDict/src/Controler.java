import java.util.*;

public class Controler {
    private String item;
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
            case "4":
                delete();
                break;
            case "5":
                result = false;
        }
        return result;
    }
    public void add(){
        Boolean flagTxt = false;
        if(flagTxt) {
            Viewable view = new ViewAdd();
            Record record = (Record) view.post();
            TxtRepository txtRepo = new TxtRepository();
            repository = new Repository(txtRepo);
            repository.add(record);
            txtRepo.setRecords(repository.repository);
            txtRepo.setData();
        }else {
            Viewable view = new ViewAdd();
            Record record = (Record) view.post();
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
        TxtRepository txtRepo = new TxtRepository();
        repository = new Repository(txtRepo);
        List<Record> records = repository.repository;
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
