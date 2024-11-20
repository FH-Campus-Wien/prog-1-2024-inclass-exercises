package at.ac.fhcampuswien.person;

public class Person {
    
    private String name;
    private SimpleDate birthday;

    public Person(String name, int day, int month, int year) {
        this (name, new SimpleDate(day, month, year));
    }

    public Person(String name, SimpleDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public boolean equals(Object o) {
        if(o==null) {
            return false;
        }

        if (this == o) {
            return true;
        }
        if (! (o instanceof Person)) {
            return false;
        }

        Person other= (Person) o;
        return this.name.equals(other.name) && this.birthday.equals(other.birthday);
    }

    public Person (String name) {
        this(name, null);
    }

    public Person( Person other) {
        this.name = other.name;
        this.birthday = new SimpleDate(other.birthday);
    }

    public void youthen(int years) {
        this.birthday.setYear(this.birthday.getYear() + years);
    }

    public void youthen() {
        this.birthday.setYear(this.birthday.getYear() + 1);
    }


    public void marry() {
        this.name= this.name +", married";
    }

    public String toString() {
        return this.name +" (" + this.birthday + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleDate getBirthday() {
        return birthday;
    }

    public void setBirthday(SimpleDate birthday) {
        this.birthday = birthday;
    }
}
