import java.util.Scanner;

public class ViewAdd implements Viewable{
    @Override
    public void get() {

    }

    @Override
    public Record post() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер телефона: ");
        String input = scanner.nextLine();
        Phone phone = new Phone(input);
        Person person = new Person();
        System.out.println("Введите фамилию: ");
        person.setFirstname(scanner.nextLine());
        System.out.println("Введите имя: ");
        person.setSecondname(scanner.nextLine());
        System.out.println("Введите отчество: ");
        person.setLastname(scanner.nextLine());
        Record record = new Record(phone,person);
        return record;
    }
}
