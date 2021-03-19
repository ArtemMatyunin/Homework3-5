package ru.matyunin.inno.task.models;


public class Dog {
    private final int dogId;
    private int weight;
    private String dogName;
    private final People dogOwner;


    public Dog(String dogName, People dogOwner, int weight) {
        this.dogId = dogSequence.setLastDogId();
        this.dogName = dogName;
        this.dogOwner = dogOwner;
        this.weight = weight;
    }

    public int getDogId() {
        return this.dogId;
    }

    public String getDogName() {
        return dogName;
    }

    public People getDogOwner() {
        return dogOwner;
    }

    public int getWeight() {
        return weight;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return this.getDogId() == dog.getDogId();
    }

    @Override
    public int hashCode() {
        return getDogId();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogId=" + dogId +
                ", dogName='" + dogName + '\'' +
                ", weight=" + weight +
                ", dogOwner=" + dogOwner +
                '}' + '\n';
    }

    private static class dogSequence {

        private static int lastDogId = -1;

        public static int setLastDogId() {
            return ++dogSequence.lastDogId;
        }

    }
}
