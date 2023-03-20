public class Person {
    private String firstname;
    private String secondname;
    private String lastname;

    public Person(String firstname, String secondname, String lastname) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
    }

    public Person(String firstname, String secondname) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = "";
    }

    public Person(String firstname) {
        this.firstname = firstname;
        this.secondname = "";
        this.lastname = "";
    }
    public Person(){

    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",this.firstname,this.secondname,this.lastname);
    }
}
