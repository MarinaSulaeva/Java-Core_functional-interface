import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        System.out.println("Задание №1");
        System.out.println(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        }.test(-3));
        Predicate<Integer> predicate = integer -> (integer >= 0);
        System.out.println(predicate.test(5));
    }

    public static void task2() {
        System.out.println("Задание №2");
        new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Привет, " + s + "!");
            }
        }.accept("Марина");
        Consumer<String> consumer = s -> System.out.println("Привет, " + s + "!");
        consumer.accept("Виктор");
    }

    public static void task3() {
        System.out.println("Задание №3");
        System.out.println(new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return (Long) Math.round(d);
            }
        }.apply(95.3467));
        Function<Double, Long> function = aDouble -> (Long) Math.round(aDouble);
        System.out.println(function.apply(38.5959));

    }

    public static void task4() {
        System.out.println("Задание №4");
        System.out.println(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) Math.round(Math.random() * 100);
            }
        }.get());
        Supplier<Integer> supplier = () -> (int) Math.round(Math.random() * 100);
        System.out.println(supplier.get());

    }

    public static void task5() {
        System.out.println("Задание №5");
        Predicate<Integer> condition = integer -> (integer >= 0);
        Function<Integer, Double> ifTrue = i -> i * 2.71828;
        Function<Integer, Double> ifFalse = i -> -i * 2.71828;
        Integer t = -3;
        System.out.println(ternaryOperator(condition, ifTrue, ifFalse, t).apply(t));
    }

    public static <T, U> Function<? super T, ? extends U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse, T t) {
        if (condition.test(t)) {
            return ifTrue;
        } else {
            return ifFalse;
        }
    }
}