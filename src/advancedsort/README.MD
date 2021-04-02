# 고급 정렬
기본적인 정렬들을 모두 다루었으니 이번에는 좀 더 고급 스킬의 정렬들을 다뤄볼 차례이다.  
기본적으로 이번 파트는 `트리`에 대해서는 꼭 알고 있어야 따라오기가 쉽다.

## 목차
* [힙 정렬](#힙-정렬)
* [계수 정렬](#계수-정렬)

## Question
다음 숫자를 오름차순으로 정렬하는 프로그램을 작성하시오.  
```
[7 6 5 8 3 5 9 1 6]
```

## Solution

## 힙 정렬
* 최대 힙 구조는 **부모 노드의 값이 자식 노드보다 항상 커야 한다**
* 힙 정렬은, **최대 힙구조가 아닌 구간의 두 자식 중 더 큰 자식과 자신의 위치를 바꾸는 알고리즘 이다.**
* 시간복잡도
    ```
    O(log N)
    ```
### 로직
**Main Idea**
```
최대 힙구조가 아닌 구간의 두 자식 중 더 큰 자식과 부모노드의 위치를 바꾸자.
루트노드를 마지막 인덱스의 원소로 보내 밀어내기 방식의 정렬을 수행하자.
```
1. 1차 힙 정렬 실행 이진트리이기 떄문에 `원소개수의 1/2`번만 실행하면 된다.
2. 첫번째 작업을 실행했으면 `루트노드`에는 가장 큰 값이 있을 것이다. 이 값을 `제일 뒤로 보낸다.` (밀어내기)
3. 다음 정렬부터는 마지막 원소는 정렬이 된 상태니 이 원소를 제외하고 시작한다.
4. 반복.

**1st**  
사진 첨부  
**2nd**  
사진 첨부  

<br>

* 코드 구현
```java
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
```

***

## Question
다음 숫자를 오름차순으로 정렬하는 프로그램을 작성하시오.
```
[1 3 2 4 3 2 5 3 1 2 3 4 4 3 5 1 2 3 5 2 3 1 4 3 5 1 2 1 1 1]
```

## 계수 정렬
* **범위 조건이 있는 경우**에 한해 굉장히 빠른 알고리즘을 계수정렬이라고 한다.
* 시간복잡도
    ```
    O(N)
    ```

### 로직
[시뮬레이션](https://www.cs.miami.edu/home/burt/learning/Csc517.091/workbook/countingsort.html) 을 참고하자  
**Main Idea**
  ```
  크기를 기준으로 갯수를 세자.
  ```
* 크기를 기준으로 갯수만 세주면 되기 때문에 위치를 바꿀 필요가 없음.
* 그렇기 때문에 **모든 데이터에 한 번씩만 접근하면 된다.**

**1st**  
주어진 배열의 원소의 최대값을 크기로 가지는 `countArr` 배열 생성.
<img src = "Algorithm/image/counting-sort1.png">  

**2nd**  
Question 인덱스의 원소를 **순차적으로 탐색** 후 그 크기에 맞는 `countArr` 인덱스의 원소를 `1` 증가.  
  
**3rd**
반복해서 새로운 배열에 순차적으로 입력하기 위해서 누적 합 계산을 통한 `index` 계산  

**4th**
문제의 배열을 뒤에서부터 탐색해가며 정렬하자. (단항연산자를 센스것 이용하면 코드를 줄일 수 있다.)
  
* 코드 구현
```java
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

        // 2nd. 순차적으로 탐색 후 크기에 맞는 인덱스의 원소를 1씩 증가
        for (int i = 1; i < array.length; i++) {
            countArr[array[i]]++;
        }

        // 3rd. 누적 합 계산을 통한 index를 계산
        
        for (int i = 1; i < size; i++) {
            countArr[i] += countArr[i-1];
        }
        /** 위의 코드를 Stream으로 변환
        IntStream.range(1, size).forEach(i -> countArr[i] += countArr[i-1]);*/

        for (int k=array.length-1; k>=0; k--) {
            sortedArray[countArr[array[k]]--] = array[k];
        }
        return sortedArray;
    }
```

***