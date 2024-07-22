import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String[] args){

        Stream stream = Stream.generate(()->Math.random());
        // Max 3 will be displayed
            stream.limit(3)
            .forEach(n -> System.out.println(n));

        // Map
        List.of(1,2,3,4).stream().map(n -> n++).forEach(n -> System.out.println(n));

        // Flat map
        List.of(List.of(1,2,3),List.of(4,5,6)).stream()
                                              .flatMap(list -> list.stream())
                                              .forEach(n -> System.out.println(n));  
    }
}