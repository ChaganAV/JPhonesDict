import java.util.List;
import java.util.Scanner;

public class ViewAddPhone implements PostViewable{
    private Record record;

    public ViewAddPhone(Record record) {
        this.record = record;
    }
    @Override
    public Record post() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона в формате 99-99-99: ");
        String input = scanner.nextLine();
        Phone phone = new Phone(input);
        List<Phone> phones = this.record.getPhones();
        phones.add(phone);
        //for(Phone phone1: phones) System.out.println(phone1);
        this.record.setPhones(phones);
        System.out.println("test");
        this.record.printPhone();
        return this.record;
    }
}
