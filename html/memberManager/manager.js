let jsonData;
document.addEventListener('DOMContentLoaded', ()=> {
    let a;
    if(localStorage.length ==0){
        a = 1;
    }
    else {
        a = localStorage.length;
    }
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
    
    if(localStorage.length == 0){
        const list = document.querySelector('#list');
        let tr = document.createElement(`tr`);
        tr.setAttribute('id', 'm');
        tr.innerHTML =
        `<td colspan=5>입력된 데이터가 없습니다.</td>`;
        list.append(tr);
    }else{
        for(i=1; i<=localStorage.length; i++){
            jsonData = JSON.parse(localStorage.getItem('member'+i));
            
            if(jsonData){
                const list = document.querySelector('#list');
                let tr = document.createElement(`tr`);
                tr.setAttribute('id', 'm'+jsonData.index);
                tr.innerHTML = 
                `<td>${jsonData.index}</td>
                <td>${jsonData.id}</td>
                <td>${jsonData.pwd}</td>
                <td>${jsonData.name}</td>
                <td>
                    <input type=button class="rmBtn" id="rmBtn${jsonData.index}" value="삭제">
                    <input type=button class="editPopBtn" id="editPopBtn${jsonData.index}" value="수정">
                </td>`;
                list.append(tr);
            }
        }
    }
    // localStorage.getItem('member');
    submitBtn.addEventListener('click', (event) =>{
        ++a
        event.preventDefault();
        const spanCnt = document.querySelectorAll('span');
        const list = document.querySelector('#list');
        if(spanCnt.length > 0){
            alert('정확히 입력');
            return;
        }
        else if(spanCnt.length === 0){
            if(userId.value === ''){
                alert('아이디 입력');
                return;
            }
            else if(userPwd.value === ''){
                alert('패스워드 입력');
                return;
            }
            else if(userRePwd.value === ''){
                alert('패스워드 확인 입력');
                return;
            }
            else if(userName.value === ''){
                alert('이름 입력');
                return;
            }
        }

        let arr = {
            index:a, 
            id:userId.value, 
            pwd:userPwd.value, 
            name:userName.value
            };

        if(localStorage.length == 0){
            document.getElementById('m').remove();
        }

        localStorage.setItem('member'+a, JSON.stringify(arr))

        let jsonData = JSON.parse(localStorage.getItem('member'+a));

        let tr = document.createElement(`tr`);
        tr.setAttribute('id', 'm'+jsonData.index);
        tr.innerHTML = 
        `<td>${jsonData.index}</td>
        <td>${jsonData.id}</td>
        <td>${jsonData.pwd}</td>
        <td>${jsonData.name}</td>
        <td>
            <input type=button class="rmBtn" id="rmBtn${jsonData.index}" value="삭제">
            <input type=button class="editPopBtn" id="editPopBtn${jsonData.index}" value="수정">
        </td>`;

        list.append(tr);
        
        let rmBtn = document.querySelector(`#rmBtn${jsonData.index}`);
        rmBtn.addEventListener('click', ()=>{
            localStorage.removeItem('member'+jsonData.index);
            document.getElementById(`m${jsonData.index}`).remove();
            if(localStorage.length==0){
                const list = document.querySelector('#list');
                let tr = document.createElement(`tr`);
                tr.setAttribute('id', 'm');
                tr.innerHTML =
                `<td colspan=5>입력된 데이터가 없습니다.</td>`;
                list.append(tr);
            }
        });
    
        let editPopBtn = document.querySelector(`#editPopBtn${jsonData.index}`);
        editPopBtn.addEventListener('click', ()=>{
            let popDiv = document.getElementById('editFormArea');
            popDiv.style.display ='block';
            const index = document.getElementById('index');
            const editId = document.getElementById('editId');
            index.value = jsonData.index;
            editId.value = jsonData.id;
        });

        let editBtn = document.querySelector('#editBtn');
        editBtn.addEventListener('click', (event) =>{
            let id = document.getElementById('editId').value;
            let pwd = document.getElementById('editPw').value;
            let rePwd = document.getElementById('editRePw').value;
            let name = document.getElementById('editName').value;
            let index = document.getElementById('index').value;
            let arr2 = {
                index:index, 
                id:id, 
                pwd:pwd, 
                name:name
                };
            if(id!=null && pwd!=null && name!=null){
                localStorage.setItem('member'+index, JSON.stringify(arr2))
            }
            else{
                alert("입력이 필요합니다.")
            }
        })
    });


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
            if(val != userPwd.value){
                const msgRePwd = document.createElement('span');
                msgRePwd.setAttribute('id', 'rePwdSpan');
                msgRePwd.textContent='비밀번호가 다릅니다.';
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
    
    // editPopBtn.addEventListener('click', editMember)
});

function editMemberClose(){
    console.log("pop");
    document.getElementById('editFormArea').style.display = 'none';
}
