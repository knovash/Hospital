package root.human.doctor;

import root.human.properties.Address;

public class Test2 {

    public static void main(String[] args) {

        Address adr1 = new Address("ccc", "city", "street", 11);
        Address adr2 = new Address("ccc", "city", "street", 11);

        System.out.println(adr1.toString());
        System.out.println(adr2.toString());
        System.out.println(adr1 == adr2);
        System.out.println(adr1.equals(adr2));
    }
}

class Animal {
    private String name;
    private int id;

    @Override
    public String toString() {
        return "Animal " + "id={" + id + " " + name + '}';
    }

    public boolean equals(Object obj){

        System.out.println("print obj " + obj.toString());

        Animal other = (Animal) obj;
        other.getId();
        System.out.println("print other " + other.toString());
        return this.id != 0 & other.name != null &this.id == other.id & this.name.equals(other.name);
    }

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}