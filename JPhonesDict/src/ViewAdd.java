import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewAdd implements PostViewable{

    @Override
    public Record post() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона в формате 99-99-99: ");
        String input = scanner.nextLine();
        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone(input);
        phones.add(phone);
        Person person = new Person();
        System.out.println("Введите фамилию: ");
        person.setFirstname(scanner.nextLine());
        System.out.println("Введите имя: ");
        person.setSecondname(scanner.nextLine());
        System.out.println("Введите отчество: ");
        person.setLastname(scanner.nextLine());
        Record record = new Record(phones,person);
        return record;
    }
}
