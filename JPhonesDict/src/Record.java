public class Record {
    private int id;
    private Phone phone;
    private Person person;

    public Record(int id, Phone phone, Person person) {
        this.id = id;
        this.phone = phone;
        this.person = person;
    }

    public Record(Phone phone, Person person) {
        this.phone = phone;
        this.person = person;
    }
    public Record(){

    }
    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String record = String.format("%s, %s",phone,person);
        return record;
    }
}
