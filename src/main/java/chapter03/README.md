# 웹 서버 시작 및 테스트

* `webserver.WebServer`는 사용자의 요청을 받아 `RequestHandler`에 작업을 위임하는 클래스이다.
* 사용자 요청에 대한 모든 처리는 `RequestHandler` 클래스의 `run()` 메서드가 담당한다.
* `WebServer`를 실행한 후 브라우저에서 http://localhost:8080으로 접속해 "Hello World" 메시지가 출력되는지 확인한다.

<br/>

# 각 요구사항별 학습 내용 정리

* 구현 단계에서는 각 요구사항을 구현하는데 집중한다.
* 구현을 완료한 후 구현 과정에서 새롭게 알게된 내용, 궁금한 내용을 기록한다.
* 각 요구사항을 구현하는 것이 중요한 것이 아니라 구현 과정을 통해 학습한 내용을 인식하는 것이 배움에 중요하다.

<br/>

### 요구사항 1 - http://localhost:8080/index.html로 접속 시 응답

1. BufferedReader를 통해 HTTP Header 읽기
2. HTTP 요청 첫 번째 라인에서 요청 URL을 추출
3. 요청 URL에 해당하는 파일을 webapp 디렉터리에서 읽어 전달

<br/>

### 요구사항 2 - GET 방식으로 회원가입

* '회원가입' 메뉴 클릭 시 http://localhost:8080/user/form.html으로 이동한다.
* 회원가입을 하면 다음과 같은 형태로 사용자가 입력한 값이 서버에 전달된다.  
  /user/create?userId=javajigi&password=password&name=JaeSung&email=javajigi%40slipp.net

1. HTTP 요청 첫 번째 라인에서 요청 URL을 추출
2. 요청 URL에서 접근 경로와 `이름=값`으로 전달되는 데이터(Query String)를 추출
3. User 클래스에 정보 저장

<br/>

### 요구사항 3 - post 방식으로 회원가입

*

<br/>

### 요구사항 4 - redirect 방식으로 이동

*

<br/>

### 요구사항 5 - cookie

*

<br/>

### 요구사항 6 - stylesheet 적용

*

<br/>

### heroku 서버에 배포 후

*

<br/>
