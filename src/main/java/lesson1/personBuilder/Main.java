package lesson1.personBuilder;

public class Main {
    public static void main(String[] args) {
        Person person1 = new PersonBuilder().setFirstName("Ivan").setLastName("Ivanov").setCountry("Russia").setAge(30).build();
        Person person2 = new PersonBuilder().setFirstName("Bob").setCountry("USA").setAddress("Unknown address").build();
        Person person3 = new PersonBuilder().setFirstName("Anna").build();

        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());

    }
}
