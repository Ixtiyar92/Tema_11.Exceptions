package ru.geekbrains.lesson3;

public class Task2 {

    /**
     Создайте класс Счетчик, у которого есть метод add(), увеличивающий
     значение внутренней int переменной на 1. Сделайте так, чтобы с объектом
     такого типа можно было работать в блоке try-with-resources. Подумайте, что
     должно происходить при закрытии этого ресурса? Напишите метод для
     проверки, закрыт ли ресурс. При попытке вызвать add() у закрытого
     ресурса, должен выброситься IOException.
     */
    public static void main(String[] args) {
        try (Counter counter = new Counter(1000)){

            counter.add();
            counter.add();
            System.out.printf("Текущее значение счетчика: %d\n", counter.getCounter());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

class Counter implements AutoCloseable{

    private int counter;
    private boolean isOpen;

    public int getCounter() {
        return counter;
    }

    public int add() throws  CloseCounterException{
        if (!isOpen)
            throw new CloseCounterException("Счетчик закрыт!");
        return ++counter;
    }

    public Counter() {
        isOpen = true;
    }

    public Counter(int counter) {
        this.counter = counter;
        isOpen = true;
    }

    @Override
    public void close() throws Exception {
        isOpen = false;
    }

}

class CloseCounterException extends Exception{
    public CloseCounterException(String message) {
        super(message);
    }
}









