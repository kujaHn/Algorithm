package advancedsort;

import java.util.stream.IntStream;

public class TreeSortLogic {

    int[] heapSort(int[] array) {

        // 1차 최대 힙 구조로 변경
        for (int i = 1; i < array.length; i++) {
            int c = i;
            do {
                int root = (c - 1) / 2;
                if (array[root] < array[c]) {
                    int temp = array[root];
                    array[root] = array[c];
                    array[c] = temp;
                }
                c = root;
            } while (c != 0);
        }

        // 루트노드를 최하위 노드로 보내기. (밀어내기)
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            int root = 0;
            int c = 1;
            do {
                c = 2 * root + 1;
                //자식 중 더 큰값 찾기
                if (c < i - 1 && array[c] < array[c + 1]) {
                    c++;
                }
                //루트보다 자식이 더 크다면 교환
                if (c < i && array[root] < array[c]) {
                    temp = array[root];
                    array[root] = array[c];
                    array[c] = temp;
                }
                root = c;
            } while (c < i);
        }

        return array;
    }

    int[] countSort(int[] array) {
        int max = 0;
        int size;

        int[] sortedArray = new int[array.length];

        // 최적의 크기를 찾아서 배열을 생성하는게 더 손해이기 때문에 쿨하게 생성.
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 크기 구하기
        size = max+1;
        System.out.println("size = " + size);

        int[] countArr = new int[size];

        //
        for (int i = 1; i < array.length; i++) {
            countArr[array[i]]++;
        }

        // 누적 합 계산을 통한 index계산
        /** Stream 변환
         * for (int i = 1; i < size; i++) {
         countArr[i] += countArr[i-1];
         }
         */
        IntStream.range(1, size).forEach(i -> countArr[i] += countArr[i-1]);

        for (int k=array.length-1; k>=0; k--) {
            sortedArray[countArr[array[k]]--] = array[k];
        }
        return sortedArray;
    }
}
