import java.util.Scanner;

public class ViewAddPhone implements PostViewable{
    private Person person;

    public ViewAddPhone(Person person) {
        this.person = person;
    }
    @Override
    public Record post() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона в формате 99-99-99: ");
        String input = scanner.nextLine();
        Phone phone = new Phone(input);
        Record record = new Record(phone,person);
        return record;
    }
}
