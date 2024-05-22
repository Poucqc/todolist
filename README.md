# TODOLIST
## 목차
- [v0.0.1](#v001)
- [v0.0.2](#v002)
- [v0.0.3](#v003)
- [v1.0.0](#v100)

## v0.0.1

### 기능소개

1. 조회 (getAllTodos) : 작성된 Todo 를 작성일 내림차순 리스트로 받아 올 수 있습니다.
2. 개별 조회 (getTodoById) : 특정 Todo 를 받아 올 수 있습니다
3. Todo 생성 (creatTodo) : Todo를 생성할 수 있습니다. request 는 author, title, content(nullable) 입니다.
4. Todo 수정 (updateTodo) : 특정 Todo 를 수정할 수 있습니다. request 는 title, content(nullable) 입니다. 작성시간은 변경되지 않습니다
5. Todo 삭제 (deleteTodo) : 특정 Todo 를 삭제할 수 있습니다
6. id 검증 : 개별 Todo 에 대해 조회, 수정, 삭제시 해당 id 가 없을경우 에외처리 ModelNotFound 가 실행됩니다

-----------------------------------------

### DDD v0.0.1

<img width="3184" alt="DDD v0 0 1" src="https://github.com/Poucqc/todolist/assets/163396796/86daae99-81b5-450e-aa12-6daf7cb72496">

### UCD v0.0.1

![UCD v0 0 1](https://github.com/Poucqc/todolist/assets/163396796/11634feb-fd8f-4378-945f-7cbfe34f583a)

### ERD v0.0.1

![ERD v0 0 1 수정본](https://github.com/Poucqc/todolist/assets/163396796/adb2d944-dcc8-4925-b969-97bc280fc2ad)

### API 명세서 v0.0.1 
(상세 body 는 Notion 에 게재해 두었습니다)

<table>
  <tr>
    <th>설명</th>
    <th>method</th>
    <th>End point</th>
    <th>Request</th>
    <th>Status</th>
    <th>Response</th>
  </tr>
  <tr>
    <td>목록조회</td>
    <td>GET</td>
    <td>/todos</td>
    <td></td>
    <th>202 OK</th>
    <th>Todo 목록</th>

  </tr>
  <tr>
    <td>개별조회</td>
    <td>GET</td>
    <td>/todos/{todo-Id}</td>
    <td>todoId</td>
    <th>202 OK</th>
    <th>해당 ID Todo</th>
  </tr>
  <tr>
    <td>생성</td>
    <td>POST</td>
    <td>/todos</td>
    <td>author,title,content</td>
    <th>201 CREATED</th>
    <th>작성된 Todo</th>
  </tr>
  <tr>
    <td>수정</td>
    <td>PUT</td>
    <td>/todos/{todo-id}</td>
    <td>title,content</td>
    <th>202 OK</th>
    <th>수정된 Todo</th>
  </tr>
  <tr>
    <td>삭제</td>
    <td>DELETE</td>
    <td>/todos/{todo-id}</td>
    <td></td>
    <th>204 NO CONTENT</th>
    <th></th>
  </tr>
</table>

-------------------------

## v0.0.2

### 추가 기능 소개

1. 조회 : 작성일 오름차순 리스트 조회를 추가했습니다
2. 완료 여부 : 개별 Todo 에 완료 여부를 추가했습니다 기본값은 false(완료 안됨) 이며 완료된 항목을 ture(완료) 입니다
3. 완료 체크 : markTodoAsdone 메서드를 사용해 개별 Todo 의 상태를 true(완료) 로 바꿀 수 있습니다
4. 완료 조회 : getByIsDoneStatusTodos 메서드의 매개변수(Boolean) 을 지정해 각각 상태에 대한 Todo 만 조회 할 수 있습니다
5. 댓글 : 개별 Todo 에 댓글을 작성 할 수 있는 기능을 추가했습니다
6. 댓글 조회 : 개별 조회 사용시 그곳에 작성된 댓글도 같이 조회되도록 했습니다
7. 댓글 작성 : addComment 메서드로 개별 Todo 에 댓글을 작성 할 수 있습니다 댓글 입력시 비밀번호를 같이 입력 받습니다
8. 댓글 수정, 삭제 : 해당 댓글을 수정, 삭제할 수 있습니다 단, 작성시 입력한 비밀번호가 일치 할 시 작동합니다
9. 비밀번호 관리 : 입력된 비밀번호는 SpringBoot 의 BCryptPasswordEncoer 를 통해 해쉬화 되어 안전하게 db에 저장됩니다
10. id 검증 : Todo 와 마찬가지로 Comment 의 id 검증 과 예외처리가 실행됩니다
11. 비밀번호 검증 : 비밀번호가 틀렸을시 PasswordNotMatchedException 이 실행됩니다
-------------------------------
### DDD v0.0.2
![DDD v0.0.2](https://savory-ferret-a1e.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2F072a7b34-9d68-4308-8eb5-c7ecaf395620%2FDDD_v0.0.2.jpg?table=block&id=ff86ba68-e25d-431f-acc1-05e9debadc41&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=2000&userId=&cache=v2)
v0.0.21
![DDD v0.0.21](https://savory-ferret-a1e.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2F5b5a53c8-1c07-4b30-ae50-989cd07e6baa%2FDDD_v0.0.21.jpg?table=block&id=d52ae270-c152-4284-ad10-dd01b70a5283&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=1360&userId=&cache=v2)

### UCD v0.0.2
![UCD v0.0.2](https://savory-ferret-a1e.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2Fdfee101c-c5bc-417f-a5da-9c1e5133efe8%2FUCD_v0.0.2.jpg?table=block&id=07f7ed76-6b0e-45f1-8ebf-ff649e7eca5f&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=2000&userId=&cache=v2)
v0.0.21
![UCD v0.0.21](https://savory-ferret-a1e.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2F1bebc3ee-1b0f-4705-abea-3a487d98f5bd%2FUCD_v0.0.21.jpg?table=block&id=fee37898-dc8b-4f3f-a2cd-5322a6bec46a&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=2000&userId=&cache=v2)

### ERD v0.0.2
![설명](https://savory-ferret-a1e.notion.site/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2Ffc9cea2b-ebf3-41a1-9f9c-1019337c7a0d%2FERD_v0.0.2.png?table=block&id=b9ac54f2-1988-46f0-95da-36f2468e11c3&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=2000&userId=&cache=v2)

### API 명세서 v0.0.2
(상세 body 는 Notion 에 게재해 두었습니다)
<table>
  <tr>
    <th>설명</th>
    <th>method</th>
    <th>End point</th>
    <th>Request</th>
    <th>Status</th>
    <th>Response</th>
  </tr>
  <tr>
    <td>목록조회 내림차순</td>
    <td>GET</td>
    <td>/todos/desc</td>
    <td></td>
    <th>202 OK</th>
    <th>Todo 목록 내림차순 정렬</th>
  </tr>
  <tr>
    <td>목록조회 오름차순</td>
    <td>GET</td>
    <td>/todos/asc</td>
    <td></td>
    <th>202 OK</th>
    <th>Todo 목록 오름차순 정렬</th>
  </tr>
  <tr>
    <td>개별조회</td>
    <td>GET</td>
    <td>/todos/{todo-Id}</td>
    <td>todoId</td>
    <th>202 OK</th>
    <th>해당 ID Todo와 댓글</th>
  </tr>
  <tr>
    <td>생성</td>
    <td>POST</td>
    <td>/todos</td>
    <td>author,title,content</td>
    <th>201 CREATED</th>
    <th>작성된 Todo와 댓글</th>
  </tr>
  <tr>
    <td>수정</td>
    <td>PUT</td>
    <td>/todos/{todo-id}</td>
    <td>title,content</td>
    <th>202 OK</th>
    <th>수정된 Todo와 댓글</th>
  </tr>
  <tr>
    <td>삭제</td>
    <td>DELETE</td>
    <td>/todos/{todo-id}</td>
    <td></td>
    <th>204 NO CONTENT</th>
    <th></th>
  </tr>
  <tr>
    <td>댓글 작성</td>
    <td>POST</td>
    <td>/todos/{todo-id}</td>
    <td>author,password,commentText</td>
    <th>202 OK</th>
    <th>해당 Todo 와 댓글</th>
  </tr>
  <tr>
    <td>댓글 수정</td>
    <td>PATCH</td>
    <td>/todos/{todo-id}/{comment-id}</td>
    <td>password,commentText</td>
    <th>202 OK</th>
    <th>해당 Todo 와 댓글</th>
  </tr>
  <tr>
    <td>댓글 삭제</td>
    <td>DELETE</td>
    <td>/todos/{todo-id}/{comment-id}</td>
    <td>password</td>
    <th>204 NO CONTENT</th>
    <th></th>
  </tr>
</table>

-----------------------
## v0.0.3 ( 이 버전은 branch v0.0.3 에 개제되어 있습니다 )

### 추가기능소개
1. 작성일별 오름차순,내림차순 조회 기능을 하나의 메서드로 합쳤습니다
2. 작성자별 Todo 목록 조회 기능을 추가했습니다 (일치하는 작성자가 없을 시 빈 목록이 반환됩니다)
4. 양식확인 : Todo 와 댓글 작성시 적절한 양식에 따라 작성하지 않는 경우 예외 처리가 발생합니다
    ( Todo 제목 : 1~200 , Todo 본문 : 1~1000 , 댓글 내용 : 1~50 )


-----------------------------------------

### DDD v0.0.3
![DDD v0.0.3](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2Fed8a739c-ebd5-4686-8666-1bde504d1e73%2FDDD_v0.0.3.jpg?table=block&id=33fd64a3-7d31-4390-84e9-27dcf263f301&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=2000&userId=131562d9-a5ac-40fb-acae-5482c29c5c70&cache=v2)


### UCD v0.0.3
![UCD v0.0.3](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2Fb8bbfe07-c751-4d1d-80d4-1e531de39b88%2FUCD_v0.0.3.jpg?table=block&id=6a082078-9393-4926-a9b0-febd42cbe218&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=2000&userId=131562d9-a5ac-40fb-acae-5482c29c5c70&cache=v2)


### ERD v0.0.3
![ERD v0.0.3](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F5a8e769b-f50a-42c1-92fb-1eda9e56a0ab%2F65fbb889-854a-4623-aaba-c3ddbc461c15%2FERD_v0.0.3.png?table=block&id=aba5cf63-3be7-4731-bc5c-41817699f4f2&spaceId=5a8e769b-f50a-42c1-92fb-1eda9e56a0ab&width=2000&userId=131562d9-a5ac-40fb-acae-5482c29c5c70&cache=v2)


### API 명세서 v0.0.3
(상세 body 는 Notion 에 게재해 두었습니다)

<table>
  <tr>
    <th>설명</th>
    <th>method</th>
    <th>End point</th>
    <th>Request</th>
    <th>Status</th>
    <th>Response</th>
  </tr>
  <tr>
    <td>목록조회</td>
    <td>GET</td>
    <td>/todos/{sort-field}</td>
    <td>asc or desc</td>
    <th>202 OK</th>
    <th>정렬된 Todo 목록</th>
  </tr>
  <tr>
    <td>목록조회 완료별</td>
    <td>GET</td>
    <td>/todos/{is-done}</td>
    <td>done : Boolean</td>
    <th>202 OK</th>
    <th>해당 완료 상태의 Todo 목록</th>
  </tr>
   <tr>
    <td>목록조회 작성자별</td>
    <td>GET</td>
    <td>/todos/{author}</td>
    <td>author</td>
    <th>202 OK</th>
    <th>해당 작성자가 작성한 Todo 목록</th>
  </tr>
  <tr>
    <td>개별조회</td>
    <td>GET</td>
    <td>/todos/{todo-Id}</td>
    <td>todoId</td>
    <th>202 OK</th>
    <th>해당 ID Todo와 댓글</th>
  </tr>
  <tr>
    <td>생성</td>
    <td>POST</td>
    <td>/todos</td>
    <td>author,title,content</td>
    <th>201 CREATED</th>
    <th>작성된 Todo와 댓글</th>
  </tr>
  <tr>
    <td>수정</td>
    <td>PUT</td>
    <td>/todos/{todo-id}</td>
    <td>title,content</td>
    <th>202 OK</th>
    <th>수정된 Todo와 댓글</th>
  </tr>
  <tr>
    <td>삭제</td>
    <td>DELETE</td>
    <td>/todos/{todo-id}</td>
    <td></td>
    <th>204 NO CONTENT</th>
    <th></th>
  </tr>
  <tr>
    <td>댓글 작성</td>
    <td>POST</td>
    <td>/todos/{todo-id}</td>
    <td>author,password,commentText</td>
    <th>202 OK</th>
    <th>해당 Todo 와 댓글</th>
  </tr>
  <tr>
    <td>댓글 수정</td>
    <td>PATCH</td>
    <td>/todos/{todo-id}/{comment-id}</td>
    <td>password,commentText</td>
    <th>202 OK</th>
    <th>해당 Todo 와 댓글</th>
  </tr>
  <tr>
    <td>댓글 삭제</td>
    <td>DELETE</td>
    <td>/todos/{todo-id}/{comment-id}</td>
    <td>password</td>
    <th>204 NO CONTENT</th>
    <th></th>
  </tr>
</table>

-----------------
DDD / UCD / ERD / API 명세서 : https://savory-ferret-a1e.notion.site/30dcb64193cb45769c9ea95c40c65956?pvs=4 <br>
Language : Kotlin <br>
IDE : IntelliJ <br>
SDK : termurin-17 java version 17.0.11 <br>
JDK: Eclipse Adoptium\jdk-17.0.11.9-hotspot <br>
Framework : Spring Boot v.3.2.5 <br>
DB : Supabase | Postgres <br>
API TEST : Swagger
