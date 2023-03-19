public class App {
    private String title;
    public void Start(){
        setTitle("=== Телефонный справочник ===");
        System.out.println(getTitle());
        ViewMain view = new ViewMain();
        view.get();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
