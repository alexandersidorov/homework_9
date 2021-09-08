import one.TaskOne;
import org.junit.jupiter.api.Test;
import three.TaskThree;
import two.Employee;
import two.TriCollector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TaskOneTest {

    @Test
    void mapWithIndex() {
        BiFunction<Integer,Integer,String> biFunc =
                (l,i)-> i+") "+l;

        List<Integer> intList = Arrays.asList(77,88,99);
        List<String> retData = TaskOne.mapWithIndex(intList.stream(),biFunc).collect(Collectors.toList());
        System.out.println(retData);
    }

    @Test
    void testTring() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Stan", 100),
                new Employee(2, "Kayle", 200),
                new Employee(3, "Carthmann", 300),
                new Employee(4, "Kenny", 400));

        HashMap<String, Object> result = employeeList.stream().collect(
                TriCollector.tripling(
                        Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
                        Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()),
                        Collectors.filtering(e -> e.getSalary() > 200, Collectors.summarizingDouble(Employee::getSalary)),
                        (list, count, commonSalary) -> {
                            HashMap<String, Object> map = new HashMap<>();
                            map.put("list", list);
                            map.put("count", count);
                            map.put("commonSalary", commonSalary.getSum());
                            return map;
                        }
                ));
        System.out.println(result);
    }

    @Test
    void testThree() {
        //todo реализовал неправильно, т.к. внутри TaskThree.persist(stream) у стрима используется
        // терминальный метод

        var list = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        var stream = list.stream()
                .filter(it -> {
                    System.out.println("Filter"); // Должно появиться ровно 10 раз за время выполнения
                    return it % 2 == 0;
                });

        // Данная операция НЕ должна вызвать фильтр
        var cachedStreamSupplier = TaskThree.persist(stream);

        // Вызов "Filter"
        System.out.println(cachedStreamSupplier.get().filter(it -> Math.random() < 0.5).count());

        // "Filter" НЕ должен вызваться повторно
        System.out.println(cachedStreamSupplier.get().count());
    }

}


