package ru.matyunin.inno.task.models;

import java.util.Objects;

public class People implements Comparable<People>{
    private String peopleName;
    private final Sex peopleSex;
    private int peopleAge;

    public People(String peopleName, Sex peopleSex, int peopleAge) {
        this.peopleName = peopleName;
        this.peopleSex = peopleSex;
        this.peopleAge = peopleAge;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public void setPeopleAge(int peopleAge) {
        this.peopleAge = peopleAge;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public Sex getPeopleSex() {
        return peopleSex;
    }

    public int getPeopleAge() {
        return peopleAge;
    }



    @Override
    public int compareTo(People o) {
        int result = this.getPeopleSex().compareTo(o.getPeopleSex());
        if(result==0){
            result = this.getPeopleName().compareTo(o.getPeopleName());
            if (result==0) {
                result = this.getPeopleAge() - o.getPeopleAge();
            }
        }

        return result;
    }

    public enum Sex {
        WOMAN("WOMAN"),
        MAN("MAN");

        private final String sexTitle;

        Sex(String sexTitle) {
            this.sexTitle = sexTitle;
        }

        public String getSexTitle() {
            return sexTitle;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return peopleAge == people.peopleAge && Objects.equals(peopleName, people.peopleName) && Objects.equals(peopleSex, people.peopleSex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleName, peopleSex, peopleAge);
    }

    @Override
    public String toString() {
        return "{ " + peopleName + " | " + peopleSex + " | " + peopleAge + " }";
    }

}
