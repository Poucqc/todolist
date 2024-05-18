# TODOLIST 
## v 0.0.1
### 기능소개
 1. 조회 (getAllTodos) : 작성된 Todo 를 작성일 내림차순 리스트로 받아 올 수 있습니다.
 2. 개별 조회 (getTodoById) : 특정 Todo 를 받아 올 수 있습니다
 3. Todo 생성 (creatTodo) : Todo를 생성할 수 있습니다. request 는 author, title, content(nullable) 입니다.
 4. Todo 수정 (updateTodo) : 특정 Todo 를 수정할 수 있습니다. request 는 title, content(nullable) 입니다. 작성시간은 변경되지 않습니다
 5. Todo 삭제 (deleteTodo) : 특정 Todo 를 삭제할 수 있습니다
---------------
## v 0.0.2
### 추가 기능 소개
 1. 조회 : 작성일 오름차순 리스트 조회를 추가했습니다
 2. 완료 여부 : 개별 Todo 에 완료 여부를 추가했습니다 기본값은 false(완료 안됨) 이며 완료된 항목을 ture(완료) 입니다
 3. 완료 체크 : markTodoAsdone 메서드를 사용해 개별 Todo 의 상태를 true(완료) 로 바꿀 수 있습니다
 4. 완료 조회 : getByIsDoneStatusTodos 메서드의 매개변수(Boolean) 을 지정해 각각 상태에 대한 Todo 만 조회 할 수 있습니다
 5. 댓글 : 개별 Todo 에 댓글을 작성 할 수 있는 기능을 추가했습니다
 6. 댓글 작성 : addComment 메서드로 개별 Todo 에 댓글을 작성 할 수 있습니다 댓글 입력시 비밀번호가 필요합니다
 7. 댓글 수정, 삭제 : 해당 댓글을 수정, 삭제할 수 있습니다 단, 작성시 입력한 비밀번호가 일치 할 시 작동합니다
 8. 비밀번호관리 : 입력된 비밀번호는 SpringBoot 의 BCryptPasswordEncoer 를 통해 해쉬화 되어 안전하게 db에 저장됩니다
-----------------
DDD / UCD / ERD / API 명세서 : https://savory-ferret-a1e.notion.site/30dcb64193cb45769c9ea95c40c65956?pvs=4 <br>
Language : Kotlin <br>
Framework : Spring boot <br>
DB : Supabase | PorgreSQL <br>
API TEST : Swagger <br>
