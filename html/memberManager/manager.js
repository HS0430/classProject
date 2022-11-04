let a = 1;
document.addEventListener('DOMContentLoaded', ()=> {
    const regForm = document.querySelector('#regForm');
    const userId = document.querySelector('#userID');
    const userPwd = document.querySelector('#pw');
    const userRePwd = document.querySelector('#repw');
    const userName = document.querySelector('#userName');
    const submitBtn = document.querySelector('#submitBtn');
    const resetBtn = document.querySelector('#resetBtn');
    const divId = document.querySelector('#idMsg');
    const divPwd = document.querySelector('#pwdMsg');
    const divRePwd = document.querySelector('#rePwdMsg');
    const divName = document.querySelector('#userNameMsg');
    
    // localStorage.getItem('member');
    
    submitBtn.addEventListener('click', (event) =>{
        event.preventDefault();
        const spanCnt = document.querySelectorAll('span');
        const list = document.querySelector('#list');
        if(spanCnt.length > 0){
            alert('정확히 입력');
        }
        else if(spanCnt.length === 0){
            if(userId.value === ''){
                alert('아이디 입력');
            }
            else if(userPwd.value === ''){
                alert('패스워드 입력');
            }
            else if(userRePwd.value === ''){
                alert('패스워드 확인 입력');
            }
            else if(userName.value === ''){
                alert('이름 입력');
            }
        }

        let arr = {
            index:a++, 
            id:userId.value, 
            pwd:userPwd.value, 
            name:userName.value
            };

        localStorage.setItem('member'+a, JSON.stringify(arr))

        let jsonData = JSON.parse(localStorage.getItem('member'+a));

        let tr = document.createElement(`tr`);
        tr.setAttribute('id', jsonData.index);
        tr.innerHTML = 
        `<td>${jsonData.index}</td>
        <td>${jsonData.id}</td>
        <td>${jsonData.pwd}</td>
        <td>${jsonData.name}</td>
        <td>
            <input type=button class="rmBtn" id="rmBtn${jsonData.index}" value="삭제">
        </td>`;

        list.append(tr);
        
        let rmBtn = document.querySelector(`#rmBtn${jsonData.index}`);
            console.log(rmBtn);
            console.log(jsonData.index);
        rmBtn.addEventListener('click', ()=>{
            localStorage.removeItem('member'+jsonData.index+1);
            // list.removeChild(`#${jsonData.index+1}`);
        });

        // <tr>
        // <th>순번(index)</th>
        // <th>아이디</th>
        // <th>비밀번호</th>
        // <th>이름</th>
        // <th>관리</th>
        // </tr>

        // regForm.submit();
    })
    resetBtn.addEventListener('click', ()=>{
        userId.textContent ='';
        userPwd.textContent='';
        userRePwd.textContent='';
        userName.textContent='';

        for(let i=0; i<=a; i++){
            localStorage.removeItem('member'+i);
        }
    })



    userId.addEventListener('focusout', (event) =>{
        const val = event.target.value;
        if(!(val === '')){
            if(!(/[a-zA-Z0-9]/.test(val))){
                const msgId = document.createElement('span');
                msgId.setAttribute('id', 'idSpan');
                msgId.textContent='입력이 바르지 않습니다.';
                msgId.style.color='red';
                msgId.style.fontSize='small';
                divId.appendChild(msgId);
            }
        }
    });
    userId.addEventListener('focusin', (event) =>{
        if(divId.childElementCount > 0){
            const idSpan = document.querySelector('#idSpan');
            divId.removeChild(idSpan);
        }
    });

    userPwd.addEventListener('focusout', (event) =>{
        const val = event.target.value;
        if(!(val === '')){
            if(!(/[a-zA-Z0-9]/.test(val))){
                const msgPwd = document.createElement('span');
                msgPwd.setAttribute('id', 'pwdSpan');
                msgPwd.textContent='입력이 바르지 않습니다.';
                msgPwd.style.color='red';
                msgPwd.style.fontSize='small';
                divPwd.appendChild(msgPwd);
            }
        }
    });
    userPwd.addEventListener('focusin', (event) =>{
        if(divPwd.childElementCount > 0){
            const pwdSpan = document.querySelector('#pwdSpan');
            divPwd.removeChild(pwdSpan);
        }
    });

    userRePwd.addEventListener('focusout', (event) =>{
        const val = event.target.value;
        if(!(val === '')){
            if(!(/[a-zA-Z0-9]/.test(val))){
                const msgRePwd = document.createElement('span');
                msgRePwd.setAttribute('id', 'rePwdSpan');
                msgRePwd.textContent='입력이 바르지 않습니다.';
                msgRePwd.style.color='red';
                msgRePwd.style.fontSize='small';
                divRePwd.appendChild(msgRePwd);
            }
        }
    });
    userRePwd.addEventListener('focusin', (event) =>{
        if(divRePwd.childElementCount > 0){
            const rePwdSpan = document.querySelector('#rePwdSpan');
            divRePwd.removeChild(rePwdSpan);
        }
    });

    userName.addEventListener('focusout', (event) =>{
        const val = event.target.value;
        if(!(val === '')){
            if(!(/[a-zA-Z0-9]/.test(val))){
                const msgName = document.createElement('span');
                msgName.setAttribute('id', 'nameSpan');
                msgName.textContent='입력이 바르지 않습니다.';
                msgName.style.color='red';
                msgName.style.fontSize='small';
                divName.appendChild(msgName);
            }
        }
    });
    userName.addEventListener('focusin', (event) =>{
        if(divName.childElementCount > 0){
            const nameSpan = document.querySelector('#nameSpan');
            divName.removeChild(nameSpan);
        }
    });
    
});
