import java.util.Map;
import java.util.Scanner;

public class ViewMain implements Viewable{
    @Override
    public void get(){
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

    @Override
    public Line post() {
        return null;
    }
}
