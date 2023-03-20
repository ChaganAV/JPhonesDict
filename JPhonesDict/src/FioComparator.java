import java.util.Comparator;

public class FioComparator implements Comparator<Record> {
    @Override
    public int compare(Record o1, Record o2) {
        return o1.getPerson().toString().compareTo(o2.getPerson().toString());
    }
}
