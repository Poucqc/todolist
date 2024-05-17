## TODOLIST v 0.0.1
### 기능소개
 1. 조회 (getAllTodos) : 작성된 Todo 를 작성일 내림차순 리스트로 받아 올 수 있습니다.
 2. 개별 조회 (getTodoById) : 특정 Todo 를 받아 올 수 있습니다
 3. Todo 생성 (creatTodo) : Todo를 생성할 수 있습니다. request 는 author, title, content(nullable) 입니다.
 4. Todo 수정 (updateTodo) : 특정 Todo 를 수정할 수 있습니다. request 는 title, content(nullable) 입니다. 작성시간은 변경되지 않습니다
 5. Todo 삭제 (deleteTodo) : 특정 Todo 를 삭제할 수 있습니다
---------------
DDD / UCD / ERD / API 명세서 : https://savory-ferret-a1e.notion.site/30dcb64193cb45769c9ea95c40c65956?pvs=4 <br>
Language : Kotlin <br>
Framework : Spring boot <br>
DB : Supabase | PorgreSQL <br>
API TEST : Swagger <br>
