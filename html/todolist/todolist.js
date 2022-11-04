document.addEventListener('DOMContentLoaded', ()=> {
    // 문서객체 생성
    const input = document.querySelector('#newTodo');
    const addBtn = document.querySelector('#addBtn');
    const todolist = document.querySelector('#todoList');
    let cnt = 0;

    // 핸들러 함수
    const addTodo = ()=>{
        // console.log(input.value);
        if(input.value.trim() ===''){
            alert('할일을 입력해주세요.');
            return;
        }


        // 동적으로 추가할 엘리먼트 생성
        const newDiv = document.createElement('div');
        const checkbox = document.createElement('input');
        const todo = document.createElement('span');
        const btn = document.createElement('button');

        newDiv.appendChild(checkbox);
        newDiv.appendChild(todo);
        newDiv.appendChild(btn);

        // 속성 설정
        newDiv.style.padding = '10px';
        let key = cnt++;

        newDiv.setAttribute('data-key', key);

        checkbox.type = 'checkbox';
        todo.textContent = input.value;
        btn.textContent = '할일 삭제';

        // 이벤트 적용
        checkbox.addEventListener('change', (event)=> {
            todo.style.textDecoration = event.target.checked ? 'line-through' : '';
        });

        btn.addEventListener('click', () => {
            removeTodo(key)
        });

        // todoList에 새로운 div 추가
        todoList.appendChild(newDiv);
        input.value = '';
    };
    const removeTodo = function(key){
        const delElement = document.querySelector(`div[data-key='${key}']`);
        todoList.removeChild(delElement);
    };

    // 이벤트 연결
    addBtn.addEventListener('click', addTodo)
});