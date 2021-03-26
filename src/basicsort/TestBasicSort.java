package basicsort;

import java.util.Arrays;

public class TestBasicSort {
    public static void main(String[] args) {
        int[] testArray1 = new int[]{1, 10, 3, 6, 4, 7, 9, 8, 2, 5};

        BasicSortLogic basicSortLogic = new BasicSortLogic();

        // 1. 선택정렬 테스트
        basicSortLogic.selectionSort(testArray1);
        System.out.println(Arrays.toString(testArray1));

        // 2. 버블정렬 테스트
        basicSortLogic.bubbleSort(testArray1);
        System.out.println(Arrays.toString(testArray1));

        // 3. 삽입정렬 테스트
        basicSortLogic.insertSort(testArray1);
        System.out.println(Arrays.toString(testArray1));

        // 4. 퀵정렬 테스트
        basicSortLogic.quickSort(testArray1, 0, testArray1.length-1);
        System.out.println(Arrays.toString(testArray1));

        // 5. 병합정렬 테스트
        basicSortLogic.mergeSort(testArray1, 0, testArray1.length-1);
        System.out.println(Arrays.toString(testArray1));
    }
}
