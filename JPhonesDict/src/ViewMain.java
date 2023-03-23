import java.util.Map;
import java.util.Scanner;

public class ViewMain implements GetViewable{
    @Override
    public void get(){
        Boolean flagOut = true;
        Boolean provider1 = true;
        Provider provider = Provider.TXT;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите формат файла (1 или 2): 1 - txt, 2 - xml, 3 - txt структурированный");
        String input = scanner.nextLine();
        if (input.equals("1")) provider = Provider.TXT;
        if (input.equals("2")) provider = Provider.XML;
        if (input.equals("3")) provider = Provider.STRUCT;
        while(flagOut){
            Menu menu = new Menu();
            Map<Integer,String> items = menu.getItems();
            System.out.println();
            for(Integer item: items.keySet()){
                menu.printItem(item);
            }
            input = scanner.nextLine();
            flagOut = menu.inputComand(input,provider);
        }
    }
}
