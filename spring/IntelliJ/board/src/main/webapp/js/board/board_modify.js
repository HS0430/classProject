document.addEventListener('DOMContentLoaded', ()=> {
    replyList();

    let replyAddBtn = document.querySelector('#replyAddBtn');
    replyAddBtn.addEventListener('click', (event) =>{
        replyPop();
        // let id = document.getElementById('editId').value;
        // let pwd = document.getElementById('editPw').value;
        // let rePwd = document.getElementById('editRePw').value;
        // let name = document.getElementById('editName').value;
        // let index = document.getElementById('index').value;
        // let arr2 = {
        //     index:index,
        //     id:id,
        //     pwd:pwd,
        //     name:name
        // };
        // if(id!=null && pwd!=null && name!=null){
        //     localStorage.setItem('member'+index, JSON.stringify(arr2))
        // }
        // else{
        //     alert("입력이 필요합니다.")
        // }
    });
    let rmClose = document.querySelector('#rmClose');
    rmClose.addEventListener('click', (event) =>{
        document.getElementById('replymodal').style.display = 'none';
    });
    let rmClose2 = document.querySelector('#rmClose2');
    rmClose2.addEventListener('click', (event) =>{
        document.getElementById('replymodal').style.display = 'none';
    });

    let rmReg = document.querySelector('#rmReg');
    rmReg.addEventListener('click', (event)=>{
        regReply();
    })
});

function replyList(){
    let bno = document.getElementById("bno").value;
    const reply_area = document.querySelector('#reply_area');
    console.log(bno);
        $.ajax({
            url : "replyList",
            type : "get",
            dataType : "json",
            data : { bno : bno
            },
            success : function(data) {
                if(data.replyList.length < 1){
                    console.log(data);
                    $('reply_area div').empty();
                    $("#replyCount").html(data.replyCount);
                    let div = document.createElement(`div`);
                    div.innerHTML =
                        `
                        <div class="media text-muted pt-3">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            <strong class="d-block text-gray-dark"> 등록된 댓글이 없습니다. </strong>
                        </p>
                        `
                    reply_area.append(div);
                }
                else {
                    console.log(data);
                    $('#reply_area').empty();
                    $("#replyCount").html(data.replyCount);
                        document.getElementById("replyCount").value = replyCount;
                    // $(data).each(function(){
                    for (var i = 0; i < data.replyList.length; i++) {
                        let div = document.createElement(`div`);
                        div.innerHTML = `
                        <div class="media text-muted pt-3">
                        <input type="hidden" name="rno" id="rno" value="${data.replyList[i].rno}">
                                 <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                                     <strong class="d-block text-gray-dark">${data.replyList[i].replyer}</strong>
                                     ${data.replyList[i].reply}
                                     <span style="float: right">
                                      Modified ${data.replyList[i].updateDate}
                                      <button onclick="replyDelete(${data.replyList[i].rno})" class="btn-close"/>
                                      </span>
                                 </p>
                        </div>
                        `;

                        reply_area.append(div);
                    }
                }
            },
            error : function() {
                console.log("error");
            }
        });
}

function replyPop(bno, writer){
    document.getElementById('replymodal').style.display='block';
}

function regReply() {
    let replyBno = document.getElementById("replyBno").value;
    let replyContent = document.getElementById("replyContent").value;
    // let replyWriter = document.getElementById("replyWriter").value;
    let replyWriter = document.getElementById("realName").value;

    $.ajax({
        url: "replyReg",
        type: "post",
        data: {
            bno: replyBno,
            reply: replyContent,
            replyer: replyWriter
        },
        success: function (data) {
            document.getElementById('replymodal').style.display = 'none';
            replyList();
        },
        error: function () {
            console.log("error");
        }
    });
}

function replyDelete(rno){
    // let rno = document.getElementById("rno").value;
    $.ajax({
        url: "replyDelete?rno="+rno,
        type: "get",
        data: {
            rno: rno
        },
        success: function (data) {
            $('#reply_area').empty();
            replyList();
        },
        error: function () {
            console.log("error");
        }
    });
}