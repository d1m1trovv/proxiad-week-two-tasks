package proxiad;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private String street;
    private int number;

    public void printInfo() {
        System.out.println(
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", age = " + age +
                ", city = '" + city + '\'' +
                ", street = '" + street + '\'' +
                ", number = " + number
                );
    }

    public Person(){}

    public Person(String firstName, String lastName, int age, String city, String street, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.street = street;
        this.number = number;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
