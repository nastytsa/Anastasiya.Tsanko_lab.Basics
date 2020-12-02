package testing.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Character.toLowerCase;

public class Functions {

    //a function that takes a list of non-negative integers and strings and returns a new
    //list with the strings filtered out.
    static ArrayList getIntegersFromList(List list){
        ArrayList ints = new ArrayList();
        for (var v:list) {
            if(v.getClass() == Integer.class) {
                ints.add(v);
            }
        }
        return ints;
    }

    //a function that takes a string input, and returns
    //the first character that is not repeated anywhere in the string.
    static char first_non_repeating_letter(String string){
        for (int i = 0; i < string.length(); i++) {
            boolean unique = true;
            char c = toLowerCase(string.charAt(i));
            for (int j = 0; j < string.length(); j++) {
                if (i != j && c == toLowerCase(string.charAt(j))) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                return string.charAt(i);
            }
        }
        return ' ';
    }

    //Digital root is the recursive sum of all the digits in a number.
    //Given n take the sum of the digits of n. If that value has more than one digit, continue
    //reducing in this way until a single-digit number is produced. The input will be a non-
    //negative integer.
    static int digital_root(int number){
        int num = number;
        int sum = 0;
        while(num%10 > 0)
        {
            sum = (num%10) + sum;
            num = num/10;
        }

        if(sum/10 > 0)
            return digital_root(sum);
        return sum;
    }

    //There is an array of numbers - arr [1, 3, 6, 2, 2, 0, 4, 5]
    //there is a number target = 5.
    //Count the number of pairs in the array, the sum of which will give target
    static int count_pairs(int[] array, int sum){
        int pairs = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++){
                if( i!= j && array[i] + array[j] == sum)
                    pairs++;
            }
        }
        return pairs;
    }

    static int count_pairs_stream(int[] array, int sum){
        int pairs = 0;
        for(int i = 0; i < array.length; i++) {
            int finalI = i;
            pairs += IntStream.range(finalI,  array.length)
                    .filter(j -> finalI != j && array[finalI] + array[j] == sum).count();
        }
        return pairs;
    }

    //Den has invited some friends.
    //Could you make a program that
    // makes this string uppercase
    // gives it sorted in alphabetical order by last name.
    //When the last names are the same, sort them by first name. Last name and first name of a
    //guest come in the result between parentheses separated by a comma.
    static String sort_friends(String friends){
        List<Person> personList = new ArrayList<>();
        String person[];
        friends = friends.toUpperCase();
        for (String splt:friends.split(";")) {
            person = splt.split(":");
            personList.add(new Person(person[0], person[1]));
        }
        Collections.sort(personList, Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
        StringBuilder friendsList = new StringBuilder();
        for (Person pers:personList) {
            friendsList.append(pers.to_string());
        }
        return friendsList.toString();
    }

    static class Person{
        private String name;
        private String surname;

        Person(String n, String s){
            this.name = n;
            this.surname = s;
        }

        String getName(){
            return name;
        }
        String getSurname(){
            return surname;
        }
        String to_string(){
            return ("(" + surname + ", " + name + ")");
        }
    }

    public static void main(String args[]){
    }
}


