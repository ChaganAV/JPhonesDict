import java.util.List;

public class RecordPhones extends Record{
    private List<Phone> phones;

    public RecordPhones(Person person, List<Phone> phones) {
        super(person);
        this.phones = phones;
    }

    public RecordPhones() {
        super();
    }

    public RecordPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
