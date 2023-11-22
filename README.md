# 👾 puzzle

## 🚀 1단계: 1차원 숫자퍼즐 구현하기

- 애플리케이션 설명 : 두 숫자의 위치를 바꾸는 과정을 반복하여 8개의 숫자를 오름차순으로 정렬하는 게임
- 핵심 기능 : 숫자의 배열이 오름차순으로 정렬될 때까지 사용자 입력값에 따라 두 숫자의 위치를 바꾸는 기능

### 📝 출력 기능

- [ ] title 출력
- [ ] turn 수 출력
- [ ] 숫자 배열 출력
- [ ] 게임 결과 및 종료 메세지 출력

### ✏️ 입력 기능

- [x] 사용자로부터 값을 입력 받는 기능
  ```
  <입력 형태>
  - 콤마(,)로 구분하여 두 개의 숫자 입력
  - 콤마 뒤에 공백 삽입 가능
  - 입력 시작 시 공백 삽입 불가
  e.g. '1,3' / '5, 7' ..
  ```

### 👀 입력값 유효성 검사

- [x] 입력 시작에 공백이 입력되지 않았는지 확인
- [x] 콤마(,)로 구분하여 입력했는지 확인
- [x] 입력값이 숫자가 맞는지 확인
- [ ] 2개의 숫자를 입력했는지 확인
- [ ] 입력된 숫자가 1~8 사이의 수가 맞는지 확인
- [ ] 입력된 숫자가 중복되지 않았는지 확인

### 😱 예외 처리

- [ ] 잘못된 값 입력 시 에러 메세지 출력
- [ ] 해당 부분부터 다시 입력 받는 기능

### 🔢 숫자 배열 생성하는 기능

```
<숫자 배열 조건>
1. 8개의 숫자 (길이 == 8)
2. 1 이상 8 이하의 숫자
3. 중복 없는 서로 다른 숫자
e.g. [1, 5, 8, 2, 6, 7, 3, 4]
```

- [x] 1~8의 수를 가진 랜덤한 배열 생성

### 🔁 배열에서 두 숫자(원소)의 위치를 서로 바꾸는 기능

- [x] 배열에서 특정 두 값의 위치를 서로 바꾸는 기능
    - [x] 배열에서 특정 값의 위치를 찾는 기능
    - [x] 배열에서 특정 값의 위치를 특정 인덱스로 바꾸는 기능 (위치변경)

### 🔎 배열 정렬 여부 확인하는 기능

- [x] 배열이 오름차순으로 정렬되어 있는지 확인하는 기능

### 🤯 추가 예외 사항
