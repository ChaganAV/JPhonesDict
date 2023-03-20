public class Record extends Line{
    private Phone phone;
    private Person person;

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
}
