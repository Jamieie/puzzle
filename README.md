# 👾 Puzzle

## 💡 풀이과정

아래와 같이 필요한 기능 구분하여 애플리케이션 기능 구현

```
1. 숫자 배열 리스트 생성하기
2. 리스트에서 특정 두 숫자의 위치 서로 바꾸기
3. 리스트 오름차순 정렬 여부 확인하기
4. 사용자로부터 값 입력 받고 유효성 검사하기
```

### 숫자 배열 리스트 생성하기

- 1~8의 모든 수가 담긴 리스트 생성 후 배열 순서만 무작위로 재배치
- 1~8 사이의 수를 랜덤으로 뽑아서 중복여부 검사 후 리스트에 추가하는 방법
    ➡ 리스트가 채워질수록 중복되는 경우가 많아지므로 숫자 뽑는 횟수가 증가, 어차피 1~8의 모든 숫자가 들어가야 하므로 **비효율적**이라고 판단함

### 리스트에서 특정 두 숫자의 위치 서로 바꾸기

- 리스트에서 두 숫자의 인덱스 추출하여 위치 교환

### 리스트 오름차순 정렬 여부 확인하기

- i번째의 수가 i+1번째 수보다 작은지 확인하여 정렬 여부 확인
- 처음에는 final로 오름차순 정렬 된 리스트 필드 만들어서 동일한지 비교하는 방식을 생각했으나, 퍼즐 숫자 개수가 바뀐다거나 할 때 정답 또한 수정 필요하므로 비적합하다고 판단

### 사용자로부터 값 입력 받고 유효성 검사하기

```
입력값 : 콤마(,)로 구분하여 두 개의 숫자를 입력 (e.g. 1,4)

<입력 형태 조건>
1. 숫자와 콤마(,)만 입력해야 한다.
2. 콤마(,)는 하나만 입력해야 한다.
3. 두 개의 수를 입력해야 한다.
4. 입력값 시작에 공백이 없어야 한다.

<입력 숫자 조건>
1. 1~8 사이의 숫자여야 한다.
2. 입력된 수가 서로 중복되지 않아야 한다.
```

- 각 입력 조건에 대한 함수 구현하여 유효성 검사
- 유효성하지 않은 값 입력 시 예외 발생 `throw new IllegalArgumentException()`
- 예외 발생하면 예외메시지 출력 후 다시 값 입력 받는 함수 실행

---

## 👩‍🏫 코드설명

### 숫자 리스트 생성

    public class NumberGenerator {
        private final int NUMBERS_SIZE = 8;
    
        public List<Integer> createNumbers() {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < NUMBERS_SIZE; i++) {
                numbers.add(i+1);
            }
            Collections.shuffle(numbers);
            return numbers;
        }
    }

- `for`문 사용하여 1부터 8까지 차례로 삽입한 리스트 생성
- `Collections.shuffle()` 사용하여 배열 순서 셔플

### 리스트 내 특정 값의 위치 서로 바꾸기

    public void swap(List<Integer> values) {
        int index1 = numbers.indexOf(values.get(0));
        int index2 = numbers.indexOf(values.get(1));

        Collections.swap(numbers, index1, index2);
    }

- `indexOf()` 함수로 위치를 바꾸려고 하는 값의 인덱스 탐색
- `Collections.swap()` 사용하여 두 인덱스에 위치한 값 바꾸기

### 리스트 오름차순 정렬여부 확인

    public boolean isSorted() {
        return IntStream.range(0, numbers.size()-1)
                .allMatch(i -> numbers.get(i) < numbers.get(i + 1));
    }

- `allMatch()`로 모든 원소에 대해 인덱스 i에 위치한 값보다 i+1 값이 더 큰지 확인
- `range()` 범위 지정 : 원소의 제일 마지막 값은 뒤에 비교할 값이 없으므로 (배열길이-1)까지로 범위 지정

### 입력값 유효성 검사 - 중복값 여부

    public boolean hasDuplicate(List<Integer> values) {
        return values.size() != values.stream().distinct().count();
    }

