import java.util.List;

public class Record {
    private List<Phone> phones;
    private Person person;


    public Record(List<Phone> phones, Person person) {
        this.phones = phones;
        this.person = person;
    }
    public Record(Person person){
        this.person = person;
    }
    public Record(){

    }
    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        String record = String.format("%s, %s",phones,person);
        return record;
    }
    public void printPhone(){
        for(Phone phone: this.phones){
            System.out.println(phone.getNumber());
        }
    }
}
