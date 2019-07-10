package inclass;

import java.util.Arrays;
import java.util.function.Supplier;

public class getmin {
    public static void main(String[] args) {
        Integer[] arr={1,22,3,40,5,1000};
        Integer min = getmin(() -> {
            Arrays.sort(arr);
            return arr[0];
        });
        System.out.println(min);

    }
    public static Integer getmin(Supplier<Integer> sup){
        Integer min = sup.get();
        return min;
    }
}
