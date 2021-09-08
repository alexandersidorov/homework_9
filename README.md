# homework_9
* Написать метод <br>
`<T, R> Stream<R> mapWithIndex(Stream<T> stream, BiFunction<T, Integer, R> mapper)` <br>
метод принимает стрим и функцию с двумя аргументами, один из которых индекс элемента. <br>

* Сделать свою реализацию интерфейса Collector с методом tripling   
`<T, R1, R2, R3, R> Collector<T, ?, R> tripling(Collector<? super T, ?, R1> downstream1, 
                                                     Collector<? super T, ?, R2> downstream2,
                                                     Collector<? super T, ?, R3> downstream3, 
                                                     two.TriFunction<? super R1, ? super R2, ? super R3, R> merger)`
Метод получает в аргументах 3 коллектора и функцию для мержа трех результатов <br>

* Сделать метод persist, осуществляющий ленивое кэширование результатов стрима,
    для многократного использования.<br>
   `<T> Supplier<Stream<T>> persist(Stream<T> stream)`
   
   