- 리스트 내 중복 값 제거 후 기존 리스트와 길이가 같은지 확인
- 길이가 같으면 중복 없음, 다르면 중복 존재

### 사용자 입력값 숫자 배열로 변환

    private List<Integer> toIntegers(String input) {
        List<Integer> inputNumbers;
        try {
            inputNumbers = Arrays.stream(input.trim().split(","))
                    .map(i -> Integer.parseInt(i.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못 입력하셨습니다. 다시 입력해 주세요.");
        }
        return inputNumbers;
    }

- 입력값 앞뒤 공백 제거하여 콤마(,) 기준으로 분리
- 분리한 값 앞뒤 공백 제거하여 `Integer`로 타입 변환
- `try-catch`로 숫자가 아닌 경우 예외 처리
- 리스트에 담아서 반환

### 입력값 유효하지 않을 시 메세지 출력 후 다시 입력 받는 기능

    private static List<Integer> askNumber() {
        InputView inputView = new InputView();
        List<Integer> input;
        while (true) {
            try {
                input = inputView.readInput();
                validateNumbers(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
        System.out.println();
        return input;
    }

- 사용자로부터 값 입력 받고 입력값 유효하지 않을 시 예외 메세지 출력하는 코드 `while(true)` 안에 넣어서 계속 반복
- 사용자 입력값 유효할 시 `break;`으로 `while`문 벗어나기

### 게임 진행

    public static void main(String[] args) {
        int turn = 1;
        boolean isSorted = false;
        while (!isSorted) {
            List<Integer> input = askNumber();
            puzzle.swap(input);

            turn++;
            outputView.printResult(turn, puzzle.getNumbers());
            isSorted = puzzle.isSorted();
            System.out.println();
        }
        outputView.printSuccess(turn);
    }

- `while(!isSorted)` 오름차순 정렬 여부가 `false`이면 아래 과정 반복
  - `List<Integer> input = askNumber()` 사용자에게 값 입력 받기
  - `puzzle.swap(input)` 입력값 토대로 퍼즐 재배치
  - `turn++` 턴 수 1 증가
  - `isSorted = puzzle.isSorted()` 오름차순 정렬 여부 확인

---

## 💎 실행결과

```
간단 숫자 퍼즐
Turn 1
[7, 5, 2, 6, 1, 8, 3, 4]
교환할 두 숫자를 입력>
1,100

잘못 입력하셨습니다. 다시 입력해 주세요.

교환할 두 숫자를 입력>
 1,7

잘못 입력하셨습니다. 다시 입력해 주세요.

교환할 두 숫자를 입력>
일,칠

잘못 입력하셨습니다. 다시 입력해 주세요.

교환할 두 숫자를 입력>
1,,7

잘못 입력하셨습니다. 다시 입력해 주세요.

교환할 두 숫자를 입력>
1,7,

잘못 입력하셨습니다. 다시 입력해 주세요.

교환할 두 숫자를 입력>
1

잘못 입력하셨습니다. 다시 입력해 주세요.

교환할 두 숫자를 입력>
,

잘못 입력하셨습니다. 다시 입력해 주세요.

교환할 두 숫자를 입력>
1,7

Turn 2
[1, 5, 2, 6, 7, 8, 3, 4]

교환할 두 숫자를 입력>
2, 5

Turn 3
[1, 2, 5, 6, 7, 8, 3, 4]

교환할 두 숫자를 입력>
3,  5

Turn 4
[1, 2, 3, 6, 7, 8, 5, 4]

교환할 두 숫자를 입력>
6 ,4

Turn 5
[1, 2, 3, 4, 7, 8, 5, 6]

교환할 두 숫자를 입력>
5 , 7

Turn 6
[1, 2, 3, 4, 5, 8, 7, 6]

교환할 두 숫자를 입력>
6,8

Turn 7
[1, 2, 3, 4, 5, 6, 7, 8]

축하합니다! 7턴만에 퍼즐을 완성하셨습니다!
```