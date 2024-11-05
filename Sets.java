import java.util.Set;
import java.util.TreeSet;

public class Sets {
    public static void main(String[] args) {
        Set<String> conjunto = new TreeSet<>();
        conjunto.add("juan");
        conjunto.add("carlos");
        conjunto.add("carlos");
        conjunto.add("xavier");
        conjunto.add("victoria");

        System.out.println("Sets.main()");
        conjunto.forEach(System.out::println);

        // remove
        conjunto.remove("carlos");
        System.out.println("nuevos usuarios");
        conjunto.forEach(System.out::println);

    }
}
