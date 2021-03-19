package ru.matyunin.inno.task.app;

import ru.matyunin.inno.task.models.Dog;
import ru.matyunin.inno.task.models.People;
import ru.matyunin.inno.task.repo.DogsCollection;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static DogsCollection generateData() {
        People people0 = new People("Василий", People.Sex.MAN, 58);
        People people1 = new People("Иван", People.Sex.MAN, 26);
        People people2 = new People("Мария", People.Sex.WOMAN, 36);
        People people3 = new People("Надежда", People.Sex.WOMAN, 28);
        People people4 = new People("Николай", People.Sex.MAN, 63);
        People people5 = new People("Федор", People.Sex.MAN, 42);
        People people6 = new People("Наталья", People.Sex.WOMAN, 27);
        People people7 = new People("Надежда", People.Sex.WOMAN, 28);
        People people8 = new People("Семен", People.Sex.MAN, 38);
        People people9 = new People("Галина", People.Sex.WOMAN, 42);

        Dog dog0 = new Dog("Жучка", people0, 3);
        Dog dog1 = new Dog("Стрелка", people1, 5);
        Dog dog2 = new Dog("Белка", people2, 2);
        Dog dog3 = new Dog("Рэкс", people3, 10);
        Dog dog4 = new Dog("Джек", people4, 15);
        Dog dog5 = new Dog("Шарик", people6, 5);
        Dog dog6 = new Dog("Бобик", people4, 5);
        Dog dog7 = new Dog("Стрелка", people0, 4);
        Dog dog8 = new Dog("Стрелка", people1, 5);
        Dog dog9 = new Dog("Белка", people2, 7);
        Dog dog10 = new Dog("Рэкс", people5, 12);
        Dog dog11 = new Dog("Джек", people7, 5);
        Dog dog12 = new Dog("Шарик", people9, 5);
        Dog dog13 = new Dog("Бобик", people8, 5);


        DogsCollection generatedDogsCollection = new DogsCollection();
        generatedDogsCollection.addsDog(dog0);
        generatedDogsCollection.addsDog(dog1);
        generatedDogsCollection.addsDog(dog2);
        generatedDogsCollection.addsDog(dog3);
        generatedDogsCollection.addsDog(dog4);
        generatedDogsCollection.addsDog(dog5);
        generatedDogsCollection.addsDog(dog6);
        generatedDogsCollection.addsDog(dog7);
        generatedDogsCollection.addsDog(dog8);
        generatedDogsCollection.addsDog(dog9);
        generatedDogsCollection.addsDog(dog10);
        generatedDogsCollection.addsDog(dog11);
        generatedDogsCollection.addsDog(dog12);
        generatedDogsCollection.addsDog(dog13);
        return generatedDogsCollection;
    }
    public static void main(String[] args) {

        DogsCollection dogsCollection = generateData();
        System.out.println("Создана коллекция:");
        System.out.println(dogsCollection.toString());

        //редактирование данных собаки
        dogsCollection.editDog(4, "Дружок", 50, "Влдаимир",100);
        //выведем на экран
        System.out.println("после изменения данных:");
        System.out.println(dogsCollection.toString());

        //печать отсортированной коллекции(порядок: хозяин, кличка, вес)
        System.out.println(dogsCollection.printDogs());

        //поиск собаки по имени
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя собаки для поиска");
        String dogName = scanner.nextLine();
        List<Dog> searchList= dogsCollection.dogSearch(dogName);
        System.out.println(searchList);
       // System.out.println(dogsCollection.sortedDogs(new DogNameComparator()));
        //проверка невозможности ввода дубликата собаки
        System.out.println("Введите имя собаки, которая уже есть в коллекции для добавления");
        dogName = scanner.nextLine();
        dogsCollection.addsDog(dogsCollection.dogSearch(dogName).get(0));


    }
}
