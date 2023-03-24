public class RecordOne extends Record{
    private Phone phone;
    public RecordOne() {

    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s, %s",this.phone.getNumber(),super.getPerson());
    }
}
