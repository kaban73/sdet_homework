package lection_6.dao;

public class Person {
    private String name;
    private int age;
    private int weight;
    public String getPersonName() {
        return name;
    }
    public int getPersonAge() {
        return age;
    }
    public int getPersonWeight() {
        return weight;
    }

    public static class Builder {
        private Person person;
        public Builder() {
            person = new Person();
        }
        public Builder withName(String name) {
            person.name = name;
            return this;
        }
        public  Builder withAge(int age) {
            person.age = age;
            return  this;
        }
        public Builder withWeight(int weight) {
            person.weight = weight;
            return this;
        }
        public Person build() {
            return person;
        }
    }
}
