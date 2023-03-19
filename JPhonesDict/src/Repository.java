import java.util.ArrayList;
import java.util.List;

public class Repository{
    List<Record> repository = new ArrayList<>();

    public Repository(Repositable repositable) {
        this.repository = repositable.getData();
    }
    public void add(Record record){
        repository.add(record);
    }
    public void save(Repositable repositable){
        repositable.setData();
    }
}
