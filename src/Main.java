import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Пример с целыми числами
        MyArrayList<Integer> intList = new MyArrayList<>();
        intList.add(5);
        intList.add(3);
        intList.add(8);
        intList.sort(Comparator.naturalOrder());
        System.out.println("Sorted integers:");
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }

        // Пример со строками
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.add("arabica");
        stringList.add("java");
        stringList.add("robusta");
        stringList.sort(Comparator.reverseOrder());
        System.out.println("Sorted strings:");
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println(stringList.get(i));
        }

        // Пример с большим количеством данных
        // Добавление
        MyArrayList<Integer> largeList = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            largeList.add((int) (Math.random() * 100000));
        }

        System.out.println("Size of largeList: " + largeList.size());

        // Сортировка
        long startTime = System.currentTimeMillis();
        largeList.sort(Comparator.naturalOrder());
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken to sort largeList: " + (endTime - startTime) + " ms");

        // Удаление
        for (int i = 0; i < 50000; i++) {
            largeList.remove(0); // Удаляем первые 50000 элементов
        }

        System.out.println("Size of largeList after removal: " + largeList.size());
    }
}