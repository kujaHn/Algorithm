package basicsort;

public class BasicSortLogic {

    public int[] selectionSort(int[] array) {
        int minIndex;
        int temp;

        // 찾는 범위 설정
        for (int i = 0; i < array.length-1; i++) {
            minIndex = i;
            // 가장 작은 수 탐색
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 스와핑
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public int[] bubbleSort(int[] array) {
        int temp;

        // 처음부터 다시 반복
        for (int i = 0; i < array.length; i++) {
            // 숫자를 비교하는 구간
            for (int j = 0; j < array.length -1 - i; j++) {
                if (array[j] > array[j+1]) {
                    // 스와핑
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public int[] insertSort(int[] array) {
        int temp;

        // 원소 이동(반복회수 설정)
        for (int i = 0; i < array.length; i++) {
            int j = i;
            // 해당 원소의 앞 구간이 정렬이 완전히 될 때 까지 숫자를 비교하는 구간
            while (j > 0 && array[j - 1] > array[j]) {
                temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
                j--;
            }
            /*로직 체크용
            for (int k = 0; k <= i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println("");

             */
        }
        return array;
    }

    public int[] quickSort(int[] array, int start, int end) {

        // 원소가 1개인 경우 그대로 두기
        if (start >= end) {
            return array;
        }

        int pivot = start;  // 피벗은 첫 번째 원소
        int i = start + 1;  // 왼쪽에서 출발
        int j = end;        // 오른쪽에서 출발
        int temp = 0;

        // 엇갈릴때까지 반복
        while (i <= j) {
            // 피벗보다 큰 값이 나올때까지 탐색
            while (array[i] <= array[pivot] && i <= end) {
                i++;
            }
            // 피벗보다 작은 값이 나올때까지 탐색
            while (array[j] >= array[pivot] && j > start) {
                j--;
            }
            // i, j를 다 구했음으로 엇갈렸는지 아닌지 확인
            if (i > j) {
                // 엇갈린 상태면 피벗과 교체
                temp = array[j];
                array[j] = array[pivot];
                array[pivot] = temp;
            } else {
                // 엇갈리지 않았으면 작은값 큰값을 교체
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 피벗 기준으로 구역 나누기
        quickSort(array, start, j - 1);
        quickSort(array, j+1, end);

        return array;
    }

    public void mergeSort(int[] array, int start, int end) {

        if (start < end) {
            int middle = (start + end) / 2;
            // 원소를 각각 쪼개는 과정.
            mergeSort(array, start, (int) middle);
            mergeSort(array, (int) middle+1, end);
            merge(array, start, middle, end);
        }
    }

    public int[] merge(int[] array, int start, int middle, int end){
        int[] sortedArray = new int[10];
        int i = start;
        int j = middle + 1;
        int k = start;  // sortedArray의 index

        // 각 묶음 원소 크기 비교
        while (i <= middle && j <= end) {
            if (array[i] <= array[j]) {
                sortedArray[k] = array[i];
                i++;
            } else {
                sortedArray[k] = array[j];
                j++;
            }
            k++;
        }

        // 나머지 데이터 삽입.
        if (i > middle) {
            while (j <= end) {
                sortedArray[k] = array[j];
                j++;
                k++;
            }
        } else {
            while (i <= end) {
                sortedArray[k] = array[i];
                i++;
                k++;
            }
        }

        return sortedArray;
    }
}
