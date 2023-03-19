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
                select(item);
                add();
                break;
            case "2":
                select(item);
                break;
            case "3":
                select(item);
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
        repository.save(txtRepo);
    }
    public void delete(){

    }
    public List<Record> select(String item){
        List<Record> records = new ArrayList<>();
        return records;
    }
}
