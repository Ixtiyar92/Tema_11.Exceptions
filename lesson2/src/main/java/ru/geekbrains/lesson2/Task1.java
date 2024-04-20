package ru.geekbrains.lesson2;

import java.util.Random;

public class Task1 {

    /*
     1.  Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     2.  Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     3.  В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
     MyArrayDataException и вывести результат расчета.

    */

    public static void main(String[] args) {
        processArray();

        // try catch finally
        // try{}catch{}
        // try{}catch{}finally{}
        // try{}finally{}
        System.out.println("Завершение работы метода main");
    }

    static Random random = new Random();


    public static void processArray(){

        while (true){
            try {
                System.out.printf("Сумма всех элементов массива: %d\n", processArrayInternal(generateArray()));
                break;
            }

            catch (MyArraySizeException e){
                System.out.printf("%s Требовалось 4x4, получили %dx%d\n", e.getMessage(), e.getX(), e.getY());
            }
            catch (MyArrayDataException e){
                System.out.printf("%s данных по индексу [%d][%d]\n",e.getMessage(), e.getX(), e.getY());
            }
            catch (Exception e){

            }
        }


        System.out.println("Завершение работы метода processArray");
    }



    public static String[][] generateArray(){
        int add = random.nextInt(2);
        String[][] array = new String[4 + add][4 + add];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = Integer.toString(random.nextInt(-99, 100));
            }
        }
        if (random.nextInt(5) == 0){
            array[random.nextInt(array.length)][random.nextInt(array[0].length)] = "abc";
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.printf("%s ", array[i][j]);
            }
            System.out.println();
        }
        return array;
    }

    /**
     *
     * @param array
     * @return
     * @throws MyArraySizeException некорректная размерность массива
     * @throws MyArrayDataException ошибка преобразования строки в число
     */
    public static int processArrayInternal(String[][] array) throws MyArraySizeException, MyArrayDataException{
        if (array.length != 4 || array[0].length != 4)
            throw new MyArraySizeException("Некорректный размер массива", array.length, array[0].length);

        int counter = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                counter += parseElement(array[i][j], i, j);
            }
        }
        return counter;
    }

    /**
     * Вспомогательный метод, преобразование значения элемента к числу
     * @param s значение элемента массива для анализа
     * @param x индекс элемента в измерении x
     * @param y индекс элемента в измерении y
     * @return результат преобразования строки в число
     * @throws MyArrayDataException ошибка преобразования строки в число
     */
    private static int parseElement(String s, int x, int y) throws MyArrayDataException{

        try {
            return Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            throw new MyArrayDataException("Некорректный формат данных", x, y);
        }
    }

}



















