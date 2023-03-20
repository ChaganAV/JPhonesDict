import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                printRepository();
                break;
            case "3":
                select();
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
        Viewable view = new ViewAdd();
        Record record = (Record) view.post();
        TxtRepository txtRepo = new TxtRepository();
        repository = new Repository(txtRepo);
        repository.add(record);
        txtRepo.setRecords(repository.repository);
        txtRepo.setData();
    }
    public void delete(){

    }
    public List<Record> select(){
        TxtRepository txtRepo = new TxtRepository();
        repository = new Repository(txtRepo);
        List<Record> records = repository.repository;
        return records;
    }
    public void printRepository(){
        List<Record> records = select();
        for(Record rec: records){
            System.out.println(String.format("%s, %s",rec.getPhone(),rec.getPerson().toString()));
        }
    }
}
