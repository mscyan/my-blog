function upload_file(url, method){
    var fileBtn = document.getElementById("file");

    if(fileBtn.files[0] === undefined){
        alert("please select a file");
    }
    else{
        var totalName = fileBtn.files[0].name;
        if(totalName.lastIndexOf('.') === -1){
            alert("this file is not Suitable");
        }
        else{
            var tailName = totalName.substring(totalName.lastIndexOf('.') + 1, totalName.length);
            if(tailName === 'jpg' || tailName === 'png' || tailName === "jpeg" || tailName === "gif"){
                var fd = new FormData();
                fd.append('file', fileBtn.files[0]);
                var xhr = new XMLHttpRequest();
                xhr.open(method, url, true);
                xhr.send(fd);
                xhr.onreadystatechange = function(){
                    if(xhr.readyState === 4 && xhr.status === 200){
                        var response  = JSON.parse(xhr.responseText);
                        var link = response.response_data;
                        document.getElementById('review').src = '/pic/getpic/' + link;
                        document.getElementById("short_link").innerText = '/pic/getpic/' + link;
                    }
                }
            }
            else{
                console.log("this file is not suitable");
            }
        }
    }
}
function tweak(){
    var param1 = document.getElementById("un").value;
    var param2 = document.getElementById("pwd").value;
    if(param1 !== undefined && param1 !== ''){
        if(param2 !== undefined && param2 !== ''){
            var xhr = new XMLHttpRequest();
            var tempInfo = {
                "username" : param1,
                "key" : param2
            };
            xhr.open('POST', '/door/login', true);
            xhr.setRequestHeader('content-type', 'application/json');
            xhr.send(JSON.stringify(tempInfo));
            xhr.onreadystatechange = function(){
                if(xhr.readyState === 4 && xhr.status === 200){
                    var response  = JSON.parse(xhr.responseText);
                    console.log(response.response_data);
                    if(response.response_data === 'success'){
                        window.location.href = "/";
                    }
                }
            };
        }
    }
}

//提交博客
function commit_blog(markdownData, htmlPrevData){
    var title = document.getElementById('title').value;
    var theme_id = document.getElementById('theme_selection').options[document.getElementById('theme_selection').selectedIndex].value;
    var abstract = document.getElementById("content-abstract").value;
    var id = -1;
    var cover = document.getElementById("cover").value;
    var readable = 1;

    var form = new FormData();
    form.append('title', title);
    form.append('markdown', markdownData);
    form.append('html', htmlPrevData);
    form.append('theme_id', theme_id);
    form.append('content_abstract', abstract);
    form.append('readable', readable);
    form.append('cover_image', cover);
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/blog/commit_blog', true);
    xhr.send(form);
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            var response  = JSON.parse(xhr.responseText);
            var message = response.response_data;
            if(message === 1){
                alert("添加成功");
            }
        }
    }
}

//todo 通用post方法
function doPost(jsonData, url) {

}
//todo 通用get方法
function doGet(url) {

}

// function doPut(jsonData, url) {
//
// }
//
// function doDelete(jsonData, url) {
//
// }