public class Phone {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Phone(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return getNumber();
    }
}
