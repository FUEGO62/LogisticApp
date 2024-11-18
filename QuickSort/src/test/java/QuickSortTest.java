import org.example.QuickSort;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class QuickSortTest {

    @Test
    public void quickSortTest(){

        int[]numbers = {9,2,1,7,4};
        int start = 0;
        int end = numbers.length-1;
        QuickSort.quickSort(numbers,start,end);
        int [] expected = {1,2,4,7,9};
        assertArrayEquals(expected,numbers);
    }

    @Test
    public void findMaximumProductTest(){
        int[]numbers = {9,2,1,7,4};
        numbers = QuickSort.findMaximumProductTest(numbers);

        assertArrayEquals(new int[]{7,9}, numbers);
    }
}
