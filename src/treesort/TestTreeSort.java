package treesort;

import java.util.Arrays;

public class TestTreeSort {
    public static void main(String[] args) {
        int[] array = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        SortLogic sortLogic = new SortLogic();
        //1. 힙 구조 정렬
        int[] heapSort = sortLogic.heapSort(array);
        System.out.println(Arrays.toString(heapSort));
    }


}
