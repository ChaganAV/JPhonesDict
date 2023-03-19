import java.util.Map;
import java.util.Scanner;

public class View {
    public void getInput(){
        Boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while(flag){
            Menu menu = new Menu();
            Map<Integer,String> items = menu.getItems();
            for(Integer item: items.keySet()){
                menu.printItem(item);
            }
            String input = scanner.nextLine();
            flag = menu.inputComand(input);
        }
    }
}
