import java.util.ArrayList;
import java.util.List;

public class Repository{
    List<Record> records = new ArrayList<>();

    public Repository(Repositable repositable) {
        this.records = repositable.getData();
    }
    public void add(Record record){
        records.add(record);
    }
}
