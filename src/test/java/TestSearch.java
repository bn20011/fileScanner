import fileservice.Search;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestSearch {

    @Test
    public void testSearchBinary(){
        ArrayList<Integer> intList= new ArrayList<>();
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(8);
        intList.add(9);
        intList.add(15);
        intList.add(20);
        intList.add(17);

//valid test
        Search search= new Search();
        int i= search.searchBinary(intList, 4);
        System.out.println(i);
        assertEquals(i, 4);
//invalid test
        int expectedInvalid = 5;
        int j = search.searchBinary(intList, 5);
        System.out.println(j);
        assertEquals(-1, j);
    }

}
