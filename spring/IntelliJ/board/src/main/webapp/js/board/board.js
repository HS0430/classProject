document.addEventListener('DOMContentLoaded', ()=> {
    boardList();
    const searchBtn = document.querySelector("#searchBtn");

    searchBtn.addEventListener('click', (event) => {
        boardList();
    })
});

function PageMove(page){
    boardList(page);
}

function boardList(page){
    const searchType = document.getElementById('searchType').value;
    const keyword = document.querySelector("#keyword").value;
    $.ajax({
        url : "listGet",
        type : "get",
        dataType : "json",
        data : { page : page,
                 searchType : searchType,
                 keyword : keyword
        },
        success : function(data) {
            const list = document.querySelector('#blist');
            console.log(data.bList);
            console.log(data.paging);

            if(data.bList.length < 1){
                console.log(data.bList.length);
                $('tr td').remove();
                let tr = document.createElement(`tr`);
                tr.innerHTML =
                `<td colspan=5 style="text-align: center">조회된 데이터가 없습니다.</td>`;
                list.append(tr);
            }
            else {
                $('tr td').remove();
                // $(data).each(function(){
                for (var i = 0; i < data.bList.length; i++) {
                    let tr = document.createElement(`tr`);
                    tr.innerHTML = `
                <td>${data.bList[i].rnum}</td>
                <td><a href="/board/modify?bno=${data.bList[i].bno}">${data.bList[i].title}</a></td>
                <td>${data.bList[i].writer}</td>
                <td>${data.bList[i].regdate}</td>
                <td>${data.bList[i].updatedate}</td>
                `;
                    list.append(tr);
                    // })
                }
            }
            let htmlStr = makePaging(data.paging);
            // let sorter = document.querySelector('#psorter');
            // sorter.append(htmlStr);
            $("#psorter").html(htmlStr);
        },
        error : function() {
            console.log("error");
        }
    });
}

function makePaging(paging){
    var pageUrl = "";
    pageUrl += "<ul class='pagination justify-content-center'>";
    pageUrl += "<li class='page-item'>";
    pageUrl += "<a class='page-link' href='javascript:PageMove("+paging.firstPageNo+")'> << </a>";
    pageUrl += "</li>";
    pageUrl += "<li class='page-item'>";
    pageUrl += "<a class='page-link' href='javascript:PageMove("+paging.prevPageNo+")'> < </a>";
    pageUrl += "</li>";
    for(var i=paging.startPageNo; i<=paging.endPageNo; i++){
        if (i == paging.pageNo){
            pageUrl += "<li class='page-item'><a class='page-link' href='javascript:PageMove("+i+")'>"+i+"</a></li>";
        }
        else{
            pageUrl += "<li class='page-item'><a class='page-link' href='javascript:PageMove("+i+")'>"+i+"</a></li>";
        }
    }
    pageUrl += "<li class='page-item'>";
    pageUrl += "<a class='page-link' href='javascript:PageMove("+paging.nextPageNo+")'> > </a>";
    pageUrl += "</li>";
    pageUrl += "<li class='page-item'>";
    pageUrl += "<a class='page-link' href='javascript:PageMove("+paging.finalPageNo+")'> >> </a>";
    pageUrl += "</li>";
    pageUrl += "</ul>";

    return pageUrl;
}