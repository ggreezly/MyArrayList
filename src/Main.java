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
    }
}