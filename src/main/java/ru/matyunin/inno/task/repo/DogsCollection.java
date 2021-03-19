package ru.matyunin.inno.task.repo;

import ru.matyunin.inno.task.models.Dog;
import ru.matyunin.inno.task.models.DogNameComparator;
import ru.matyunin.inno.task.models.DogOwnerComparator;

import java.util.*;

public class DogsCollection {
    private final Map<Integer, Dog> dogMap = new HashMap<>();

    public DogsCollection() {

    }

    public void addsDog(Dog dog) throws IllegalArgumentException {

        if (this.dogMap.put(dog.getDogId(), dog) != null) {
            throw new IllegalArgumentException("Невозможно добавить " + dog.toString() + ", так как такая собака уже есть в картотеке");
        }
    }

    public void editDog(int id, String name, int weight, String peopleName, int peopleAge) {
        Dog dog = dogMap.get(id);
        dog.setDogName(name);
        dog.setWeight(weight);
        dog.getDogOwner().setPeopleName(peopleName);
        dog.getDogOwner().setPeopleAge(peopleAge);

    }

    public List<Dog> dogSearch(String searchDogName) {
        List<Dog> searchedList = sortedDogs(new DogNameComparator());
        List<Dog> resultList = new ArrayList<>();
        int low = 0;
        int high = searchedList.size() - 1;
        int mid = (low + high) / 2;
        if (searchedList.get(mid).getDogName().compareTo(searchDogName) < 0) {
            do {
                mid++;
                if (searchedList.get(mid).getDogName().equals(searchDogName)) {
                    resultList.add(searchedList.get(mid));
                }

            } while (mid < high && searchedList.get(mid).getDogName().compareTo(searchDogName) <= 0);

        } else if ((searchedList.get(mid).getDogName().compareTo(searchDogName) > 0)) {
            do {
                mid--;
                if (searchedList.get(mid).getDogName().equals(searchDogName)) {
                    resultList.add(searchedList.get(mid));
                }

            } while (mid > low && searchedList.get(mid).getDogName().compareTo(searchDogName) >= 0);

        } else if (searchedList.get(mid).getDogName().equals(searchDogName)) {
            for (Dog d : searchedList) {
                if (d.getDogName().equals(searchDogName)) {
                    resultList.add(d);
                }
            }
        }

        return resultList;
    }

    public List<Dog> printDogs() {
        return sortedDogs(new DogOwnerComparator());
    }

    public List<Dog> sortedDogs(Comparator<? super Dog> comparator) {
        List<Dog> sortedList = new ArrayList<>(dogMap.values());
        sortedList.sort(comparator);
        return sortedList;
    }

    @Override
    public String toString() {
        return "DogCollection{" +
                "dogMap=\n" + dogMap +
                '}';
    }
}
