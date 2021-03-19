package ru.matyunin.inno.task.models;

import ru.matyunin.inno.task.models.Dog;

import java.util.Comparator;

public class DogNameComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.getDogName().compareTo(o2.getDogName());
    }

}