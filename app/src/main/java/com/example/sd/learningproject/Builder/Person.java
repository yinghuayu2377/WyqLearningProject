package com.example.sd.learningproject.Builder;

public class Person {

    private String name;
    private int age;
    private boolean isGirl;

    private Person(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.isGirl = builder.isGirl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGirl(boolean isGirl) {
        this.isGirl = isGirl;
    }

    public boolean isGirl() {
        return isGirl;
    }

    static class Builder {
        private String name;
        private int age;
        private boolean isGirl;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder isGirl(boolean isGirl) {
            this.isGirl = isGirl;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
