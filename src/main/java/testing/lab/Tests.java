package testing.lab;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests{
    @Test
    public void task1_1(){
        final ArrayList output = Functions.getIntegersFromList(Arrays.asList(1, 2 ,'a', 'b', 0, 15));
        final List<Integer> expected = Arrays.asList(1, 2, 0, 15);
        assertEquals(expected, output);
    }

    @Test
    public void task1_2(){
        final ArrayList output = Functions.getIntegersFromList(Arrays.asList(1, 2 ,'a', 'b', "aasf", '1', "123", 231));
        final List<Integer> expected = Arrays.asList(1, 2, 231);
        assertEquals(expected, output);
    }

    @Test
    public void task2_1(){
        final char output = Functions.first_non_repeating_letter("sTreSs");
        final char expected = 'T';
        assertEquals(expected, output);
    }

    @Test
    public void task2_2(){
        final char output = Functions.first_non_repeating_letter("aabBcc");
        final char expected = ' ';
        assertEquals(expected, output);
    }

    @Test
    public void task3_1(){
        final int output = Functions.digital_root(123);
        final int expected = 6;
        assertEquals(expected, output);
    }

    @Test
    public void task3_2(){
        final int output = Functions.digital_root(834952);
        final int expected = 4;
        assertEquals(expected, output);
    }

    @Test
    public void task4_1(){
        final int output = Functions.count_pairs(new int[]{1, 3, 6, 2, 2, 0, 4, 5}, 5);
        final int expected = 4;
        assertEquals(expected, output);
    }

    @Test
    public void task4_2(){
        final int output = Functions.count_pairs_stream(new int[]{1, 3, 3, 3}, 4);
        final int expected = 3;
        assertEquals(expected, output);
    }

    @Test
    public void task4_3(){
        final int output = Functions.count_pairs(new int[]{1, 2, 3}, 8);
        final int expected = 0;
        assertEquals(expected, output);
    }

    @Test
    public void task5_1(){
        final String output = Functions.sort_friends("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill");
        final String expected = "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)";
        assertEquals(expected, output);
    }

    @Test
    public void task5_2(){
        final String output = Functions.sort_friends("Maryna:Gnomenko;Maryna:Gnomenko;Ganna:Masher;Alex:Alexandrov");
        final String expected = "(ALEXANDROV, ALEX)(GNOMENKO, MARYNA)(GNOMENKO, MARYNA)(MASHER, GANNA)";
        assertEquals(expected, output);
    }
}


