import java.util.HashMap;
import java.util.Map;

public class Menu {
    Map<Integer,String> items = new HashMap<Integer,String>();

    public Menu() {
        items.put(1,"добавить телефон");
        items.put(2,"добавить телефон к существующему контакту");
        items.put(3,"вывести справочник");
        items.put(4,"отсортировать по ФИО");
        items.put(5,"удалить телефон");
        items.put(6,"выход");
    }

    public Map<Integer, String> getItems() {
        return items;
    }

    public void setItems(Map<Integer, String> items) {
        this.items = items;
    }
    public Boolean inputComand(String item,Provider provider){
        Controler controler = new Controler(item);
        controler.setProvider(provider);
        return controler.run();
    }
    public void printItem(Integer item){
        System.out.println(String.format("%d - %s",item,items.get((Integer) item)));
    }
}
