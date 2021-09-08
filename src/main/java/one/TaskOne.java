package one;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TaskOne {

    public static <T, R> Stream<R> mapWithIndex(Stream<T> stream, BiFunction<T, Integer, R> mapper) {

        List<T> listT = stream.collect(Collectors.toList());
        return IntStream
                .range(0, listT.size())
                .mapToObj(i -> mapper.apply(listT.get(i), i));

    }
}
