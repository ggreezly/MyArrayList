import java.util.Comparator;

/**
 * MyArrayList - кастомная реализация динамического массива.
 * Поддерживает основные операции:  добавление, удаление, получение элементов,
 * очистка и сортировка.
 *
 * @param <T> тип элементов в списке
 */
public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    /**
     * Конструктор по умолчанию. Создает список с начальной емкостью 10.
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент, который нужно добавить
     */
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index   индекс, по которому нужно добавить элемент
     * @param element элемент, который нужно добавить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента, который нужно удалить
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    /**
     * Очищает список, удаляя все элементы.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * Сортирует список с использованием компаратора.
     *
     * @param comparator компаратор, определяющий порядок сортировки
     */
    public void sort(Comparator<T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов в списке
     */
    public int size() {
        return size;
    }

    /**
     * Увеличивает емкость списка, при  необходимости.
     */
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    /**
     * Реализация алгоритма быстрой сортировки (quicksort).
     *
     * @param low        начальный индекс
     * @param high       конечный индекс
     * @param comparator компаратор, определяющий порядок сортировки
     */
    private void quickSort(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    /**
     * Вспомогательный метод для быстрой сортировки.
     *
     * @param low        начальный индекс
     * @param high       конечный индекс
     * @param comparator компаратор, определяющий порядок сортировки
     * @return индекс опорного элемента
     */
    private int partition(int low, int high, Comparator<T> comparator) {
        T pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Меняет местами элементы по указанным индексам.
     *
     * @param i индекс первого элемента
     * @param j индекс второго элемента
     */
    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
