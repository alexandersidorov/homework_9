package three;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskThree {
    public static <T> Supplier<Stream<T>> persist(Stream<T> stream) {

        return stream.collect(Collectors.toList())::stream;
    }
}
