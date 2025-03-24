package src.algorithms;

import java.util.Arrays;
import java.util.Comparator;


public class MyArrayList {
    /**
     * поле отвечающее за объем динамического массива по умолчанию равное 10 элементам
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * поле отвечающие за храние всех элементов коллекции.
     * поле не задается вручную, а вычисляется программой и менятеся
     * с ростом или уменьшением массива. поле не требует сериализации
     */
    transient Object[] elements; // так же модификатор transient не допускает утечку информации
    // за пределы JVM и упрощает доступ к вложенным классам так как не является приватным
    /**
     * поле, хранящее в себе количество действительно
     * находящихся в массиве элементов
     */
    private int size;
    /**
     * конструктор без параментов, создающий пустой массив на 10 элементов
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }
    /**
     * конструктор создающий списочный массив имеющий началную
     * емкость заданную пользавателем.
     * если начальная емкость (initialCapacity) больше или равно 0,
     * то создается новый массив указанного размера.
     * Если initialCapacity меньше 0, то генерируется исключение
     * IIIegalArgumentException
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elements = new Object[initialCapacity];
        } else {
            throw new IllegalStateException("Начальная емкость (initialCapacity) не может быть меньше или равен нулю");
        }
    }
    /**
     * возвращает количество элементов в списке
     */
    private int size() {
        return size;
    }
    /**
     * метод увеличения емкости массива, чтобы гарантировать, что она может содержать
     * то количество элементов, которое указано в параметре minCapacity.
     * Если массив заполнен,
     * то срабатывает данный метод, в котором внутреннему массиву
     * присваивается ссылка на новый созданный массив, полученный в результате
     * копирования элементов исходного массива
     */
    private Object[] capacityGrowth(int minCapacity ) {
        int capacity = elements.length;
        if (capacity > 0) {
            Object[] newCapacity = new Object[(elements.length * 2)];
            System.arraycopy(elements, 0, newCapacity, 0, elements.length);
            return newCapacity;
        }else{
            return elements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }}
    /**
     * после увеличения размера массива в конец массива добовляется новый элемент,
     * а текуйщий парамент size увеличиваем на единицу
     */
    private Object[] capacityGrowth() {
        return capacityGrowth(size + 1);
    }
    /**
     * метод добавляет новый элемент в конец массива.
     * внутри метода идет проверка на наличие в массиве места,
     * если нет, то срабатывает метод расширения емкости capacityGrowth.
     * если элемент добавлен возвращает true
     */
    public boolean add(Object object){
        if (size == elements.length){
            elements = capacityGrowth();
        }
        elements[size] = object;
        size++;
        return true;
    }
    /**
     * метод проверка корректности искомого индекса.
     * указанный индекс не может быть больше чем текущее количество элементов массива
     * size или меньше 0
     */
    private int checkingIndex(int index){
        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Элемент не найден!!! " + arrayLimit(index));
        }
        return index;
    }
    /**
     * выводим предельные значения массива
     */
    private String arrayLimit (int index){
        return "Количество элементов в массвие: " + size +"общий размер массива: "+ elements.length;
    }
    /**
     * добавляем элемент с указанием индекса ячейки
     * в которую хотим добавть.
     * проверяем наличие искомого элемента в массиве.
     * вставоляем элемент, копируем последующие элементы вправо
     */
    public void add(int index, Object object){
        checkingIndex(index);
        final int i;
        Object[] elements;
        if ((i = size) == (elements = this.elements).length)
            elements = capacityGrowth();
        System.arraycopy(elements, index, elements, index+1, i-index); // увеличиваем массив, сдвигая его с помощью копирования
        elements[index] = object;
        size = i + 1;
    }
    /**
     * получаем элемент по индексу
     */
    public Object get (int index){
        checkingIndex(index);
        return elements[index];
    }
    /**
     * удаление элемента по индексу.
     * проверчем на наличие искомого элемента по индексу,
     * удаляем элемент, путем копирования сдвигаем последующие элементы влево,
     * затем уменьшаем массив на 1
     */
    public Object remove (int index){
        checkingIndex(index);
        Object[] objects = elements;
        elements = new Object[objects.length-1];
        Object object = objects[index];
        System.arraycopy(objects,0,elements,0,index);
        System.arraycopy(objects,index +1, elements, index,objects.length);
        size--;
        return object;
    }
    /**
     * удаляем все элементы из массива.
     * в цикле проходимся по всем
     * элементам массив, присваивая им null
     */
    public void clear(){
        Object[] objects = elements;
        for (int s = size, i =size = 0; i < s; i++)
            objects[i]= null;
    }
    /**
     * сортируем элементы коллекции
     */
    public void sort(Comparator<Object> objectComparator) {
        Arrays.sort(elements, 0, size, objectComparator);

    }


}
