package advancedsort;

import java.util.Arrays;

public class TestTreeSort {
    public static void main(String[] args) {
        int[] array = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        int[] array2 = {1, 3, 2, 4, 3, 2, 5, 3, 1, 2, 3, 4, 4, 3, 5, 1, 2, 3, 5, 2, 3, 1, 4, 3, 5, 1, 2, 1, 1, 1};

        TreeSortLogic treeSortLogic = new TreeSortLogic();
        //1. 힙 구조 정렬
        int[] heapSort = treeSortLogic.heapSort(array);
        System.out.println(Arrays.toString(heapSort));

        //2. 계수 정렬
        int[] countSort = treeSortLogic.countSort(array2);
        System.out.println(Arrays.toString(countSort));
    }


}
