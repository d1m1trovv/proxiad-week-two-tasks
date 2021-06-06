package proxiad;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //peopleManipulator();
        //primeNumbers();
    }

    private static void peopleManipulator() throws IOException, URISyntaxException {
        Path path = Paths.get((Main.class
                .getResource("persons.txt")).toURI());

        List<String> data = Files.lines(path)
                .filter(e -> !e.isBlank())
                .collect(Collectors.toList());

        Function<String, Person> stringToPerson = s -> {
            String[] arr = s.split("[/,=]+");
            return new Person(arr[1], arr[3], Integer.parseInt(arr[5]), arr[7], arr[9], Integer.parseInt(arr[11]));
        };

        List<Person> people = data.stream()
                .map(stringToPerson)
                .collect(Collectors.toList());

        int longestName = people.stream()
                .mapToInt(p -> (p.getFirstName() + " " + p.getLastName()).length())
                .max()
                .orElseThrow(NoSuchElementException::new);


        System.out.println("Person with longest name: ");
        people.stream()
                .filter(p -> (p.getFirstName() + " " + p.getLastName()).length() == longestName)
                .forEach(Person::printInfo);

        System.out.println();

        System.out.println("People who live at street number 25: ");
        people.stream()
                .filter(p -> p.getNumber() == 25)
                .forEach(Person::printInfo);
    }

    private static void primeNumbers(){

        Predicate<Integer> isPrime = n -> IntStream.range(2, n)
                .noneMatch(i -> n % i == 0);

        List<Integer> primeNumbers = IntStream.range(3, 100)
                .filter(isPrime::test)
                .boxed()
                .collect(Collectors.toList());

        primeNumbers.stream()
                .limit(11)
                .forEach(System.out::println);
    }
}
