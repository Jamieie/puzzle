# 👾 puzzle

사용자로부터 값을 입력 받고 그 값을 인접한 빈자리로 이동하는 과정을 반복하여 퍼즐을 오름차순으로 정렬하는 게임

## 💡 풀이과정

### 2차원 퍼즐

- 2차원 퍼즐 `Map<Integer, List<Integer>>`로 구현
- 특정값의 위치 좌표로 관리
  - `Coordinate` 객체 생성하여 좌표 관리
  - `key` 값이 y좌표
  - `value` 인 `List<Integer>`의 인덱스 값이 x좌표

### 퍼즐 생성

- 1~16의 숫자 생성 후 랜덤하게 섞기
- 랜덤한 숫자 배열 차례로 하나씩 퍼즐 자리에 할당

### 퍼즐 빈자리

- 빈자리에 숫자 16 할당하여 관리
  - `private final int VACANCY_NUMBER = 16;` 상수로 관리
- 숫자 16 할당한 이유
  - 퍼즐 리스트는 숫자만 담을 수 있다.
  - 오름차순 정렬 여부 확인 시 빈자리 위치는 제일 끝이다.

### 빈자리로 이동

- 입력값과 빈자리 좌표 구해서 각 값 기존 자리에서 삭제 및 서로의 자리로 추가

### 오름차순 정렬 여부 확인

- 퍼즐 `Map<Integer, List<Integer>>`의 value 즉, list 정렬 여부 확인
- 각 value 끼리 비교 : 앞 list의 마지막 값 보다 뒤 list의 첫 번째 값이 큰지 확인

### 사용자로부터 값 입력

- `Scanner`의 `nextLine()` 사용하여 값 읽기
  - `nextInt()` 사용 시 사용자가 엔터만 치는 경우 계속 입력값 기다리는 문제 발생
  - `nextLine()` 사용하여 엔터만 입력했을 경우 에러 날리도록 처리 가능

### 입력값이 유효하지 않을 경우 다시 입력 받는 기능

- 유효하지 않은 값 입력 시 예외 메시지와 함께 예외날리기
  - 예외 발생 X : 아래 코드 순차 실행
  - 예외 발생 O : 예외 메시지 출력, 다시 입력 받는 루프 돌도록 `while`로 구현

---

## 👩‍🏫 코드 설명

### 퍼즐 배열 생성하는 코드

    public Map<Integer, List<Integer>> createNumbers() {
        List<Integer> shuffled = shuffleNumbers();
        
        // 숫자 배열 Map으로 반환
        Map<Integer, List<Integer>> numbers = new HashMap<>();
        for (int i = 0; i < PUZZLE_SIDE_LENGTH; i++) {
            List<Integer> rowNumbers = new ArrayList<>();
            for (int j = 0; j < PUZZLE_SIDE_LENGTH; j++) {
                
                // 랜덤하게 섞인 숫자 리스트에서 제일 앞에 위치한 값을 빼서 퍼즐 배열에 담기
                rowNumbers.add(shuffled.get(0));

                // 배열에 담은 후 담긴 값은 리스트에서 삭제
                shuffled.remove(0);
            }
            numbers.put(i, rowNumbers);
        }
        return numbers;
    }

    // 1~16의 숫자를 생성하여 순서를 랜덤하게 섞어 리스트 반환
    private List<Integer> shuffleNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < PUZZLE_SIZE; i++) {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
    

### 특정 좌표의 인접한 좌표 구하는 코드

    public List<Coordinate> findNearCoordinates() {
        List<Coordinate> coordinates = new ArrayList<>();

        // 좌표값이 0 또는 3 (가장 끝의 값)이 아니면 위아래,좌우 좌표값 구하여 추가하는 코드
        if (y > 0) {
        coordinates = addCoordinates(coordinates, x, y - 1);
        }
        if (y < 3) {
        coordinates = addCoordinates(coordinates, x, y + 1);
        }
        if (x > 0) {
        coordinates = addCoordinates(coordinates, x - 1, y);
        }
        if (x < 3) {
        coordinates = addCoordinates(coordinates, x + 1, y);
        }
        return coordinates;
        }

    // 인접한 좌표 담은 리스트에 좌표 객체 추가하는 코드
    private List<Coordinate> addCoordinates(List<Coordinate> coordinates, int x, int y) {
        Coordinate coordinate = new Coordinate();
        coordinate.setXY(x, y);
        coordinates.add(coordinate);
        return coordinates;
    }

### 퍼즐 내부에서 특정 값의 좌표 구하는 코드

    private Coordinate findPosition(int value) {
        Coordinate coordinate = new Coordinate();
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> row = numbers.get(i);
            int index = row.indexOf(value);
            if (index != -1) {                // 특정 값의 index 구하면 
                coordinate.setXY(index, i);   // 해당 열의 key값과 index로 좌표 생성
            }
        }
        return coordinate;
    }

puzzle 내의 모든 `list`에 대해 `indexOf()`로 인덱스 탐색

`list`에서 `indexOf()`로 특정 값의 인덱스 찾을 때, 값이 없으면 -1 반환하므로 -1이 아닐 경우 해당 열의 key 값과 인덱스를 좌표값으로 반환

### 퍼즐 오름차순 정렬 여부 확인하는 코드

    public boolean isSorted() {
        // 각 열이 오름차순으로 정렬되어 있는지 확인
        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> row = numbers.get(i);
            boolean isSortedList = IntStream.range(0, row.size() - 1).allMatch(j -> row.get(j) < row.get(j + 1));
            if (!isSortedList) {
                return false;
            }
        }
        // 각 열의 마지막 숫자 보다 뒷열의 첫번째 숫자가 큰지 확인
        for (int i = 0; i < numbers.size() - 1; i++) {
            List<Integer> row = numbers.get(i);
            List<Integer> rowAfter = numbers.get(i + 1);

            // 앞열의 마지막 숫자가 뒷열의 첫 번째 숫자보다 크면 false 리턴
            if (row.get(LAST_INDEX) > rowAfter.get(FIRST_INDEX)) {
                return false;
            }
        }
        return true;
    }

### 값 입력 받고 유효하지 않은 값 입력 시 다시 입력 받는 코드

    private static int askNumber(Puzzle puzzle) {
        InputView inputView = new InputView();
        int input;
        while (true) {  // 사용자로부터 값 입력 받는 코드 무한 반복
            try {
                input = inputView.readLine();
                validate(puzzle, input);
                break;  // 위 코드 예외 발생 없이 수행 시 while문 벗어나기
            } catch (IllegalArgumentException e) {
                System.out.println();
                System.out.println(e.getMessage());  // 예외 메시지 출력
                System.out.println();
            }
        }
        return input;
    }

- `while (true)`로 값 입력 받는 코드 무한 반복 시행
- 예외 발생하면 예외 메시지 출력 후 `while (true)` 내부 코드 반복
- 예외 발생 없이 `readLine()`, `validate()` 통과하면 `break;`으로 `while`문 벗어나기