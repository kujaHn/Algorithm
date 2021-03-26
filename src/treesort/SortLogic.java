package treesort;

public class SortLogic {

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
}
