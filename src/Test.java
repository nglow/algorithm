import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = null;
        System.out.println(list.isEmpty());
        list = new ArrayList<>();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
