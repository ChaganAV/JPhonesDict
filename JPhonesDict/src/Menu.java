import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<Integer,String> items = new HashMap<Integer,String>();

    public Menu() {
        items.put(1,"добавить телефон");
        items.put(2,"вывести справочник");
        items.put(3,"отсортировать по ФИО");
        items.put(4,"удалить телефон");
        items.put(5,"выход");
    }

    public Map<Integer, String> getItems() {
        return items;
    }

    public void setItems(Map<Integer, String> items) {
        this.items = items;
    }
    public Boolean inputComand(String item){
        Controler controler = new Controler(item);
        return controler.run();
    }
    public void printItem(Integer item){
        System.out.println(String.format("%d - %s",item,items.get((Integer) item)));
    }
}
