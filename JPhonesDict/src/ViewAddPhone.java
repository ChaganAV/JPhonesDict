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
        this.record.getPhone().add(phone);
        return this.record;
    }
}
