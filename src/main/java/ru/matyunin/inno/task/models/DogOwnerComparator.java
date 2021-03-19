package ru.matyunin.inno.task.models;

import ru.matyunin.inno.task.models.Dog;

import java.util.Comparator;

public class DogOwnerComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        int result = o1.getDogOwner().compareTo(o2.getDogOwner());
        if ( result == 0) {
            result = o1.getDogName().compareTo(o2.getDogName());
            if(result == 0){
                result = o1.getWeight()-o2.getWeight();
            }
        }
        return result;
    }

}
